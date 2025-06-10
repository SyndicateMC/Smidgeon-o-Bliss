package com.syndicatemc.sob.init;

import com.syndicatemc.sob.SOB;
import com.syndicatemc.sob.block.DonutBoxBlock;
import com.syndicatemc.sob.block.NopalCropBlock;
import com.syndicatemc.sob.block.RoastTurkeyFeastBlock;
import com.syndicatemc.sob.block.SilverfishPlatterFeastBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SOBBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SOB.MOD_ID);

    public static final RegistryObject<Block> COUNTER = BLOCKS.register("counter",
            () -> new Block(Block.Properties.copy(Blocks.BRICKS)));
    public static final RegistryObject<Block> NETHER_COUNTER = BLOCKS.register("nether_counter",
            () -> new Block(Block.Properties.copy(Blocks.NETHER_BRICKS)));

    public static final RegistryObject<Block> SILVERFISH_PLATTER_BLOCK = BLOCKS.register("silverfish_platter_block",
            () -> new SilverfishPlatterFeastBlock(Block.Properties.copy(Blocks.CAKE).noOcclusion()));
    public static final RegistryObject<Block> ROAST_TURKEY_BLOCK = BLOCKS.register("roast_turkey_block",
            () -> new RoastTurkeyFeastBlock(Block.Properties.copy(Blocks.CAKE).noOcclusion()));
    public static final RegistryObject<Block> DONUT_BOX_BLOCK = BLOCKS.register("donut_box_block",
            () -> new DonutBoxBlock(Block.Properties.copy(Blocks.SCAFFOLDING).noOcclusion()));

    public static final RegistryObject<Block> NOPAL_CROP = BLOCKS.register("nopal_crop",
            () -> new NopalCropBlock(Block.Properties.copy(Blocks.SWEET_BERRY_BUSH).noOcclusion(), () -> SOBItems.NOPAL.get(), () -> SOBItems.PRICKLY_PEAR.get()));

    public static void init(IEventBus bus) {
        BLOCKS.register(bus);
    }
}
