package com.syndicatemc.sob.init.compat.mynethersdelight;

import com.syndicatemc.sob.item.compat.mynethersdelight.MNDCompatFoodConstants;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

import static com.syndicatemc.sob.init.SOBItems.ITEMS;
import static vectorwing.farmersdelight.common.registry.ModItems.foodItem;

public class MNDCompatItems {
    public static final RegistryObject<Item> HONEY_BARBECUE_STICK = ITEMS.register("honey_barbecue_stick",
            () -> new Item(foodItem(MNDCompatFoodConstants.HONEY_BARBECUE_STICK)));

    public static void init() {}
}
