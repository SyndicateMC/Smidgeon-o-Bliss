package com.syndicatemc.sob.block;

import com.syndicatemc.sob.init.SOBItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.ForgeHooks;

public class PeanutCropBlock extends CropBlock {
    public static final int MAX_AGE = 4;
    public static final IntegerProperty AGE;
    private static final VoxelShape[] SHAPE_BY_AGE;

    public PeanutCropBlock(Properties pProperties) {
        super(pProperties);
    }

    protected IntegerProperty getAgeProperty() {
        return AGE;
    }

    public int getMaxAge() {
        return 4;
    }

    protected ItemLike getBaseSeedId() {
        return SOBItems.PEANUT.get();
    }

    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pLevel.isAreaLoaded(pPos, 1)) {
            if (pLevel.getRawBrightness(pPos, 0) >= 4) {
                int i = this.getAge(pState);
                if (i < this.getMaxAge()) {
                    float f = getGrowthSpeed(this, pLevel, pPos);
                    if (ForgeHooks.onCropsGrowPre(pLevel, pPos, pState, pRandom.nextInt((int)(25.0F / f) + 1) == 0)) {
                        pLevel.setBlock(pPos, this.getStateForAge(i + 1), 2);
                        ForgeHooks.onCropsGrowPost(pLevel, pPos, pState);
                    }
                }
            }
        }
    }

    protected int getBonemealAgeIncrease(Level pLevel) {
        return 1;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(new Property[]{AGE});
    }

    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE_BY_AGE[this.getAge(pState)];
    }

    static {
        AGE = BlockStateProperties.AGE_4;
        SHAPE_BY_AGE = new VoxelShape[]{
                Block.box(5.0F, 0.0F, 5.0F, 11.0F, 4.0F, 11.0F),
                Block.box(4.0F, 0.0F, 4.0F, 12.0F, 6.0F, 12.0F),
                Block.box(3.0F, 0.0F, 3.0F, 13.0F, 8.0F, 13.0F),
                Block.box(1.0F, 0.0F, 1.0F, 15.0F, 9.0F, 15.0F),
                Block.box(1.0F, 0.0F, 1.0F, 15.0F, 11.0F, 15.0F)};
    }
}
