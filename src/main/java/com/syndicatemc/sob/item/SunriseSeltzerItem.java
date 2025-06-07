package com.syndicatemc.sob.item;

import com.syndicatemc.sob.init.SOBSounds;
import com.teamabnormals.atmospheric.common.entity.OrangeVaporCloud;
import com.teamabnormals.atmospheric.core.registry.AtmosphericEntityTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import umpaz.brewinandchewin.common.item.BoozeItem;

public class SunriseSeltzerItem extends BoozeItem {
    public SunriseSeltzerItem(Fluid fluid, Properties properties) {
        super(fluid, properties);
    }

    public SoundEvent getEatingSound() {
        return SOBSounds.FIZZY_DRINK.get();
    }
    public SoundEvent getDrinkingSound() {
        return SOBSounds.FIZZY_DRINK.get();
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