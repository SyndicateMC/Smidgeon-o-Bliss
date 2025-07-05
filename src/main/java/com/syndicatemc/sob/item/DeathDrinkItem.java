package com.syndicatemc.sob.item;

import com.syndicatemc.sob.init.SOBMobEffects;
import com.syndicatemc.sob.utility.SOBTranslationKey;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import umpaz.brewinandchewin.common.item.BoozeItem;
import vectorwing.farmersdelight.common.Configuration;
import vectorwing.farmersdelight.common.utility.TextUtils;

import javax.annotation.Nullable;
import java.util.List;

public class DeathDrinkItem extends BoozeItem {
    public DeathDrinkItem(Fluid fluid, Properties properties) {
        super(fluid, properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity consumer) {
        if (!level.isClientSide) {
            consumer.addEffect(new MobEffectInstance(SOBMobEffects.CESSATION.get(), 72000, 0, false, false));
        }
        return super.finishUsingItem(stack, level, consumer);
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 80;
    }

    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag isAdvanced) {
        if ((Boolean) Configuration.FOOD_EFFECT_TOOLTIP.get()) {
            tooltip.add(SOBTranslationKey.getTranslation("inevitable_death", "tooltip").withStyle(ChatFormatting.DARK_RED));
            tooltip.add(Component.translatable("effect.brewinandchewin.tipsy").withStyle(ChatFormatting.RED).append(Component.literal(" (05:00)").withStyle(ChatFormatting.RED)));
            tooltip.add(Component.translatable("effect.brewinandchewin.intoxication").withStyle(ChatFormatting.RED).append(Component.literal(" (05:00)").withStyle(ChatFormatting.RED)));
            tooltip.add(Component.translatable("effect.minecraft.resistance").withStyle(ChatFormatting.BLUE).append(Component.literal(" (10:00)").withStyle(ChatFormatting.BLUE)));
        }
    }
}