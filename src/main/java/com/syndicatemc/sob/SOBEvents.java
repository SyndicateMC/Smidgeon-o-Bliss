package com.syndicatemc.sob;

import com.syndicatemc.sob.init.SOBDamageTypes;
import com.syndicatemc.sob.init.SOBItems;
import com.syndicatemc.sob.init.SOBMobEffects;
import com.syndicatemc.sob.init.SOBSounds;
import com.syndicatemc.sob.utillity.SOBTranslationKey;
import net.minecraft.ChatFormatting;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.CustomizeGuiOverlayEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = SOB.MOD_ID)
public class SOBEvents {
    @SubscribeEvent
    public static void onEntityAttack(LivingDamageEvent event) {
        Entity entity = event.getSource().getEntity();
        Entity target = event.getEntity();
        if (entity instanceof Player player && player.hasEffect(SOBMobEffects.BITTERNESS.get())) {
            float hunger = player.getFoodData().getFoodLevel();
            float amp = player.getEffect(SOBMobEffects.BITTERNESS.get()).getAmplifier();
            float bonus = (Math.abs(hunger - 20) / 20) * ((amp + 1) / 2);
            event.setAmount(event.getAmount() * (1 + bonus));
        }
        if (target instanceof LivingEntity t && entity instanceof LivingEntity e && e.hasEffect(SOBMobEffects.RESONANCE.get()) && event.getAmount() >= 1.5 && !t.isInvulnerable()) {
            if (!t.hasEffect(SOBMobEffects.COLLAPSE.get())) {
                t.addEffect(new MobEffectInstance(SOBMobEffects.COLLAPSE.get(), 30, 0, false, true));
                t.level().playSeededSound(null, t.getX(), t.getY(), t.getZ(), SOBSounds.COLLAPSE_BUILDING.get(), SoundSource.NEUTRAL, 1.0F, 0.9F, 1);
                return;
            }
            t.level().playSeededSound(null, t.getX(), t.getY(), t.getZ(), SOBSounds.COLLAPSE_BUILDING.get(), SoundSource.NEUTRAL, 1.0F, (t.getEffect(SOBMobEffects.COLLAPSE.get()).getAmplifier() * 0.1F) + 1.0F, 1);
            t.addEffect(new MobEffectInstance(SOBMobEffects.COLLAPSE.get(), 30, Math.min(t.getEffect(SOBMobEffects.COLLAPSE.get()).getAmplifier() + 1, 9), false, true));
        }
    }

    @SubscribeEvent
    public static void onEntityDamage(LivingHurtEvent event) {
        Entity target = event.getEntity();
        if (target instanceof LivingEntity t && t.hasEffect(SOBMobEffects.SPITE.get()) && event.getAmount() >= 2.0 && !t.isInvulnerable()) {
            if (!t.hasEffect(SOBMobEffects.SPITE_BOOST.get())) {
                t.addEffect(new MobEffectInstance(SOBMobEffects.SPITE_BOOST.get(), 100, 0, false, true));
                t.level().playSeededSound(null, t.getX(), t.getY(), t.getZ(), SOBSounds.SPITE_PRICK.get(), SoundSource.NEUTRAL, 1.0F, 0.6F, 1);
                return;
            }
            t.level().playSeededSound(null, t.getX(), t.getY(), t.getZ(), SOBSounds.SPITE_PRICK.get(), SoundSource.NEUTRAL, 1.0F, (t.getEffect(SOBMobEffects.SPITE_BOOST.get()).getAmplifier() * 0.1F) + 0.7F, 1);
            t.addEffect(new MobEffectInstance(SOBMobEffects.SPITE_BOOST.get(), 100, Math.min(t.getEffect(SOBMobEffects.SPITE_BOOST.get()).getAmplifier() + 1, 4), false, true));
        }
    }

    @SubscribeEvent
    public static void mobEffectEvent(MobEffectEvent.Expired event) {
        Entity entity = event.getEntity();
        if (entity instanceof LivingEntity e && e.hasEffect(SOBMobEffects.COLLAPSE.get())) {
            e.hurt(SOBDamageTypes.getSimpleDamageSource(e.level(), SOBDamageTypes.COLLAPSING), (e.getEffect(SOBMobEffects.COLLAPSE.get()).getAmplifier()) * 2 + 3);
            e.level().playSeededSound(null, e.getX(), e.getY(), e.getZ(), SOBSounds.COLLAPSING.get(), SoundSource.NEUTRAL, 1.0F, 1.0F, 1);
            //dude I don't wanna learn mixins
            //e.level().addParticle(ParticleTypes.SONIC_BOOM, e.getX(), e.getY() + 1, e.getZ(), 0.0, 0.0, 0.0);
        }
    }

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void addTooltips(ItemTooltipEvent event) {
        Item item = event.getItemStack().getItem();
        List<Component> tooltip = event.getToolTip();

        if (item == SOBItems.GILDED_POTATO.get()) {
            tooltip.add(SOBTranslationKey.getTranslation("makes_sparkles", "tooltip").withStyle(ChatFormatting.BLUE));
        }
        if (item == SOBItems.ALOE_TEA.get()) {
            tooltip.add(SOBTranslationKey.getTranslation("extinguishes", "tooltip").withStyle(ChatFormatting.BLUE));
        }
        if (item == SOBItems.CREEPER_DRINK.get()) {
            tooltip.add(SOBTranslationKey.getTranslation("makes_explosion", "tooltip").withStyle(ChatFormatting.BLUE));
        }
        if (item == SOBItems.ORANGE_JUICE.get()) {
            tooltip.add(SOBTranslationKey.getTranslation("makes_orange_vapor", "tooltip").withStyle(ChatFormatting.BLUE));
        }
        if (item == SOBItems.SUNRISE_SELTZER.get()) {
            tooltip.add(SOBTranslationKey.getTranslation("makes_orange_vapor", "tooltip").withStyle(ChatFormatting.BLUE));
        }
        if (item == SOBItems.BIRCH_BEER.get()) {
            tooltip.add(SOBTranslationKey.getTranslation("surprising_flavor", "tooltip").withStyle(ChatFormatting.BLUE).withStyle(ChatFormatting.ITALIC));
            tooltip.add(SOBTranslationKey.getTranslation("surprising_flavor_effect_give", "tooltip").withStyle(ChatFormatting.GRAY).append(Component.literal(":")));
            tooltip.add(Component.literal(" ").append(Component.translatable("effect.minecraft.resistance").withStyle(ChatFormatting.BLUE)).append(Component.literal(" (00:30)").withStyle(ChatFormatting.BLUE)));
            tooltip.add(Component.literal(" ").append(Component.translatable("effect.minecraft.regeneration").withStyle(ChatFormatting.BLUE)).append(Component.literal(" (00:30)").withStyle(ChatFormatting.BLUE)));
            tooltip.add(Component.literal(" ").append(Component.translatable("effect.farmersdelight.comfort").withStyle(ChatFormatting.BLUE)).append(Component.literal(" (00:30)").withStyle(ChatFormatting.BLUE)));
        }
    }
}
