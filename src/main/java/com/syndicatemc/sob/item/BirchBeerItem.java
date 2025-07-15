package com.syndicatemc.sob.item;

import com.syndicatemc.sob.init.SOBSounds;
import com.syndicatemc.sob.utility.SOBTranslationKey;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import vectorwing.farmersdelight.common.Configuration;
import vectorwing.farmersdelight.common.item.DrinkableItem;
import vectorwing.farmersdelight.common.registry.ModEffects;

import javax.annotation.Nullable;
import java.util.List;

public class BirchBeerItem extends DrinkableItem {
    public BirchBeerItem(Properties properties) {
        super(properties);
    }

    public SoundEvent getEatingSound() {
        return SOBSounds.FIZZY_DRINK.get();
    }
    public SoundEvent getDrinkingSound() {
        return SOBSounds.FIZZY_DRINK.get();
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 32;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity consumer) {
        MobEffect[] effects = {
                MobEffects.DAMAGE_RESISTANCE,
                MobEffects.REGENERATION,
                ModEffects.COMFORT.get()
        };
        if (!level.isClientSide) {
            MobEffect effect = effects[(int)Math.floor(Math.random() * 3)];
            consumer.addEffect(new MobEffectInstance(effect, 600, 0, false, true));
        }
        return super.finishUsingItem(stack, level, consumer);
    }

    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag isAdvanced) {
        if ((Boolean) Configuration.FOOD_EFFECT_TOOLTIP.get()) {
            tooltip.add(SOBTranslationKey.getTranslation("surprising_flavor", "tooltip").withStyle(ChatFormatting.BLUE).withStyle(ChatFormatting.ITALIC));
            tooltip.add(SOBTranslationKey.getTranslation("surprising_flavor_effect_give", "tooltip").withStyle(ChatFormatting.GRAY).append(Component.literal(":")));
            tooltip.add(Component.literal(" ").append(Component.translatable("effect.minecraft.resistance").withStyle(ChatFormatting.BLUE)).append(Component.literal(" (00:30)").withStyle(ChatFormatting.BLUE)));
            tooltip.add(Component.literal(" ").append(Component.translatable("effect.minecraft.regeneration").withStyle(ChatFormatting.BLUE)).append(Component.literal(" (00:30)").withStyle(ChatFormatting.BLUE)));
            tooltip.add(Component.literal(" ").append(Component.translatable("effect.farmersdelight.comfort").withStyle(ChatFormatting.BLUE)).append(Component.literal(" (00:30)").withStyle(ChatFormatting.BLUE)));
        }
    }
}