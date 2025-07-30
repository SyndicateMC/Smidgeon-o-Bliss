package com.syndicatemc.sob.init.compat.mynethersdelight;

import com.syndicatemc.sob.item.compat.mynethersdelight.MNDCompatFoodConstants;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.RegistryObject;
import umpaz.brewinandchewin.common.item.JamJarItem;

import static com.syndicatemc.sob.init.SOBItems.ITEMS;
import static vectorwing.farmersdelight.common.registry.ModItems.foodItem;

public class MNDCompatItems {
    public static final RegistryObject<Item> HONEY_BARBECUE_STICK = ITEMS.register("honey_barbecue_stick",
            () -> new Item(foodItem(MNDCompatFoodConstants.HONEY_BARBECUE_STICK)));

    public static final RegistryObject<Item> PEPPER_JELLY = ITEMS.register("pepper_jelly",
            () -> new JamJarItem(foodItem(MNDCompatFoodConstants.PEPPER_JELLY).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE)));

    public static void init() {}
}
