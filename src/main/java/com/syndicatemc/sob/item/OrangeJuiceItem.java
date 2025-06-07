package com.syndicatemc.sob.item;

import com.teamabnormals.atmospheric.common.entity.OrangeVaporCloud;
import com.teamabnormals.atmospheric.core.registry.AtmosphericEntityTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import vectorwing.farmersdelight.common.item.DrinkableItem;

public class OrangeJuiceItem extends DrinkableItem {
    public OrangeJuiceItem(Properties properties) {
        super(properties);
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 16;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity consumer) {
        if (!level.isClientSide) {
            OrangeVaporCloud cloud = AtmosphericEntityTypes.ORANGE_VAPOR_CLOUD.get().create(level);
            cloud.setPos(consumer.position());
            cloud.setRadius(1.5F);
            cloud.setDuration(600);
            cloud.setRadiusPerTick(-0.0025F);
            level.addFreshEntity(cloud);
        }
        return super.finishUsingItem(stack, level, consumer);
    }
}