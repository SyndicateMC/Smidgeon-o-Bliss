package com.syndicatemc.sob.init.compat.atmospheric;

import com.syndicatemc.sob.init.SOBFluids;
import com.syndicatemc.sob.item.FoodConstants;
import com.syndicatemc.sob.item.OrangeJuiceItem;
import com.syndicatemc.sob.item.SunriseSeltzerItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.RegistryObject;

import static com.syndicatemc.sob.init.SOBItems.ITEMS;
import static vectorwing.farmersdelight.common.registry.ModItems.drinkItem;

public class AtmoCompatItems {

    public static final RegistryObject<Item> ORANGE_JUICE = ITEMS.register("orange_juice",
            () -> new OrangeJuiceItem(drinkItem().food(FoodConstants.ORANGE_JUICE)));
    public static final RegistryObject<Item> SUNRISE_SELTZER = ITEMS.register("sunrise_seltzer", () -> new SunriseSeltzerItem(SOBFluids.SUNRISE_SELTZER.get(), new Item.Properties()
            .stacksTo(16).craftRemainder(Items.GLASS_BOTTLE).food(FoodConstants.SUNRISE_SELTZER)));


    public static void init() {}
}
