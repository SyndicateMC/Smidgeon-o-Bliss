package com.syndicatemc.sob.block;

import com.syndicatemc.sob.init.SOBItems;
import com.syndicatemc.sob.init.SOBSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
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
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.ForgeHooks;

public class StarfruitCropBlock extends CropBlock {
    public static final int MAX_AGE = 7;
    public static final IntegerProperty AGE;
    private static final VoxelShape[] SHAPE_BY_AGE;
    protected static final VoxelShape SEED_SHAPE = Block.box(0.6F, 0.0F, 0.6F, 10.0F, 4.0F, 10.0F);

    public StarfruitCropBlock(Properties pProperties) {
        super(pProperties);
    }

    protected IntegerProperty getAgeProperty() {
        return AGE;
    }

    public int getMaxAge() {
        return 7;
    }

    protected ItemLike getBaseSeedId() {
        return SOBItems.STARFRUIT_SEED.get();
    }

    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pLevel.isAreaLoaded(pPos, 1)) {
            if (pLevel.getRawBrightness(pPos, 0) >= 12) {
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

    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        int i = pState.getValue(AGE);
        boolean flag = i == 3;
        if (!flag && pPlayer.getItemInHand(pHand).is(Items.BONE_MEAL)) {
            return InteractionResult.PASS;
        } else if (i == 7) {
            popResource(pLevel, pPos, new ItemStack(SOBItems.STARFRUIT.get()));
            pLevel.playSound(null, pPos, SOBSounds.JUICY_HARVEST.get(), SoundSource.BLOCKS, 1.0F, 0.8F + pLevel.random.nextFloat() * 0.4F);
            BlockState blockstate = pState.setValue(AGE, 4);
            pLevel.setBlock(pPos, blockstate, 2);
            pLevel.gameEvent(GameEvent.BLOCK_CHANGE, pPos, GameEvent.Context.of(pPlayer, blockstate));
            return InteractionResult.sidedSuccess(pLevel.isClientSide);
        } else {
            return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
        }
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(new Property[]{AGE});
    }

    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return Shapes.joinUnoptimized(SEED_SHAPE, SHAPE_BY_AGE[this.getAge(pState)], BooleanOp.OR);
    }

    static {
        AGE = BlockStateProperties.AGE_7;
        SHAPE_BY_AGE = new VoxelShape[]{
                Block.box(7.0F, 4.0F, 7.0F, 9.0F, 6.0F, 9.0F),
                Block.box(7.0F, 4.0F, 7.0F, 9.0F, 9.0F, 9.0F),
                Block.box(7.0F, 4.0F, 7.0F, 9.0F, 13.0F, 9.0F),
                Block.box(7.0F, 4.0F, 7.0F, 9.0F, 16.0F, 9.0F),
                Block.box(7.0F, 4.0F, 7.0F, 9.0F, 16.0F, 9.0F),
                Block.box(7.0F, 4.0F, 7.0F, 9.0F, 16.0F, 9.0F),
                Block.box(7.0F, 4.0F, 7.0F, 9.0F, 16.0F, 9.0F),
                Block.box(7.0F, 4.0F, 7.0F, 9.0F, 16.0F, 9.0F)};
    }
}
