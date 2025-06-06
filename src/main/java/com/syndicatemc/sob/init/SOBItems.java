package com.syndicatemc.sob.init;

import com.syndicatemc.sob.SOB;
import com.syndicatemc.sob.item.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import umpaz.brewinandchewin.common.registry.BnCItems;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.item.DrinkableItem;
import umpaz.brewinandchewin.common.item.BoozeItem;

import static vectorwing.farmersdelight.common.registry.ModItems.*;

public class SOBItems {
    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, SOB.MOD_ID);

    /* bowl-less food items */
    public static RegistryObject<Item> GILDED_POTATO = ITEMS.register("golden_potato",
        () -> new GildedPotatoItem(new Item.Properties().stacksTo(64).food(FoodConstants.GILDED_POTATO)));
    public static final RegistryObject<Item> DRIPLEAVES = ITEMS.register("dripleaves",
            () -> new Item(foodItem(FoodConstants.DRIPLEAVES)));
    public static final RegistryObject<Item> SCULK_TENDRIL = ITEMS.register("sculk_tendril",
            () -> new Item(foodItem(FoodConstants.SCULK_TENDRIL)));
    public static final RegistryObject<Item> SCULK_ROLL = ITEMS.register("sculk_roll",
            () -> new Item(foodItem(FoodConstants.SCULK_ROLL)));
    //req: create
    public static final RegistryObject<Item> CINDER_BREAD = ITEMS.register("cinder_bread",
            () -> new Item(foodItem(FoodConstants.CINDER_BREAD)));
    //req: ENVI & UA
    public static final RegistryObject<Item> DUCK_SANDWICH = ITEMS.register("duck_sandwich",
            () -> new Item(foodItem(FoodConstants.DUCK_SANDWICH)));
    //req: frycooks & autumnity
    public static final RegistryObject<Item> MAPLE_DONUT = ITEMS.register("maple_donut",
            () -> new Item(foodItem(FoodConstants.MAPLE_DONUT)));

    /* bowl food items */
    public static final RegistryObject<Item> GRAVY = ITEMS.register("gravy",
            () -> new ConsumableItem(bowlFoodItem(FoodConstants.GRAVY).stacksTo(64)));
    public static final RegistryObject<Item> INK_SOUP = ITEMS.register("ink_soup",
            () -> new ConsumableItem(bowlFoodItem(FoodConstants.INK_SOUP), true));
    //req: ENVI
    public static final RegistryObject<Item> TRUFFLE_PASTA = ITEMS.register("truffle_pasta",
            () -> new ConsumableItem(bowlFoodItem(FoodConstants.TRUFFLE_PASTA), true));
    //req: ENVI
    public static final RegistryObject<Item> EXQUISITE_MUSHROOM_SOUP = ITEMS.register("exquisite_mushroom_soup",
            () -> new ConsumableItem(bowlFoodItem(FoodConstants.EXQUISITE_MUSHROOM_SOUP), true));
    //req: autumnity
    public static final RegistryObject<Item> FOUL_SALAD = ITEMS.register("foul_salad",
            () -> new ConsumableItem(bowlFoodItem(FoodConstants.FOUL_SALAD), true));
    //req: ATMO
    public static final RegistryObject<Item> SUGAR_CHICKEN = ITEMS.register("sugar_chicken",
            () -> new ConsumableItem(bowlFoodItem(FoodConstants.SUGAR_CHICKEN), true));
    //req: BaC & frycooks
    public static final RegistryObject<Item> POUTINE = ITEMS.register("poutine",
            () -> new ConsumableItem(bowlFoodItem(FoodConstants.POUTINE), true));

    /* drink food items */
    public static final RegistryObject<Item> GLITTERING_GLOOP = ITEMS.register("glittering_gloop",
            () -> new DrinkableItem(drinkItem().food(FoodConstants.GLITTERING_GLOOP), true, false));
    //req: FR
    public static final RegistryObject<Item> BITTER_TEA = ITEMS.register("bitter_tea",
            () -> new DrinkableItem(drinkItem().food(FoodConstants.BITTER_TEA), true, false));
    //req: ATMO
    public static final RegistryObject<Item> ORANGE_JUICE = ITEMS.register("orange_juice",
            () -> new OrangeJuiceItem(drinkItem().food(FoodConstants.ORANGE_JUICE)));

    /* booze food items */ //obv req: BaC
    public static final RegistryObject<Item> HARD_CIDER = ITEMS.register("hard_cider", () -> new BoozeItem(SOBFluids.HARD_CIDER.get(), new Item.Properties()
            .stacksTo(16).craftRemainder(BnCItems.TANKARD.get()).food(FoodConstants.HARD_CIDER)));
    //req: ATMO
    public static final RegistryObject<Item> TEQUILA = ITEMS.register("tequila", () -> new BoozeItem(SOBFluids.TEQUILA.get(), new Item.Properties()
            .stacksTo(16).craftRemainder(BnCItems.TANKARD.get()).food(FoodConstants.TEQUILA)));
    //req: ATMO
    public static final RegistryObject<Item> SUNRISE_SELTZER = ITEMS.register("sunrise_seltzer", () -> new SunriseSeltzerItem(SOBFluids.SUNRISE_SELTZER.get(), new Item.Properties()
            .stacksTo(16).craftRemainder(Items.GLASS_BOTTLE).food(FoodConstants.SUNRISE_SELTZER)));
    //req: SaR
    public static final RegistryObject<Item> CREEPER_DRINK = ITEMS.register("creeper_drink", () -> new CreeperDrinkItem(SOBFluids.CREEPER_DRINK.get(), new Item.Properties()
            .stacksTo(16).craftRemainder(BnCItems.TANKARD.get()).food(FoodConstants.CREEPER_DRINK)));

    public static void init(IEventBus bus) {
        ITEMS.register(bus);
    }
}
