package com.syndicatemc.sob.item;

import com.syndicatemc.sob.init.SOBDamageTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import vectorwing.farmersdelight.common.Configuration;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.utility.TextUtils;

import javax.annotation.Nullable;
import java.util.List;

public class BananaSundaeItem extends ConsumableItem {

    public BananaSundaeItem(Properties properties) {
        super(properties);
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 32;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity consumer) {
        if (!level.isClientSide) {
            consumer.setTicksFrozen(consumer.getTicksFrozen() + 200);
        }
        return super.finishUsingItem(stack, level, consumer);
    }

    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag isAdvanced) {
        if ((Boolean) Configuration.FOOD_EFFECT_TOOLTIP.get()) {
            TextUtils.addFoodEffectTooltip(stack, tooltip, 1.0F);
        }
    }
}