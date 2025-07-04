package com.syndicatemc.sob.mob_effect;

import com.syndicatemc.sob.init.SOBMobEffects;
import com.syndicatemc.sob.init.SOBSounds;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class CessationEffect extends MobEffect {
    public CessationEffect() {
        super(MobEffectCategory.HARMFUL, 0x210F17);
    }

    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (entity instanceof Player player) {
            MobEffectInstance effect = player.getEffect(SOBMobEffects.CESSATION.get());
            if (effect.getDuration() < 6000 && effect.getDuration() >= 3600) {
                player.level().playSeededSound(player, player.getX(), player.getY(), player.getZ(), SOBSounds.HEARTBEAT.get(), SoundSource.PLAYERS, 0.05F, 1.0F, 1);
            } else if (effect.getDuration() < 3600 && effect.getDuration() >= 2400) {
                player.level().playSeededSound(player, player.getX(), player.getY(), player.getZ(), SOBSounds.HEARTBEAT.get(), SoundSource.PLAYERS, 0.125F, 1.0F, 1);
            } else if (effect.getDuration() < 2400 && effect.getDuration() >= 1800) {
                player.level().playSeededSound(player, player.getX(), player.getY(), player.getZ(), SOBSounds.HEARTBEAT.get(), SoundSource.PLAYERS, 0.25F, 1.0F, 1);
            } else if (effect.getDuration() < 1800 && effect.getDuration() >= 1200) {
                player.level().playSeededSound(player, player.getX(), player.getY(), player.getZ(), SOBSounds.HEARTBEAT.get(), SoundSource.PLAYERS, 0.5F, 1.0F, 1);
            } else if (effect.getDuration() < 1200 && effect.getDuration() >= 600) {
                player.level().playSeededSound(player, player.getX(), player.getY(), player.getZ(), SOBSounds.HEARTBEAT.get(), SoundSource.PLAYERS, 0.75F, 1.0F, 1);
            } else if (effect.getDuration() < 600) {
                player.level().playSeededSound(player, player.getX(), player.getY(), player.getZ(), SOBSounds.HEARTBEAT.get(), SoundSource.PLAYERS, 1.0F, 1.0F, 1);
            }
        }
    }

    public boolean isDurationEffectTick(int duration, int amplifier) {
        double scaled = Math.pow(duration / 20.0, 0.6);
        int interval = Math.max(5, (int) scaled);
        return duration % interval == 0;
    }
}
