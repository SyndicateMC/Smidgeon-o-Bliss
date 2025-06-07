package com.syndicatemc.sob.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.phys.Vec3;
import umpaz.brewinandchewin.common.item.BoozeItem;

public class CreeperDrinkItem extends BoozeItem {
    public CreeperDrinkItem(Fluid fluid, Properties properties) {
        super(fluid, properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity consumer) {
        if (!level.isClientSide) {
            level.explode(consumer, consumer.getX(), consumer.getY() + 1, consumer.getZ(), 4, Level.ExplosionInteraction.NONE);
            consumer.addDeltaMovement(new Vec3(0, 1.0, 0));
        }
        return super.finishUsingItem(stack, level, consumer);
    }
}