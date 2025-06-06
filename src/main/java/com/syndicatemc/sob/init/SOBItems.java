package com.syndicatemc.sob.init;

import com.syndicatemc.sob.SOB;
import com.syndicatemc.sob.item.FoodConstants;
import com.syndicatemc.sob.item.GildedPotatoItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class SOBItems {
    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, SOB.MOD_ID);

    public static RegistryObject<Item> GILDED_POTATO = ITEMS.register("golden_potato",
        () -> new GildedPotatoItem(new Item.Properties().stacksTo(64).food(FoodConstants.GILDED_POTATO)));

    public static RegistryObject<Item> DRIPLEAVES = ITEMS.register("dripleaves",
        () -> new Item(new Item.Properties().stacksTo(64).food(FoodConstants.DRIPLEAVES)));

    public static void init(IEventBus bus) {
        ITEMS.register(bus);
    }
}
