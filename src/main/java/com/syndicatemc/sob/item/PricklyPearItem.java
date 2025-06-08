package com.syndicatemc.sob.item;

import com.syndicatemc.sob.init.SOBDamageTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import vectorwing.farmersdelight.common.item.ConsumableItem;

public class PricklyPearItem extends ConsumableItem {
    public PricklyPearItem(Properties properties) {
        super(properties);
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 32;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity consumer) {
        if (!level.isClientSide) {
            RandomSource random = level.getRandom();
            if (random.nextInt(5) == 0) {
                consumer.hurt(SOBDamageTypes.getSimpleDamageSource(level, SOBDamageTypes.NOPAL_PRICK), 1);
            }
        }
        return super.finishUsingItem(stack, level, consumer);
    }
}