package com.syndicatemc.sob.init;

import com.syndicatemc.sob.SOB;
import com.syndicatemc.sob.init.compat.atmospheric.AtmoCompatItems;
import com.syndicatemc.sob.init.compat.autumnity.AutumnityCompatItems;
import com.syndicatemc.sob.init.compat.mynethersdelight.MNDCompatItems;
import com.syndicatemc.sob.item.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import umpaz.brewinandchewin.common.item.BoozeItem;
import umpaz.brewinandchewin.common.registry.BnCItems;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.item.DrinkableItem;

import static vectorwing.farmersdelight.common.registry.ModItems.*;

public class SOBItems {
    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, SOB.MOD_ID);

    /* blocks */
    public static final RegistryObject<Item> COUNTER = ITEMS.register("counter",
            () -> new BlockItem(SOBBlocks.COUNTER.get(), new Item.Properties()));
    public static final RegistryObject<Item> NETHER_COUNTER = ITEMS.register("nether_counter",
            () -> new BlockItem(SOBBlocks.NETHER_COUNTER.get(), new Item.Properties()));

    /* bowl-less food items */
    public static RegistryObject<Item> GILDED_POTATO = ITEMS.register("golden_potato",
            () -> new GildedPotatoItem(foodItem(FoodConstants.GILDED_POTATO)));
    public static final RegistryObject<Item> DRIPLEAVES = ITEMS.register("dripleaves",
            () -> new Item(foodItem(FoodConstants.DRIPLEAVES)));
    public static final RegistryObject<Item> NOPAL = ITEMS.register("nopal",
            () -> new NopalItem(SOBBlocks.NOPAL_CROP.get(), foodItem(FoodConstants.NOPAL)));
    public static final RegistryObject<Item> PRICKLY_PEAR = ITEMS.register("prickly_pear",
            () -> new Item(foodItem(FoodConstants.PRICKLY_PEAR)));
    public static final RegistryObject<Item> SCULK_TENDRIL = ITEMS.register("sculk_tendril",
            () -> new Item(foodItem(FoodConstants.SCULK_TENDRIL)));
    public static final RegistryObject<Item> SCULK_ROLL = ITEMS.register("sculk_roll",
            () -> new Item(foodItem(FoodConstants.SCULK_ROLL)));
    public static final RegistryObject<Item> VEGGIE_WRAP = ITEMS.register("veggie_wrap",
            () -> new Item(foodItem(FoodConstants.VEGGIE_WRAP)));
    //req: create
    public static final RegistryObject<Item> CINDER_DOUGH = ITEMS.register("cinder_dough",
            () -> new Item(new Item.Properties()));
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
            () -> new GravyItem(bowlFoodItem(FoodConstants.GRAVY).stacksTo(64)));
    public static final RegistryObject<Item> INK_SOUP = ITEMS.register("ink_soup",
            () -> new ConsumableItem(bowlFoodItem(FoodConstants.INK_SOUP), true));
    public static final RegistryObject<Item> MANGROVE_STIR_FRY = ITEMS.register("mangrove_stir_fry",
            () -> new MangroveStirFryItem(bowlFoodItem(FoodConstants.MANGROVE_STIR_FRY), true));
    //req: ENVI
    public static final RegistryObject<Item> TRUFFLE_PASTA = ITEMS.register("truffle_pasta",
            () -> new ConsumableItem(bowlFoodItem(FoodConstants.TRUFFLE_PASTA), true));
    //req: ENVI
    public static final RegistryObject<Item> EXQUISITE_MUSHROOM_SOUP = ITEMS.register("exquisite_mushroom_soup",
            () -> new ConsumableItem(bowlFoodItem(FoodConstants.EXQUISITE_MUSHROOM_SOUP), true));
    //req: autumnity

    //req: ATMO
    public static final RegistryObject<Item> SUGAR_CHICKEN = ITEMS.register("sugar_chicken",
            () -> new ConsumableItem(bowlFoodItem(FoodConstants.SUGAR_CHICKEN), true));
    //req: ATMO
    public static final RegistryObject<Item> SPIKY_SALAD = ITEMS.register("spiky_salad",
            () -> new SpikySaladItem(bowlFoodItem(FoodConstants.SPIKY_SALAD), true));
    //req: BaC & frycooks
    public static final RegistryObject<Item> POUTINE = ITEMS.register("poutine",
            () -> new ConsumableItem(bowlFoodItem(FoodConstants.POUTINE), true));

    /* drink food items */
    public static final RegistryObject<Item> GLITTERING_GLOOP = ITEMS.register("glittering_gloop",
            () -> new DrinkableItem(drinkItem().food(FoodConstants.GLITTERING_GLOOP), true, false));
    public static final RegistryObject<Item> BIRCH_BEER = ITEMS.register("birch_beer",
            () -> new BirchBeerItem(drinkItem().food(FoodConstants.BIRCH_BEER)));
    public static final RegistryObject<Item> CACTUS_JUICE = ITEMS.register("cactus_juice",
            () -> new DrinkableItem(drinkItem().food(FoodConstants.CACTUS_JUICE), true, false));
    //req: FR
    public static final RegistryObject<Item> BITTER_TEA = ITEMS.register("bitter_tea",
            () -> new DrinkableItem(drinkItem().food(FoodConstants.BITTER_TEA), true, false));
    //req: ATMO
    public static final RegistryObject<Item> ALOE_TEA = ITEMS.register("aloe_tea",
            () -> new AloeTeaItem(drinkItem().food(FoodConstants.ALOE_TEA)));

    /* feast items & food items */
    //req: MD & BB
    public static final RegistryObject<Item> SILVERFISH_TOAST = ITEMS.register("silverfish_toast",
            () -> new Item(foodItem(FoodConstants.SILVERFISH_TOAST)));
    public static final RegistryObject<Item> SILVERFISH_PLATTER_BLOCK = ITEMS.register("silverfish_platter_block",
            () -> new BlockItem(SOBBlocks.SILVERFISH_PLATTER_BLOCK.get(), new Item.Properties().stacksTo(1)));
    //req: autumnity & ENVI
    public static final RegistryObject<Item> ROAST_TURKEY = ITEMS.register("roast_turkey",
            () -> new ConsumableItem(bowlFoodItem(FoodConstants.ROAST_TURKEY), true));
    public static final RegistryObject<Item> ROAST_TURKEY_BLOCK = ITEMS.register("roast_turkey_block",
            () -> new BlockItem(SOBBlocks.ROAST_TURKEY_BLOCK.get(), new Item.Properties().stacksTo(1)));
    //req: autumnity & frycooks
    public static final RegistryObject<Item> DONUT_BOX_BLOCK = ITEMS.register("donut_box_block",
            () -> new BlockItem(SOBBlocks.DONUT_BOX_BLOCK.get(), new Item.Properties().stacksTo(1)));

    /* booze food items */
    public static final RegistryObject<Item> HARD_CIDER = ITEMS.register("hard_cider", () -> new BoozeItem(SOBFluids.HARD_CIDER.get(), new Item.Properties()
            .stacksTo(16).craftRemainder(BnCItems.TANKARD.get()).food(FoodConstants.HARD_CIDER)));
    //req: ATMO
    public static final RegistryObject<Item> TEQUILA = ITEMS.register("tequila", () -> new BoozeItem(SOBFluids.TEQUILA.get(), new Item.Properties()
            .stacksTo(16).craftRemainder(BnCItems.TANKARD.get()).food(FoodConstants.TEQUILA)));
    //req: SaR
    public static final RegistryObject<Item> CREEPER_DRINK = ITEMS.register("creeper_drink", () -> new CreeperDrinkItem(SOBFluids.CREEPER_DRINK.get(), new Item.Properties()
            .stacksTo(16).craftRemainder(BnCItems.TANKARD.get()).food(FoodConstants.CREEPER_DRINK)));
    //req: NEA
    public static final RegistryObject<Item> PALE_DAIQUIRI = ITEMS.register("pale_daiquiri", () -> new PaleDaiquiriItem(SOBFluids.PALE_DAIQUIRI.get(), new Item.Properties()
            .stacksTo(16).craftRemainder(Items.GLASS_BOTTLE).food(FoodConstants.PALE_DAIQUIRI)));

    public static void init(IEventBus bus) {
        if (ModList.get().isLoaded("atmospheric")) {
            AtmoCompatItems.init();
        }
        if (ModList.get().isLoaded("autumnity")) {
            AutumnityCompatItems.init();
        }
        if (ModList.get().isLoaded("mynethersdelight")) {
            MNDCompatItems.init();
        }
        ITEMS.register(bus);
    }
}
