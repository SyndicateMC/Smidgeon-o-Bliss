package com.syndicatemc.sob.init.compat.autumnity;

import com.syndicatemc.sob.item.compat.autumnity.AutumnityCompatFoodConstants;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.item.ConsumableItem;

import static com.syndicatemc.sob.init.SOBItems.ITEMS;
import static vectorwing.farmersdelight.common.registry.ModItems.bowlFoodItem;

public class AutumnityCompatItems {

    public static final RegistryObject<Item> FOUL_SALAD = ITEMS.register("foul_salad",
            () -> new ConsumableItem(bowlFoodItem(AutumnityCompatFoodConstants.FOUL_SALAD), true));

    public static void init() {}
}
