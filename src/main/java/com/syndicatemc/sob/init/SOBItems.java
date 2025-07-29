package com.syndicatemc.sob.init;

import com.syndicatemc.sob.SOB;
import com.syndicatemc.sob.init.compat.atmospheric.AtmoCompatItems;
import com.syndicatemc.sob.init.compat.autumnity.AutumnityCompatItems;
import com.syndicatemc.sob.init.compat.mynethersdelight.MNDCompatItems;
import com.syndicatemc.sob.init.compat.neapolitan.NeapolitanCompatItems;
import com.syndicatemc.sob.item.*;
import com.syndicatemc.sob.item.compat.mynethersdelight.MNDCompatFoodConstants;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import umpaz.brewinandchewin.common.item.BoozeItem;
import umpaz.brewinandchewin.common.item.JamJarItem;
import umpaz.brewinandchewin.common.registry.BnCItems;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.item.DrinkableItem;
import vectorwing.farmersdelight.common.item.FuelBlockItem;

import static vectorwing.farmersdelight.common.registry.ModItems.*;

public class SOBItems {
    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, SOB.MOD_ID);

    /* decorative blocks */
    public static final RegistryObject<Item> COUNTER = ITEMS.register("counter",
            () -> new BlockItem(SOBBlocks.COUNTER.get(), new Item.Properties()));
    public static final RegistryObject<Item> NETHER_COUNTER = ITEMS.register("nether_counter",
            () -> new BlockItem(SOBBlocks.NETHER_COUNTER.get(), new Item.Properties()));
    public static final RegistryObject<Item> ACACIA_COUNTER = ITEMS.register("acacia_counter",
            () -> new FuelBlockItem(SOBBlocks.ACACIA_COUNTER.get(), new Item.Properties(), 300));
    public static final RegistryObject<Item> BAMBOO_COUNTER = ITEMS.register("bamboo_counter",
            () -> new FuelBlockItem(SOBBlocks.BAMBOO_COUNTER.get(), new Item.Properties(), 300));
    public static final RegistryObject<Item> BIRCH_COUNTER = ITEMS.register("birch_counter",
            () -> new FuelBlockItem(SOBBlocks.BIRCH_COUNTER.get(), new Item.Properties(), 300));
    public static final RegistryObject<Item> CHERRY_COUNTER = ITEMS.register("cherry_counter",
            () -> new FuelBlockItem(SOBBlocks.CHERRY_COUNTER.get(), new Item.Properties(), 300));
    public static final RegistryObject<Item> CRIMSON_COUNTER = ITEMS.register("crimson_counter",
            () -> new BlockItem(SOBBlocks.CRIMSON_COUNTER.get(), new Item.Properties()));
    public static final RegistryObject<Item> DARK_OAK_COUNTER = ITEMS.register("dark_oak_counter",
            () -> new FuelBlockItem(SOBBlocks.DARK_OAK_COUNTER.get(), new Item.Properties(), 300));
    public static final RegistryObject<Item> JUNGLE_COUNTER = ITEMS.register("jungle_counter",
            () -> new FuelBlockItem(SOBBlocks.JUNGLE_COUNTER.get(), new Item.Properties(), 300));
    public static final RegistryObject<Item> MANGROVE_COUNTER = ITEMS.register("mangrove_counter",
            () -> new FuelBlockItem(SOBBlocks.MANGROVE_COUNTER.get(), new Item.Properties(), 300));
    public static final RegistryObject<Item> OAK_COUNTER = ITEMS.register("oak_counter",
            () -> new FuelBlockItem(SOBBlocks.OAK_COUNTER.get(), new Item.Properties(), 300));
    public static final RegistryObject<Item> SPRUCE_COUNTER = ITEMS.register("spruce_counter",
            () -> new FuelBlockItem(SOBBlocks.SPRUCE_COUNTER.get(), new Item.Properties(), 300));
    public static final RegistryObject<Item> WARPED_COUNTER = ITEMS.register("warped_counter",
            () -> new BlockItem(SOBBlocks.WARPED_COUNTER.get(), new Item.Properties()));
    public static final RegistryObject<Item> POWDERY_COUNTER = ITEMS.register("powdery_counter",
            () -> new BlockItem(SOBBlocks.POWDERY_COUNTER.get(), new Item.Properties()));

    /* crop storage blocks */
    public static final RegistryObject<Item> NOPAL_CRATE = ITEMS.register("nopal_crate",
            () -> new BlockItem(SOBBlocks.NOPAL_CRATE.get(), new Item.Properties()));
    public static final RegistryObject<Item> PRICKLY_PEAR_CRATE = ITEMS.register("prickly_pear_crate",
            () -> new BlockItem(SOBBlocks.PRICKLY_PEAR_CRATE.get(), new Item.Properties()));
    public static final RegistryObject<Item> ASPARAGUS_BUNDLE = ITEMS.register("asparagus_bundle",
            () -> new BlockItem(SOBBlocks.ASPARAGUS_BUNDLE.get(), new Item.Properties()));
    public static final RegistryObject<Item> PITCHER_TUBER_BUNDLE = ITEMS.register("pitcher_tuber_bundle",
            () -> new BlockItem(SOBBlocks.PITCHER_TUBER_BUNDLE.get(), new Item.Properties()));
    public static final RegistryObject<Item> PEANUT_BAG = ITEMS.register("peanut_bag",
            () -> new BlockItem(SOBBlocks.PEANUT_BAG.get(), new Item.Properties()));

    /* misc blocks */
    public static final RegistryObject<Item> WILD_ASPARAGUS = ITEMS.register("wild_asparagus",
            () -> new BlockItem(SOBBlocks.WILD_ASPARAGUS.get(), new Item.Properties()));
    public static final RegistryObject<Item> WILD_PEANUTS = ITEMS.register("wild_peanuts",
            () -> new BlockItem(SOBBlocks.WILD_PEANUTS.get(), new Item.Properties()));
    public static final RegistryObject<Item> PITCHER_TUBER = ITEMS.register("pitcher_tuber",
            () -> new BlockItem(SOBBlocks.PITCHER_TUBER.get(), new Item.Properties()));
    public static final RegistryObject<Item> UNRIPE_EUMOZZ_CHEESE_WHEEL = ITEMS.register("unripe_eumozz_cheese_wheel",
            () -> new BlockItem(SOBBlocks.UNRIPE_EUMOZZ_CHEESE_WHEEL.get(), new Item.Properties()));
    public static final RegistryObject<Item> EUMOZZ_CHEESE_WHEEL = ITEMS.register("eumozz_cheese_wheel",
            () -> new BlockItem(SOBBlocks.EUMOZZ_CHEESE_WHEEL.get(), new Item.Properties()));
    public static final RegistryObject<Item> ICHOR_BUD = ITEMS.register("ichor_bud",
            () -> new ItemNameBlockItem(SOBBlocks.ICHORFRUIT.get(), new Item.Properties()));

    /* items */
    public static final RegistryObject<Item> ASPARAGUS_SEEDS = ITEMS.register("asparagus_seeds",
            () -> new ItemNameBlockItem(SOBBlocks.ASPARAGUS.get(), new Item.Properties()));
    public static final RegistryObject<Item> CAMEL_FEED = ITEMS.register("camel_feed",
            () -> new CamelFeedItem(new Item.Properties()));
    public static final RegistryObject<Item> PEANUT = ITEMS.register("peanut",
            () -> new ItemNameBlockItem(SOBBlocks.PEANUTS.get(), new Item.Properties()));
    //req: create
    public static final RegistryObject<Item> CINDER_DOUGH = ITEMS.register("cinder_dough",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CINDER_BREAD = ITEMS.register("cinder_bread",
            () -> new Item(foodItem(FoodConstants.CINDER_BREAD)));

    /* bowl-less food items */
    public static RegistryObject<Item> GILDED_POTATO = ITEMS.register("golden_potato",
            () -> new GildedPotatoItem(foodItem(FoodConstants.GILDED_POTATO)));
    public static final RegistryObject<Item> DRIPLEAVES = ITEMS.register("dripleaves",
            () -> new Item(foodItem(FoodConstants.DRIPLEAVES)));
    public static final RegistryObject<Item> NOPAL = ITEMS.register("nopal",
            () -> new NopalItem(SOBBlocks.NOPAL_CROP.get(), foodItem(FoodConstants.NOPAL)));
    public static final RegistryObject<Item> PRICKLY_PEAR = ITEMS.register("prickly_pear",
            () -> new PricklyPearItem(foodItem(FoodConstants.PRICKLY_PEAR)));
    public static final RegistryObject<Item> GOLDEN_PRICKLY_PEAR = ITEMS.register("golden_prickly_pear",
            () -> new PricklyPearItem(foodItem(FoodConstants.GOLDEN_PRICKLY_PEAR)));
    public static final RegistryObject<Item> ASPARAGUS = ITEMS.register("asparagus",
            () -> new Item(foodItem(FoodConstants.ASPARAGUS)));
    public static final RegistryObject<Item> ROASTED_PEANUTS = ITEMS.register("roasted_peanuts",
            () -> new Item(foodItem(FoodConstants.ROASTED_PEANUTS)));
    public static final RegistryObject<Item> SCULK_TENDRIL = ITEMS.register("sculk_tendril",
            () -> new Item(foodItem(FoodConstants.SCULK_TENDRIL)));
    public static final RegistryObject<Item> SCULK_ROLL = ITEMS.register("sculk_roll",
            () -> new Item(foodItem(FoodConstants.SCULK_ROLL)));
    public static final RegistryObject<Item> VEGGIE_WRAP = ITEMS.register("veggie_wrap",
            () -> new Item(foodItem(FoodConstants.VEGGIE_WRAP)));
    public static final RegistryObject<Item> TUBER_STICKS = ITEMS.register("tuber_sticks",
            () -> new Item(foodItem(FoodConstants.TUBER_STICKS)));
    public static final RegistryObject<Item> ICHORFRUIT = ITEMS.register("ichorfruit",
            () -> new IchorfruitItem(foodItem(FoodConstants.ICHORFRUIT)));
    public static final RegistryObject<Item> ECHO_ROCK_CANDY = ITEMS.register("echo_rock_candy",
            () -> new EchoRockCandyItem(foodItem(FoodConstants.ECHO_ROCK_CANDY)));
    public static final RegistryObject<Item> PBNJ = ITEMS.register("pbnj",
            () -> new Item(foodItem(FoodConstants.PBNJ)));
    public static final RegistryObject<Item> DRIED_BERRIES = ITEMS.register("dried_berries",
            () -> new Item(foodItem(FoodConstants.DRIED_BERRIES)));
    public static final RegistryObject<Item> ANTS_LOG = ITEMS.register("ants_log",
            () -> new Item(foodItem(FoodConstants.ANTS_LOG)));
    //req: endergetic
    public static final RegistryObject<Item> EUMOZZ_CHEESE_WEDGE = ITEMS.register("eumozz_cheese_wedge",
            () -> new Item(foodItem(FoodConstants.EUMOZZ_CHEESE_WEDGE)));
    //req: ENVI & UA
    public static final RegistryObject<Item> DUCK_SANDWICH = ITEMS.register("duck_sandwich",
            () -> new Item(foodItem(FoodConstants.DUCK_SANDWICH)));
    //req: frycooks & autumnity
    public static final RegistryObject<Item> MAPLE_DONUT = ITEMS.register("maple_donut",
            () -> new Item(foodItem(FoodConstants.MAPLE_DONUT)));
    //req: frycooks
    public static final RegistryObject<Item> FISH_STICK_STICK = ITEMS.register("fish_stick_stick",
            () -> new Item(foodItem(FoodConstants.FISH_STICK_STICK)));

    /* bowl food items */
    public static final RegistryObject<Item> GRAVY = ITEMS.register("gravy",
            () -> new GravyItem(bowlFoodItem(FoodConstants.GRAVY).stacksTo(64)));
    public static final RegistryObject<Item> INK_SOUP = ITEMS.register("ink_soup",
            () -> new ConsumableItem(bowlFoodItem(FoodConstants.INK_SOUP), true));
    public static final RegistryObject<Item> MANGROVE_STIR_FRY = ITEMS.register("mangrove_stir_fry",
            () -> new MangroveStirFryItem(bowlFoodItem(FoodConstants.MANGROVE_STIR_FRY)));
    public static final RegistryObject<Item> GRILLED_VEGETABLES = ITEMS.register("grilled_vegetables",
            () -> new ConsumableItem(bowlFoodItem(FoodConstants.GRILLED_VEGETABLES), true));
    public static final RegistryObject<Item> ASPARAGUS_SOUP = ITEMS.register("asparagus_soup",
            () -> new ConsumableItem(bowlFoodItem(FoodConstants.ASPARAGUS_SOUP), true));
    public static final RegistryObject<Item> ROOT_STEAK = ITEMS.register("root_steak",
            () -> new ConsumableItem(bowlFoodItem(FoodConstants.ROOT_STEAK), true));
    public static final RegistryObject<Item> CACTUS_PORKCHOP = ITEMS.register("cactus_porkchop",
            () -> new ConsumableItem(bowlFoodItem(FoodConstants.CACTUS_PORKCHOP), true));
    public static final RegistryObject<Item> CANDIED_PEANUTS = ITEMS.register("candied_peanuts",
            () -> new ConsumableItem(bowlFoodItem(FoodConstants.CANDIED_PEANUTS), true));
    //req: ENVI
    public static final RegistryObject<Item> TRUFFLE_PASTA = ITEMS.register("truffle_pasta",
            () -> new ConsumableItem(bowlFoodItem(FoodConstants.TRUFFLE_PASTA), true));
    //req: ENVI
    public static final RegistryObject<Item> EXQUISITE_MUSHROOM_SOUP = ITEMS.register("exquisite_mushroom_soup",
            () -> new ConsumableItem(bowlFoodItem(FoodConstants.EXQUISITE_MUSHROOM_SOUP), true));
    //req: ATMO
    public static final RegistryObject<Item> SUGAR_CHICKEN = ITEMS.register("sugar_chicken",
            () -> new ConsumableItem(bowlFoodItem(FoodConstants.SUGAR_CHICKEN), true));
    //req: ATMO
    public static final RegistryObject<Item> SPIKY_SALAD = ITEMS.register("spiky_salad",
            () -> new SpikySaladItem(bowlFoodItem(FoodConstants.SPIKY_SALAD)));
    //req: frycooks
    public static final RegistryObject<Item> POUTINE = ITEMS.register("poutine",
            () -> new ConsumableItem(bowlFoodItem(FoodConstants.POUTINE), true));
    //req: frycooks
    public static final RegistryObject<Item> FISH_FRY = ITEMS.register("fish_fry",
            () -> new ConsumableItem(bowlFoodItem(FoodConstants.FISH_FRY), true));
    //req: MD
    public static final RegistryObject<Item> ROOT_SALAD = ITEMS.register("root_salad",
            () -> new ConsumableItem(bowlFoodItem(FoodConstants.ROOT_SALAD), true));

    /* drink food items */
    public static final RegistryObject<Item> GLITTERING_GLOOP = ITEMS.register("glittering_gloop",
            () -> new DrinkableItem(drinkItem().food(FoodConstants.GLITTERING_GLOOP), true, false));
    public static final RegistryObject<Item> BIRCH_BEER = ITEMS.register("birch_beer",
            () -> new BirchBeerItem(drinkItem().food(FoodConstants.BIRCH_BEER)));
    public static final RegistryObject<Item> CACTUS_JUICE = ITEMS.register("cactus_juice",
            () -> new DrinkableItem(drinkItem().food(FoodConstants.CACTUS_JUICE), true, false));
    public static final RegistryObject<Item> BUILDER_SMOOTHIE = ITEMS.register("builder_smoothie",
            () -> new BuilderSmoothieItem(drinkItem().food(FoodConstants.BUILDER_SMOOTHIE)));
    //req: FR
    public static final RegistryObject<Item> BITTER_TEA = ITEMS.register("bitter_tea",
            () -> new DrinkableItem(drinkItem().food(FoodConstants.BITTER_TEA), true, false));
    //req: ATMO
    public static final RegistryObject<Item> ALOE_TEA = ITEMS.register("aloe_tea",
            () -> new AloeTeaItem(drinkItem().food(FoodConstants.ALOE_TEA)));

    /* feast items & food items */
    public static final RegistryObject<Item> BIG_SOUP = ITEMS.register("big_soup",
            () -> new BigSoupItem(bowlFoodItem(FoodConstants.BIG_SOUP)));
    public static final RegistryObject<Item> BIG_SOUP_BLOCK = ITEMS.register("big_soup_block",
            () -> new BlockItem(SOBBlocks.BIG_SOUP_BLOCK.get(), new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> RED_RUM_SKULL = ITEMS.register("red_rum_skull",
            () -> new BlockItem(SOBBlocks.RED_RUM_SKULL.get(), new Item.Properties().stacksTo(1)));
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

    /* preserve food items */
    public static final RegistryObject<Item> PEANUT_BUTTER = ITEMS.register("peanut_butter",
            () -> new PeanutButterItem(foodItem(FoodConstants.PEANUT_BUTTER).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE)));
    //req: ATMO
    public static final RegistryObject<Item> ORANGE_MARMALADE = ITEMS.register("orange_marmalade",
            () -> new JamJarItem(foodItem(FoodConstants.ORANGE_MARMALADE).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE)));
    //req: NEA
    public static final RegistryObject<Item> STRAWBERRY_JAM = ITEMS.register("strawberry_jam",
            () -> new JamJarItem(foodItem(FoodConstants.STRAWBERRY_JAM).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE)));

    /* booze food items */
    public static final RegistryObject<Item> HARD_CIDER = ITEMS.register("hard_cider", () -> new BoozeItem(SOBFluids.HARD_CIDER.get(), new Item.Properties()
            .stacksTo(16).craftRemainder(BnCItems.TANKARD.get()).food(FoodConstants.HARD_CIDER)));
    public static final RegistryObject<Item> DEATH_DRINK = ITEMS.register("death_drink", () -> new DeathDrinkItem(SOBFluids.DEATH_DRINK.get(), new Item.Properties()
            .stacksTo(16).craftRemainder(BnCItems.TANKARD.get()).food(FoodConstants.DEATH_DRINK)));
    public static final RegistryObject<Item> PRICKLY_MELOMEL = ITEMS.register("prickly_melomel", () -> new BoozeItem(SOBFluids.PRICKLY_MELOMEL.get(), new Item.Properties()
            .stacksTo(16).craftRemainder(BnCItems.TANKARD.get()).food(FoodConstants.PRICKLY_MELOMEL)));
    //req: ATMO
    public static final RegistryObject<Item> TEQUILA = ITEMS.register("tequila", () -> new BoozeItem(SOBFluids.TEQUILA.get(), new Item.Properties()
            .stacksTo(16).craftRemainder(BnCItems.TANKARD.get()).food(FoodConstants.TEQUILA)));
    //req: SaR
    public static final RegistryObject<Item> CREEPER_DRINK = ITEMS.register("creeper_drink", () -> new CreeperDrinkItem(SOBFluids.CREEPER_DRINK.get(), new Item.Properties()
            .stacksTo(16).craftRemainder(BnCItems.TANKARD.get()).food(FoodConstants.CREEPER_DRINK)));
    //req: NEA
    public static final RegistryObject<Item> PALE_DAIQUIRI = ITEMS.register("pale_daiquiri", () -> new PaleDaiquiriItem(SOBFluids.PALE_DAIQUIRI.get(), new Item.Properties()
            .stacksTo(16).craftRemainder(Items.GLASS_BOTTLE).food(FoodConstants.PALE_DAIQUIRI)));
    //req: spelunkery
    public static final RegistryObject<Item> PORTAL_DRINK = ITEMS.register("portal_drink", () -> new PortalDrinkItem(SOBFluids.PORTAL_DRINK.get(), new Item.Properties()
            .stacksTo(16).craftRemainder(BnCItems.TANKARD.get()).food(FoodConstants.PORTAL_DRINK)));
    //req: MD
    public static final RegistryObject<Item> ROOT_BEER = ITEMS.register("root_beer", () -> new RootBeerItem(SOBFluids.ROOT_BEER.get(), new Item.Properties()
            .stacksTo(16).craftRemainder(BnCItems.TANKARD.get()).food(FoodConstants.ROOT_BEER)));

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

        if (ModList.get().isLoaded("neapolitan")) {
            NeapolitanCompatItems.init();
        }
        ITEMS.register(bus);
    }
}
