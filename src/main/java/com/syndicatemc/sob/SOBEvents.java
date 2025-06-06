package com.syndicatemc.sob;

import com.syndicatemc.sob.init.SOBDamageTypes;
import com.syndicatemc.sob.init.SOBMobEffects;
import com.syndicatemc.sob.init.SOBSounds;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SOB.MOD_ID)
public class SOBEvents {
    @SubscribeEvent
    public static void onPlayerAttack(LivingDamageEvent event) {
        Entity entity = event.getSource().getEntity();
        Entity target = event.getEntity();
        if (entity instanceof Player player && player.hasEffect(SOBMobEffects.BITTERNESS.get())) {
            float hunger = player.getFoodData().getFoodLevel();
            float amp = player.getEffect(SOBMobEffects.BITTERNESS.get()).getAmplifier();
            float bonus = (Math.abs(hunger - 20) / 20) * ((amp + 1) / 2);
            event.setAmount(event.getAmount() * (1 + bonus));
        }
        if (target instanceof LivingEntity t && entity instanceof LivingEntity e && e.hasEffect(SOBMobEffects.RESONANCE.get()) && event.getAmount() >= 1.5 && t.invulnerableTime == 0) {
            if (!t.hasEffect(SOBMobEffects.COLLAPSE.get())) {
                t.addEffect(new MobEffectInstance(SOBMobEffects.COLLAPSE.get(), 30, 0, false, true));
                t.level().playSeededSound(null, t.getX(), t.getY(), t.getZ(), SOBSounds.COLLAPSE_BUILDING.get(), SoundSource.NEUTRAL, 1.0F, 0.9F, 1);
                return;
            }
            t.level().playSeededSound(null, t.getX(), t.getY(), t.getZ(), SOBSounds.COLLAPSE_BUILDING.get(), SoundSource.NEUTRAL, 1.0F, 0.9F, 1);
            t.addEffect(new MobEffectInstance(SOBMobEffects.COLLAPSE.get(), 30, Math.min(t.getEffect(SOBMobEffects.COLLAPSE.get()).getAmplifier() + 1, 9), false, true));
        }
    }

    @SubscribeEvent
    public static void mobEffectEvent(MobEffectEvent.Expired event) {
        Entity entity = event.getEntity();
        if (entity instanceof LivingEntity e && e.hasEffect(SOBMobEffects.COLLAPSE.get())) {
            e.hurt(SOBDamageTypes.getSimpleDamageSource(e.level(), SOBDamageTypes.COLLAPSING), (e.getEffect(SOBMobEffects.COLLAPSE.get()).getAmplifier()) * 2 + 3);
        }
    }
}
