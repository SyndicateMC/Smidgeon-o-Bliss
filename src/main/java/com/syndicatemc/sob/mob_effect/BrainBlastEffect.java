package com.syndicatemc.sob.mob_effect;

import com.syndicatemc.sob.init.SOBMobEffects;
import com.syndicatemc.sob.init.SOBSounds;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class BrainBlastEffect extends MobEffect {
    public BrainBlastEffect() {
        super(MobEffectCategory.BENEFICIAL, 0xB1FA7E);
    }

    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (entity instanceof Player player) {
            int duration = player.getEffect(SOBMobEffects.BRAIN_BLAST.get()).getDuration();
            float expLevel = player.experienceLevel;
            int newAmp = (int) Math.min(Math.floor(expLevel / 5) - 1, 9);

            player.forceAddEffect(new MobEffectInstance(SOBMobEffects.BRAIN_BLAST.get(), duration - 1, newAmp, false, true), player);
        }
    }

    public boolean isDurationEffectTick(int duration, int amplifier) {
        return duration % 20 == 0;
    }
}
