package com.syndicatemc.sob.item;

import com.syndicatemc.sob.init.SOBDamageTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class NopalItem extends ItemNameBlockItem {
    public NopalItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 32;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity consumer) {
        if (!level.isClientSide) {
            consumer.hurt(SOBDamageTypes.getSimpleDamageSource(level, SOBDamageTypes.NOPAL_PRICK), 1);
        }
        return super.finishUsingItem(stack, level, consumer);
    }
}