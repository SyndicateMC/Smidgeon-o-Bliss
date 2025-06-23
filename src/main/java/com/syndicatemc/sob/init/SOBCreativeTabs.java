package com.syndicatemc.sob.init;

import com.syndicatemc.sob.SOB;
import com.syndicatemc.sob.init.compat.atmospheric.AtmoCompatItems;
import com.syndicatemc.sob.init.compat.autumnity.AutumnityCompatItems;
import com.syndicatemc.sob.init.compat.mynethersdelight.MNDCompatItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

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
                        if (ModList.get().isLoaded("mynethersdelight")) {
                            output.accept(NETHER_COUNTER.get());
                        }
                        /* items and bowl-less food items */
                        output.accept(GILDED_POTATO.get());
                        output.accept(DRIPLEAVES.get());
                        output.accept(NOPAL.get());
                        output.accept(NOPAL_CRATE.get());
                        output.accept(PRICKLY_PEAR.get());
                        output.accept(PRICKLY_PEAR_CRATE.get());
                        output.accept(ASPARAGUS_SEEDS.get());
                        output.accept(ASPARAGUS.get());
                        output.accept(ASPARAGUS_BUNDLE.get());
                        output.accept(WILD_ASPARAGUS.get());
                        output.accept(VEGGIE_WRAP.get());
                        output.accept(SCULK_TENDRIL.get());
                        output.accept(SCULK_ROLL.get());
                        if (ModList.get().isLoaded("create")) {
                            output.accept(CINDER_DOUGH.get());
                            output.accept(CINDER_BREAD.get());
                        }
                        if (ModList.get().isLoaded("environmental") && ModList.get().isLoaded("upgrade_aquatic")) {
                            output.accept(DUCK_SANDWICH.get());
                        }
                        if (ModList.get().isLoaded("frycooks_delight") && ModList.get().isLoaded("autumnity")) {
                            output.accept(MAPLE_DONUT.get());
                        }
                        if (ModList.get().isLoaded("mynethersdelight")) {
                            output.accept(MNDCompatItems.HONEY_BARBECUE_STICK.get());
                        }
                        /* bowl food items */
                        output.accept(GRAVY.get());
                        output.accept(INK_SOUP.get());
                        output.accept(ASPARAGUS_SOUP.get());
                        if (ModList.get().isLoaded("environmental")) {
                            output.accept(EXQUISITE_MUSHROOM_SOUP.get());
                        }
                        if (ModList.get().isLoaded("autumnity")) {
                            output.accept(AutumnityCompatItems.FOUL_SALAD.get());
                        }
                        if (ModList.get().isLoaded("atmospheric")) {
                            output.accept(SPIKY_SALAD.get());
                        }
                        if (ModList.get().isLoaded("frycooks_delight")) {
                            output.accept(POUTINE.get());
                        }
                        /* plate food items */
                        output.accept(MANGROVE_STIR_FRY.get());
                        output.accept(GRILLED_VEGETABLES.get());
                        if (ModList.get().isLoaded("environmental")) {
                            output.accept(TRUFFLE_PASTA.get());
                        }
                        if (ModList.get().isLoaded("atmospheric")) {
                            output.accept(SUGAR_CHICKEN.get());
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
                        /* feast items and food items */
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
                    })
                    .build());

    public static void init(IEventBus bus) {
        CREATIVE_TABS.register(bus);
    }
}