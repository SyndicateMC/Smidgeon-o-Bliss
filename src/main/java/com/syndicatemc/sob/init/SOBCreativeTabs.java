package com.syndicatemc.sob.init;

import com.syndicatemc.sob.SOB;
import com.syndicatemc.sob.init.compat.atmospheric.AtmoCompatItems;
import com.syndicatemc.sob.init.compat.autumnity.AutumnityCompatItems;
import com.syndicatemc.sob.init.compat.mynethersdelight.MNDCompatItems;
import com.syndicatemc.sob.init.compat.neapolitan.NeapolitanCompatItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.holdersets.ICustomHolderSet;

import static com.syndicatemc.sob.init.SOBItems.*;

public class SOBCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SOB.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TAB_SOB = CREATIVE_TABS.register(SOB.MOD_ID,
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.sob"))
                    .icon(() -> new ItemStack(GILDED_POTATO.get()))
                    .displayItems((parameters, output) -> {
                        /* blocks */
                        output.accept(COUNTER.get());
                        output.accept(METAL_COUNTER.get());
                        if (ModList.get().isLoaded("mynethersdelight")) {
                            output.accept(NETHER_COUNTER.get());
                        }
                        output.accept(OAK_COUNTER.get());
                        output.accept(SPRUCE_COUNTER.get());
                        output.accept(BIRCH_COUNTER.get());
                        output.accept(JUNGLE_COUNTER.get());
                        output.accept(ACACIA_COUNTER.get());
                        output.accept(DARK_OAK_COUNTER.get());
                        output.accept(MANGROVE_COUNTER.get());
                        output.accept(CHERRY_COUNTER.get());
                        output.accept(BAMBOO_COUNTER.get());
                        output.accept(CRIMSON_COUNTER.get());
                        output.accept(WARPED_COUNTER.get());
                        if (ModList.get().isLoaded("mynethersdelight")) {
                            output.accept(POWDERY_COUNTER.get());
                        }
                        output.accept(STONE_COUNTER.get());
                        output.accept(DEEPSLATE_COUNTER.get());
                        output.accept(BLACKSTONE_COUNTER.get());
                        /* items and bowl-less food items */
                        output.accept(GILDED_POTATO.get());
                        output.accept(DRIPLEAVES.get());
                        output.accept(NOPAL.get());
                        output.accept(NOPAL_CRATE.get());
                        output.accept(PRICKLY_PEAR.get());
                        output.accept(GOLDEN_PRICKLY_PEAR.get());
                        output.accept(PRICKLY_PEAR_CRATE.get());
                        output.accept(ASPARAGUS_SEEDS.get());
                        output.accept(ASPARAGUS.get());
                        output.accept(ASPARAGUS_BUNDLE.get());
                        output.accept(WILD_ASPARAGUS.get());
                        output.accept(PEANUT.get());
                        output.accept(ROASTED_PEANUTS.get());
                        output.accept(PEANUT_BAG.get());
                        output.accept(WILD_PEANUTS.get());
                        output.accept(PITCHER_TUBER.get());
                        output.accept(PITCHER_TUBER_BUNDLE.get());
                        output.accept(TUBER_STICKS.get());
                        //unfinished
                        //output.accept(STARFRUIT.get());
                        //output.accept(STARFRUIT_SEED.get());
                        //output.accept(ICHOR_BUD.get());
                        //output.accept(ICHORFRUIT.get());
                        output.accept(DRIED_BERRIES.get());
                        output.accept(VEGGIE_WRAP.get());
                        output.accept(SCULK_TENDRIL.get());
                        output.accept(SCULK_ROLL.get());
                        output.accept(PBNJ.get());
                        output.accept(ANTS_LOG.get());
                        output.accept(EXP_CANDY.get());
                        if (ModList.get().isLoaded("create")) {
                            output.accept(CINDER_DOUGH.get());
                            output.accept(CINDER_BREAD.get());
                        }
                        if (ModList.get().isLoaded("environmental") && ModList.get().isLoaded("upgrade_aquatic")) {
                            output.accept(DUCK_SANDWICH.get());
                        }
                        if (ModList.get().isLoaded("frycooks_delight") && ModList.get().isLoaded("autumnity")) {
                            output.accept(MAPLE_DONUT.get());
                            output.accept(FISH_STICK_STICK.get());
                        }
                        if (ModList.get().isLoaded("neapolitan")) {
                            output.accept(NeapolitanCompatItems.PB_CHOCOLATE.get());
                        }
                        if (ModList.get().isLoaded("mynethersdelight")) {
                            output.accept(MNDCompatItems.HONEY_BARBECUE_STICK.get());
                        }
                        output.accept(ECHO_ROCK_CANDY.get());
                        /* bowl food items */
                        output.accept(INK_SOUP.get());
                        output.accept(ASPARAGUS_SOUP.get());
                        output.accept(CANDIED_PEANUTS.get());
                        if (ModList.get().isLoaded("environmental")) {
                            output.accept(EXQUISITE_MUSHROOM_SOUP.get());
                        }
                        if (ModList.get().isLoaded("autumnity")) {
                            output.accept(AutumnityCompatItems.FOUL_SALAD.get());
                        }
                        if (ModList.get().isLoaded("atmospheric")) {
                            output.accept(SPIKY_SALAD.get());
                        }
                        if (ModList.get().isLoaded("miners_delight")) {
                            output.accept(ROOT_SALAD.get());
                        }
                        if (ModList.get().isLoaded("frycooks_delight")) {
                            output.accept(POUTINE.get());
                        }
                        if (ModList.get().isLoaded("neapolitan") && ModList.get().isLoaded("environmental")) {
                            output.accept(NeapolitanCompatItems.BANANA_SUNDAE.get());
                        }
                        /* plate food items */
                        output.accept(MANGROVE_STIR_FRY.get());
                        output.accept(GRILLED_VEGETABLES.get());
                        output.accept(ROOT_STEAK.get());
                        output.accept(CACTUS_PORKCHOP.get());
                        if (ModList.get().isLoaded("environmental")) {
                            output.accept(TRUFFLE_PASTA.get());
                        }
                        if (ModList.get().isLoaded("atmospheric")) {
                            output.accept(SUGAR_CHICKEN.get());
                        }
                        if (ModList.get().isLoaded("frycooks_delight")) {
                            output.accept(FISH_FRY.get());
                        }
                        /* preserve food items */
                        output.accept(PEANUT_BUTTER.get());
                        if (ModList.get().isLoaded("neapolitan")) {
                            output.accept(STRAWBERRY_JAM.get());
                            output.accept(NeapolitanCompatItems.MINT_JELLY.get());
                        }
                        if (ModList.get().isLoaded("atmospheric")) {
                            output.accept(ORANGE_MARMALADE.get());
                            output.accept(CURRANT_JAM.get());
                        }
                        if (ModList.get().isLoaded("mynethersdelight")) {
                            output.accept(MNDCompatItems.PEPPER_JELLY.get());
                        }
                        /* drink food items */
                        output.accept(BIRCH_BEER.get());
                        output.accept(GLITTERING_GLOOP.get());
                        output.accept(CACTUS_JUICE.get());
                        output.accept(BUILDER_SMOOTHIE.get());
                        if (ModList.get().isLoaded("farmersrespite")) {
                            output.accept(BITTER_TEA.get());
                        }
                        if (ModList.get().isLoaded("atmospheric")) {
                            output.accept(AtmoCompatItems.ORANGE_JUICE.get());
                            output.accept(ALOE_TEA.get());
                        }
                        /* booze food items */
                        output.accept(HARD_CIDER.get());
                        output.accept(PRICKLY_MELOMEL.get());
                        if (ModList.get().isLoaded("atmospheric")) {
                            output.accept(TEQUILA.get());
                            output.accept(AtmoCompatItems.SUNRISE_SELTZER.get());
                        }
                        if (ModList.get().isLoaded("savage_and_ravage")) {
                            output.accept(CREEPER_DRINK.get());
                        }
                        if (ModList.get().isLoaded("neapolitan")) {
                            output.accept(PALE_DAIQUIRI.get());
                        }
                        if (ModList.get().isLoaded("miners_delight")) {
                            output.accept(ROOT_BEER.get());
                        }
                            output.accept(BUSTLING_BREW.get());
                            output.accept(DEATH_DRINK.get());
                        if (ModList.get().isLoaded("spelunkery")) {
                            output.accept(PORTAL_DRINK.get());
                        }
                        /* cheese */
                        if (ModList.get().isLoaded("endergetic")) {
                            output.accept(UNRIPE_EUMOZZ_CHEESE_WHEEL.get());
                            output.accept(EUMOZZ_CHEESE_WHEEL.get());
                            output.accept(EUMOZZ_CHEESE_WEDGE.get());
                        }
                        /* feast items and food items */
                        output.accept(BIG_SOUP_BLOCK.get());
                        output.accept(BIG_SOUP.get());
                        if (ModList.get().isLoaded("miners_delight") && ModList.get().isLoaded("buzzier_bees")) {
                            output.accept(SILVERFISH_PLATTER_BLOCK.get());
                            output.accept(SILVERFISH_TOAST.get());
                        }
                        if (ModList.get().isLoaded("autumnity") && ModList.get().isLoaded("environmental")) {
                            output.accept(ROAST_TURKEY_BLOCK.get());
                            output.accept(ROAST_TURKEY.get());
                        }
                        if (ModList.get().isLoaded("autumnity") && ModList.get().isLoaded("frycooks_delight")) {
                            output.accept(DONUT_BOX_BLOCK.get());
                        }
                        output.accept(RED_RUM_SKULL.get());
                        /* animal feeds */
                        output.accept(CAMEL_FEED.get());
                    })
                    .build());

    public static void init(IEventBus bus) {
        CREATIVE_TABS.register(bus);
    }
}