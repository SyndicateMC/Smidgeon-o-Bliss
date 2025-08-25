package com.syndicatemc.sob;

import com.syndicatemc.sob.init.*;
import com.syndicatemc.sob.init.compat.atmospheric.AtmoCompatItems;
import com.syndicatemc.sob.utility.SOBTranslationKey;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.PlayerXpEvent;
import net.minecraftforge.event.level.NoteBlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import vectorwing.farmersdelight.common.Configuration;

import java.util.List;
import java.util.Objects;

@Mod.EventBusSubscriber(modid = SOB.MOD_ID)
public class SOBEvents {
    @SubscribeEvent
    public static void onEntityAttack(LivingDamageEvent event) {
        Entity entity = event.getSource().getEntity();
        Entity target = event.getEntity();
        if (entity instanceof Player player && player.hasEffect(SOBMobEffects.BITTERNESS.get())) { //increases damage dealt based on hunger level
            float hunger = player.getFoodData().getFoodLevel();
            float amp = player.getEffect(SOBMobEffects.BITTERNESS.get()).getAmplifier();
            float bonus = (Math.abs(hunger - 20) / 20) * ((amp + 1) / 2);
            event.setAmount(event.getAmount() * (1 + bonus));
        }
        if (target instanceof LivingEntity t && entity instanceof LivingEntity e && e.hasEffect(SOBMobEffects.RESONANCE.get()) && event.getAmount() >= 1.5 && !t.isInvulnerable()) { //applies a stack of Collapse every time an entity is damaged at least 1.5 damage from an entity with the Resonance effect
            if (!t.hasEffect(SOBMobEffects.COLLAPSE.get())) {
                t.addEffect(new MobEffectInstance(SOBMobEffects.COLLAPSE.get(), 30, 0, false, true));
                t.level().playSeededSound(null, t.getX(), t.getY(), t.getZ(), SOBSounds.COLLAPSE_BUILDING.get(), SoundSource.NEUTRAL, 1.0F, 0.9F, 1);
                return;
            }
            t.level().playSeededSound(null, t.getX(), t.getY(), t.getZ(), SOBSounds.COLLAPSE_BUILDING.get(), SoundSource.NEUTRAL, 1.0F, (t.getEffect(SOBMobEffects.COLLAPSE.get()).getAmplifier() * 0.1F) + 1.0F, 1);
            t.addEffect(new MobEffectInstance(SOBMobEffects.COLLAPSE.get(), 30, Math.min(t.getEffect(SOBMobEffects.COLLAPSE.get()).getAmplifier() + 1, 9), false, true));
        }
        if (target instanceof LivingEntity t && entity instanceof LivingEntity e && e.hasEffect(SOBMobEffects.SPITE_BOOST.get()) && e.hasEffect(SOBMobEffects.SPITE.get()) && !t.isInvulnerable()) { //consumes all stacks of Retaliation and increases damage accordingly
            float amp = e.getEffect(SOBMobEffects.SPITE_BOOST.get()).getAmplifier();
            float bAmp = e.getEffect(SOBMobEffects.SPITE.get()).getAmplifier();
            float bonus = ((amp + 1) / 5) * (bAmp + 1);
            event.setAmount(event.getAmount() * (1 + bonus));
            e.level().playSeededSound(null, e.getX(), e.getY(), e.getZ(), SOBSounds.SPITE_CONSUME.get(), SoundSource.NEUTRAL, 1.0F, 1.0F, 1);
            e.removeEffect(SOBMobEffects.SPITE_BOOST.get());
        }
    }

    @SubscribeEvent
    public static void onEntityDamage(LivingHurtEvent event) {
        Entity target = event.getEntity();
        if (target instanceof LivingEntity t && t.hasEffect(SOBMobEffects.SPITE.get()) && event.getAmount() >= 2.0 && !t.isInvulnerable()) { //applies a stack of Retaliation everytime the entity takes at least 1 heart of damage
            if (!t.hasEffect(SOBMobEffects.SPITE_BOOST.get())) {
                t.addEffect(new MobEffectInstance(SOBMobEffects.SPITE_BOOST.get(), -1, 0, false, true));
                t.level().playSeededSound(null, t.getX(), t.getY(), t.getZ(), SOBSounds.SPITE_PRICK.get(), SoundSource.NEUTRAL, 1.0F, 0.6F, 1);
                return;
            }
            t.level().playSeededSound(null, t.getX(), t.getY(), t.getZ(), SOBSounds.SPITE_PRICK.get(), SoundSource.NEUTRAL, 1.0F, (t.getEffect(SOBMobEffects.SPITE_BOOST.get()).getAmplifier() * 0.1F) + 0.7F, 1);
            t.addEffect(new MobEffectInstance(SOBMobEffects.SPITE_BOOST.get(), -1, Math.min(t.getEffect(SOBMobEffects.SPITE_BOOST.get()).getAmplifier() + 1, 4), false, true));
        }
        if (target instanceof LivingEntity t && t.hasEffect(SOBMobEffects.EXPOSED.get())) { //increases damage taken by 10% per level
            float amp = t.getEffect(SOBMobEffects.EXPOSED.get()).getAmplifier();
            float bonus = (amp + 1) / 10;
            event.setAmount(event.getAmount() * (1 + bonus));
        }
    }

    @SubscribeEvent
    public static void mobEffectExpiredEvent(MobEffectEvent.Expired event) {
        MobEffect effect = event.getEffectInstance().getEffect();
        Entity entity = event.getEntity();
        if (entity instanceof LivingEntity e && e.hasEffect(SOBMobEffects.COLLAPSE.get()) && effect == SOBMobEffects.COLLAPSE.get()) {
            e.hurt(SOBDamageTypes.getSimpleDamageSource(e.level(), SOBDamageTypes.COLLAPSING), (e.getEffect(SOBMobEffects.COLLAPSE.get()).getAmplifier()) * 2 + 3);
            e.level().playSeededSound(null, e.getX(), e.getY(), e.getZ(), SOBSounds.COLLAPSING.get(), SoundSource.NEUTRAL, 1.0F, 1.0F, 1);
        }
        if (entity instanceof LivingEntity e && e.hasEffect(SOBMobEffects.SPITE.get()) && e.hasEffect((SOBMobEffects.SPITE_BOOST.get())) && effect == SOBMobEffects.SPITE.get()) {
            e.level().playSeededSound(null, e.getX(), e.getY(), e.getZ(), SOBSounds.SPITE_CONSUME.get(), SoundSource.NEUTRAL, 1.0F, 1.0F, 1);
            e.removeEffect(SOBMobEffects.SPITE_BOOST.get());
        }
        if (entity instanceof LivingEntity e && e.hasEffect(SOBMobEffects.CESSATION.get()) && effect == SOBMobEffects.CESSATION.get()) { //deals massive damage upon effect expiry
            e.hurt(SOBDamageTypes.getSimpleDamageSource(e.level(), SOBDamageTypes.CEASING), e.getMaxHealth()*10);
            e.level().playSeededSound(null, e.getX(), e.getY(), e.getZ(), SOBSounds.BELL_TOLL_FAIL.get(), SoundSource.NEUTRAL, 10, 1.0F, 1);
        }
    }
    @SubscribeEvent
    public static void mobEffectRemovedEvent(MobEffectEvent.Remove event) {
        MobEffect effect = event.getEffect();
        Entity entity = event.getEntity();
        if (entity instanceof LivingEntity e && e.hasEffect(SOBMobEffects.CESSATION.get()) && effect == SOBMobEffects.CESSATION.get()) { //deals massive damage upon effect expiry
            e.hurt(SOBDamageTypes.getSimpleDamageSource(e.level(), SOBDamageTypes.CEASING), e.getMaxHealth()*10);
            e.level().playSeededSound(null, e.getX(), e.getY(), e.getZ(), SOBSounds.BELL_TOLL_FAIL.get(), SoundSource.NEUTRAL, 10, 1.0F, 1);
        }
    }
    @SubscribeEvent
    public static void mobEffectAddedEvent(MobEffectEvent.Added event) {
        MobEffect effect = event.getEffectInstance().getEffect();
        Entity entity = event.getEntity();
        if (entity instanceof LivingEntity e && !e.hasEffect(SOBMobEffects.CESSATION.get()) && effect == SOBMobEffects.CESSATION.get()) {
            e.level().playSeededSound(null, e.getX(), e.getY(), e.getZ(), SOBSounds.BELL_TOLL.get(), SoundSource.NEUTRAL, 10, 1.0F, 1);
        }
    }

    @SubscribeEvent
    public static void noteBlockPlayed(NoteBlockEvent.Play event) {
        Level level = (Level) event.getLevel();
        BlockPos noteBlockPos = event.getPos();
        SoundEvent sound = null;
        Block blockUnder = level.getBlockState(noteBlockPos.below()).getBlock();
        if (blockUnder == SOBBlocks.ASPARAGUS_BUNDLE.get()) {
            sound = SOBSounds.SLAP_BASE.get();
        } else if (blockUnder == SOBBlocks.NOPAL_CRATE.get() || blockUnder == SOBBlocks.PRICKLY_PEAR_CRATE.get()) {
            sound = SOBSounds.NICE_GUITAR.get();
        } else if (blockUnder == SOBBlocks.PEANUT_BAG.get()) {
            sound = SOBSounds.TOOT.get();
        }
        if (sound != null) {
            float pitch = (float) Math.pow(2.0, (event.getVanillaNoteId() - 12) / 12.0);
            level.playSound(null, noteBlockPos, sound, SoundSource.RECORDS, 1F, pitch);
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void expOrbPickedUp(PlayerXpEvent.PickupXp event) {
        Player player = event.getEntity();
        int value = event.getOrb().getValue();

        if (player.hasEffect(SOBMobEffects.BRAIN_BLAST.get())) {
            int amp = player.getEffect(SOBMobEffects.BRAIN_BLAST.get()).getAmplifier();
            double bonus = ((amp + 1) * 0.20);
            player.giveExperiencePoints((int) (value * bonus));
        }
    }
}
