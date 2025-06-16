package com.syndicatemc.sob.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import umpaz.brewinandchewin.common.item.BoozeItem;

public class PaleDaiquiriItem extends BoozeItem {
    public PaleDaiquiriItem(Fluid fluid, Properties properties) {
        super(fluid, properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity consumer) {
        if (!level.isClientSide) {
            consumer.heal(consumer.getMaxHealth() * 0.25F);
        }
        return super.finishUsingItem(stack, level, consumer);
    }
}