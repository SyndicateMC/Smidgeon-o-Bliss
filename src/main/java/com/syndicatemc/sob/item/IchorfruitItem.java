package com.syndicatemc.sob.item;

import com.syndicatemc.sob.init.SOBSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import vectorwing.farmersdelight.common.item.ConsumableItem;

public class IchorfruitItem extends ConsumableItem {
    public IchorfruitItem(Item.Properties properties) {
        super(properties);
    }

    public int getUseDuration(ItemStack stack) {
        return 24;
    }

    public SoundEvent getEatingSound() {
        return SOBSounds.JUICY_EAT.get();
    }
}
