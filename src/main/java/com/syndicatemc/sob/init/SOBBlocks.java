package com.syndicatemc.sob.init;

import com.electronwill.nightconfig.core.UnmodifiableConfig;
import com.syndicatemc.sob.SOB;
import com.syndicatemc.sob.block.*;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import umpaz.brewinandchewin.common.block.*;
import vectorwing.farmersdelight.common.block.RiceBaleBlock;
import vectorwing.farmersdelight.common.block.WildCropBlock;

import java.util.function.ToIntFunction;


public class SOBBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SOB.MOD_ID);

    private static ToIntFunction<BlockState> ichorfruitLight() {
        return (state) -> {
            if (state.getValue(BlockStateProperties.AGE_5) == 0 || state.getValue(BlockStateProperties.AGE_5) == 5) {
                return 0;
            } else {
                return state.getValue(BlockStateProperties.AGE_5) * 2;
            }
        };
    }

    //decorative blocks
    public static final RegistryObject<Block> COUNTER = BLOCKS.register("counter",
            () -> new Block(Block.Properties.copy(Blocks.BRICKS)));
    public static final RegistryObject<Block> NETHER_COUNTER = BLOCKS.register("nether_counter",
            () -> new Block(Block.Properties.copy(Blocks.NETHER_BRICKS)));
    public static final RegistryObject<Block> ACACIA_COUNTER = BLOCKS.register("acacia_counter",
            () -> new CounterBlock(Block.Properties.copy(Blocks.ACACIA_PLANKS)));
    public static final RegistryObject<Block> BAMBOO_COUNTER = BLOCKS.register("bamboo_counter",
            () -> new CounterBlock(Block.Properties.copy(Blocks.BAMBOO_PLANKS)));
    public static final RegistryObject<Block> BIRCH_COUNTER = BLOCKS.register("birch_counter",
            () -> new CounterBlock(Block.Properties.copy(Blocks.BIRCH_PLANKS)));
    public static final RegistryObject<Block> CHERRY_COUNTER = BLOCKS.register("cherry_counter",
            () -> new CounterBlock(Block.Properties.copy(Blocks.CHERRY_PLANKS)));
    public static final RegistryObject<Block> CRIMSON_COUNTER = BLOCKS.register("crimson_counter",
            () -> new CounterBlock(Block.Properties.copy(Blocks.CRIMSON_PLANKS)));
    public static final RegistryObject<Block> DARK_OAK_COUNTER = BLOCKS.register("dark_oak_counter",
            () -> new CounterBlock(Block.Properties.copy(Blocks.DARK_OAK_PLANKS)));
    public static final RegistryObject<Block> JUNGLE_COUNTER = BLOCKS.register("jungle_counter",
            () -> new CounterBlock(Block.Properties.copy(Blocks.JUNGLE_PLANKS)));
    public static final RegistryObject<Block> MANGROVE_COUNTER = BLOCKS.register("mangrove_counter",
            () -> new CounterBlock(Block.Properties.copy(Blocks.MANGROVE_PLANKS)));
    public static final RegistryObject<Block> OAK_COUNTER = BLOCKS.register("oak_counter",
            () -> new CounterBlock(Block.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> SPRUCE_COUNTER = BLOCKS.register("spruce_counter",
            () -> new CounterBlock(Block.Properties.copy(Blocks.SPRUCE_PLANKS)));
    public static final RegistryObject<Block> WARPED_COUNTER = BLOCKS.register("warped_counter",
            () -> new CounterBlock(Block.Properties.copy(Blocks.WARPED_PLANKS)));
    public static final RegistryObject<Block> POWDERY_COUNTER = BLOCKS.register("powdery_counter",
            () -> new CounterBlock(Block.Properties.copy(Blocks.CRIMSON_PLANKS).sound(SoundType.BAMBOO_WOOD)));

    //feast blocks
    public static final RegistryObject<Block> SILVERFISH_PLATTER_BLOCK = BLOCKS.register("silverfish_platter_block",
            () -> new SilverfishPlatterFeastBlock(Block.Properties.copy(Blocks.CAKE).noOcclusion()));
    public static final RegistryObject<Block> ROAST_TURKEY_BLOCK = BLOCKS.register("roast_turkey_block",
            () -> new RoastTurkeyFeastBlock(Block.Properties.copy(Blocks.CAKE).noOcclusion()));
    public static final RegistryObject<Block> DONUT_BOX_BLOCK = BLOCKS.register("donut_box_block",
            () -> new DonutBoxBlock(Block.Properties.copy(Blocks.SCAFFOLDING).noOcclusion()));
    public static final RegistryObject<Block> PITCHER_TUBER = BLOCKS.register("pitcher_tuber",
            () -> new PitcherTuberBlock(Block.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.STEM), SOBItems.TUBER_STICKS));
    public static final RegistryObject<Block> BIG_SOUP_BLOCK = BLOCKS.register("big_soup_block",
            () -> new BigSoupFeastBlock(Block.Properties.of().strength(0.5F, 6.0F).sound(SoundType.LANTERN).noOcclusion()));
    public static final RegistryObject<Block> UNRIPE_EUMOZZ_CHEESE_WHEEL = BLOCKS.register("unripe_eumozz_cheese_wheel",
            () -> new UnripeCheeseWheelBlock(SOBBlocks.EUMOZZ_CHEESE_WHEEL, Block.Properties.copy(Blocks.CAKE)));
    public static final RegistryObject<Block> EUMOZZ_CHEESE_WHEEL = BLOCKS.register("eumozz_cheese_wheel",
            () -> new CheeseWheelBlock(SOBItems.EUMOZZ_CHEESE_WEDGE, Block.Properties.copy(Blocks.CAKE)));
    public static final RegistryObject<Block> RED_RUM_SKULL = BLOCKS.register("red_rum_skull",
            () -> new RedRumSkullBlock(Block.Properties.copy(Blocks.SKELETON_SKULL).noOcclusion().sound(SoundType.BONE_BLOCK)));

    //crops
    public static final RegistryObject<Block> NOPAL_CROP = BLOCKS.register("nopal_crop",
            () -> new NopalCropBlock(Block.Properties.copy(Blocks.SWEET_BERRY_BUSH).noOcclusion(), () -> SOBItems.NOPAL.get(), () -> SOBItems.PRICKLY_PEAR.get()));
    public static final RegistryObject<Block> ASPARAGUS = BLOCKS.register("asparagus",
            () -> new AsparagusCropBlock(Block.Properties.copy(Blocks.WHEAT).noOcclusion()));
    public static final RegistryObject<Block> ICHORFRUIT = BLOCKS.register("ichorfruit",
            () -> new IchorfruitBlock(Block.Properties.copy(Blocks.WHEAT).noOcclusion().sound(SoundType.NETHER_SPROUTS).lightLevel(ichorfruitLight())));

    //wild crops
    public static final RegistryObject<Block> WILD_ASPARAGUS = BLOCKS.register("wild_asparagus",
            () -> new WildCropBlock(MobEffects.CONFUSION, 6, Block.Properties.copy(Blocks.TALL_GRASS)));

    //storage blocks
    public static final RegistryObject<Block> NOPAL_CRATE = BLOCKS.register("nopal_crate",
            () -> new Block(Block.Properties.copy(Blocks.JUNGLE_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> PRICKLY_PEAR_CRATE = BLOCKS.register("prickly_pear_crate",
            () -> new Block(Block.Properties.copy(Blocks.JUNGLE_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> ASPARAGUS_BUNDLE = BLOCKS.register("asparagus_bundle",
            () -> new RiceBaleBlock(Block.Properties.copy(Blocks.HAY_BLOCK))); /* uses RiceBaleBlock class as if functions almost identically to it */
    public static final RegistryObject<Block> PITCHER_TUBER_BUNDLE = BLOCKS.register("pitcher_tuber_bundle",
            () -> new PitcherTuberBundleBlock(Block.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.STEM)));

    public static void init(IEventBus bus) {
        BLOCKS.register(bus);
    }
}

