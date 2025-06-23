package com.syndicatemc.sob.init;

import com.syndicatemc.sob.SOB;
import com.syndicatemc.sob.block.*;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.block.RiceBaleBlock;
import vectorwing.farmersdelight.common.block.WildCropBlock;

public class SOBBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SOB.MOD_ID);

    //decorative blocks
    public static final RegistryObject<Block> COUNTER = BLOCKS.register("counter",
            () -> new Block(Block.Properties.copy(Blocks.BRICKS)));
    public static final RegistryObject<Block> NETHER_COUNTER = BLOCKS.register("nether_counter",
            () -> new Block(Block.Properties.copy(Blocks.NETHER_BRICKS)));

    //feast blocks
    public static final RegistryObject<Block> SILVERFISH_PLATTER_BLOCK = BLOCKS.register("silverfish_platter_block",
            () -> new SilverfishPlatterFeastBlock(Block.Properties.copy(Blocks.CAKE).noOcclusion()));
    public static final RegistryObject<Block> ROAST_TURKEY_BLOCK = BLOCKS.register("roast_turkey_block",
            () -> new RoastTurkeyFeastBlock(Block.Properties.copy(Blocks.CAKE).noOcclusion()));
    public static final RegistryObject<Block> DONUT_BOX_BLOCK = BLOCKS.register("donut_box_block",
            () -> new DonutBoxBlock(Block.Properties.copy(Blocks.SCAFFOLDING).noOcclusion()));

    //crops
    public static final RegistryObject<Block> NOPAL_CROP = BLOCKS.register("nopal_crop",
            () -> new NopalCropBlock(Block.Properties.copy(Blocks.SWEET_BERRY_BUSH).noOcclusion(), () -> SOBItems.NOPAL.get(), () -> SOBItems.PRICKLY_PEAR.get()));
    public static final RegistryObject<Block> ASPARAGUS = BLOCKS.register("asparagus",
            () -> new AsparagusCropBlock(Block.Properties.copy(Blocks.WHEAT).noOcclusion()));

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

    public static void init(IEventBus bus) {
        BLOCKS.register(bus);
    }
}
