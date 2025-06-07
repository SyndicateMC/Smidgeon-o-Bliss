package com.syndicatemc.sob.init;

import com.syndicatemc.sob.SOB;
import com.syndicatemc.sob.block.RoastTurkeyFeastBlock;
import com.syndicatemc.sob.block.SilverfishPlatterFeastBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.apache.http.annotation.Contract;

import javax.annotation.Nullable;

public class SOBBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SOB.MOD_ID);

    public static final RegistryObject<Block> SILVERFISH_PLATTER_BLOCK = BLOCKS.register("silverfish_platter_block",
            () -> new SilverfishPlatterFeastBlock(Block.Properties.copy(Blocks.CAKE).noOcclusion()));
    public static final RegistryObject<Block> ROAST_TURKEY_BLOCK = BLOCKS.register("roast_turkey_block",
            () -> new RoastTurkeyFeastBlock(Block.Properties.copy(Blocks.CAKE).noOcclusion()));

    public static void init(IEventBus bus) {
        BLOCKS.register(bus);
    }
}
