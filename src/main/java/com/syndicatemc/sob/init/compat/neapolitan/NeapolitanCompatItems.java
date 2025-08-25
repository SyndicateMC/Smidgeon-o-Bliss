package com.syndicatemc.sob.init.compat.neapolitan;

import com.syndicatemc.sob.item.BananaSundaeItem;
import com.syndicatemc.sob.item.compat.neapolitan.NeapolitanCompatFoodConstants;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.RegistryObject;
import umpaz.brewinandchewin.common.item.JamJarItem;

import static com.syndicatemc.sob.init.SOBItems.ITEMS;
import static vectorwing.farmersdelight.common.registry.ModItems.*;

public class NeapolitanCompatItems {
    public static final RegistryObject<Item> PB_CHOCOLATE = ITEMS.register("pb_chocolate",
            () -> new Item(foodItem(NeapolitanCompatFoodConstants.PB_CHOCOLATE)));

    public static final RegistryObject<Item> MINT_JELLY = ITEMS.register("mint_jelly",
            () -> new JamJarItem(foodItem(NeapolitanCompatFoodConstants.MINT_JELLY).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE)));

    public static final RegistryObject<Item> BANANA_SUNDAE = ITEMS.register("banana_sundae",
            () -> new BananaSundaeItem(bowlFoodItem(NeapolitanCompatFoodConstants.BANANA_SUNDAE)));

    public static void init() {}
}
