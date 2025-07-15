package com.syndicatemc.sob.item;

import com.syndicatemc.sob.init.SOBSounds;
import com.syndicatemc.sob.utility.SOBTranslationKey;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import vectorwing.farmersdelight.common.Configuration;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.item.DrinkableItem;
import vectorwing.farmersdelight.common.registry.ModEffects;
import vectorwing.farmersdelight.common.utility.TextUtils;

import javax.annotation.Nullable;
import java.util.List;

public class MangroveStirFryItem extends ConsumableItem {
    private final boolean hasFoodEffectTooltip;
    private final boolean hasCustomTooltip;

    public MangroveStirFryItem(Properties properties) {
        super(properties);
        this.hasFoodEffectTooltip = true;
        this.hasCustomTooltip = false;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 32;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity consumer) {
        MobEffect[] effects = {
                MobEffects.DAMAGE_BOOST,
                MobEffects.LUCK,
                MobEffects.HUNGER
        };
        if (!level.isClientSide) {
            MobEffect effect = effects[(int)Math.floor(Math.random() * 3)];
            consumer.addEffect(new MobEffectInstance(effect, 3600, 0, false, true));
        }
        return super.finishUsingItem(stack, level, consumer);
    }

    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag isAdvanced) {
        if ((Boolean) Configuration.FOOD_EFFECT_TOOLTIP.get()) {
            TextUtils.addFoodEffectTooltip(stack, tooltip, 1.0F);
            tooltip.add(SOBTranslationKey.getTranslation("surprising_flavor", "tooltip").withStyle(ChatFormatting.BLUE).withStyle(ChatFormatting.ITALIC));
            tooltip.add(SOBTranslationKey.getTranslation("surprising_flavor_effect_give", "tooltip").withStyle(ChatFormatting.GRAY).append(Component.literal(":")));
            tooltip.add(Component.literal(" ").append(Component.translatable("effect.minecraft.strength").withStyle(ChatFormatting.BLUE)).append(Component.literal(" (03:00)").withStyle(ChatFormatting.BLUE)));
            tooltip.add(Component.literal(" ").append(Component.translatable("effect.minecraft.luck").withStyle(ChatFormatting.BLUE)).append(Component.literal(" (03:00)").withStyle(ChatFormatting.BLUE)));
            tooltip.add(Component.literal(" ").append(Component.translatable("effect.minecraft.hunger").withStyle(ChatFormatting.RED)).append(Component.literal(" (03:00)").withStyle(ChatFormatting.RED)));
        }
    }
}