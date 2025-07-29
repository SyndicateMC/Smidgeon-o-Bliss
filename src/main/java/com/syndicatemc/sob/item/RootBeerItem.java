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
import net.minecraft.world.level.material.Fluid;
import umpaz.brewinandchewin.common.item.BoozeItem;
import umpaz.brewinandchewin.common.registry.BnCEffects;
import vectorwing.farmersdelight.common.Configuration;
import vectorwing.farmersdelight.common.item.DrinkableItem;
import vectorwing.farmersdelight.common.registry.ModEffects;

import javax.annotation.Nullable;
import java.util.List;

public class RootBeerItem extends BoozeItem {
    public RootBeerItem(Fluid fluid, Properties properties) {
        super(fluid, properties);
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
        int duration = (int) Math.min(Math.max(100 - consumer.getY(), 15), 150) * 40;

        consumer.addEffect(new MobEffectInstance(BnCEffects.INTOXICATION.get(), duration/2, 0, false, true));
        consumer.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, duration, 0, false, true));
        consumer.addEffect(new MobEffectInstance(ModEffects.COMFORT.get(), duration, 0, false, true));

        return super.finishUsingItem(stack, level, consumer);
    }

    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag isAdvanced) {
        if ((Boolean) Configuration.FOOD_EFFECT_TOOLTIP.get()) {
            tooltip.add(Component.translatable("effect.brewinandchewin.intoxication").withStyle(ChatFormatting.RED).append(Component.literal(" (00:15 - 02:30)").withStyle(ChatFormatting.RED)));
            tooltip.add(Component.translatable("effect.minecraft.haste").withStyle(ChatFormatting.BLUE).append(Component.literal(" (00:30 - 05:00)").withStyle(ChatFormatting.BLUE)));
            tooltip.add(Component.translatable("effect.farmersdelight.comfort").withStyle(ChatFormatting.BLUE).append(Component.literal(" (00:30 - 05:00)").withStyle(ChatFormatting.BLUE)));
            tooltip.add(SOBTranslationKey.getTranslation("effect_scale_height", "tooltip").withStyle(ChatFormatting.BLUE));
        }
    }
}