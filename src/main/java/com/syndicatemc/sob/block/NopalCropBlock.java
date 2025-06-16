package com.syndicatemc.sob.block;

import com.syndicatemc.sob.init.SOBDamageTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.Tags;

import java.util.function.Supplier;

@SuppressWarnings("deprecation")
public class NopalCropBlock extends BushBlock implements BonemealableBlock {
    public final Supplier<Item> itemOne;
    public final Supplier<Item> itemTwo;

    public static final IntegerProperty NOPAL_AGE = BlockStateProperties.AGE_4;
    protected static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            Block.box(5.0D, 0.0D, 5.0D, 11.0D, 4.0D, 11.0D),
            Block.box(4.0D, 0.0D, 4.0D, 12.0D, 6.0D, 12.0D),
            Block.box(3.0D, 0.0D, 3.0D, 13.0D, 9.0D, 13.0D),
            Block.box(1.0D, 0.0D, 1.0D, 15.0D, 11.0D, 15.0D),
            Block.box(1.0D, 0.0D, 1.0D, 15.0D, 11.0D, 15.0D)
    };

    public NopalCropBlock(Properties properties, Supplier<Item> itemOne, Supplier<Item> itemTwo) {
        super(properties);
        this.itemOne = itemOne;
        this.itemTwo = itemTwo;
        this.registerDefaultState(this.stateDefinition.any().setValue(NOPAL_AGE, 0));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE_BY_AGE[state.getValue(getAgeProperty())];
    }

    public IntegerProperty getAgeProperty() {
        return NOPAL_AGE;
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return state.is(BlockTags.SAND);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        int age = state.getValue(NOPAL_AGE);
        ItemStack heldStack = player.getItemInHand(hand);

        if (age > 0 && heldStack.is(Tags.Items.SHEARS)) {
            popResource(level, pos, getCloneItemStack(level, pos, state));
            level.playSound(null, pos, SoundEvents.MOOSHROOM_SHEAR, SoundSource.BLOCKS, 1.0F, 1.0F);
            level.setBlock(pos, state.setValue(NOPAL_AGE, age - 1), 2);
            if (!level.isClientSide) {
                heldStack.hurtAndBreak(1, player, (playerIn) -> playerIn.broadcastBreakEvent(hand));
            }
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }

    public int getMaxAge() {
        return 4;
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        int age = state.getValue(NOPAL_AGE);
        BlockState groundState = level.getBlockState(pos.below());
        if (age < getMaxAge() && groundState.is(BlockTags.SAND) && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(level, pos, state, random.nextInt(8) == 0)) {
            level.setBlock(pos, state.setValue(NOPAL_AGE, age + 1), 2);
            net.minecraftforge.common.ForgeHooks.onCropsGrowPost(level, pos, state);
        }
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter level, BlockPos pos, BlockState state) {
        RandomSource random = RandomSource.create();
        return state.getValue(getAgeProperty()) <= 3 ? new ItemStack(this.itemOne.get()) : new ItemStack(this.itemTwo.get(), random.nextIntBetweenInclusive(1, 3));
    }

    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        BlockState blockstate1 = pLevel.getBlockState(pPos.below());
        return blockstate1.canSustainPlant(pLevel, pPos, Direction.UP, this) && !pLevel.getBlockState(pPos.above()).liquid();
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(NOPAL_AGE);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state, boolean isClient) {
        return state.getValue(getAgeProperty()) < getMaxAge();
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }

    protected int getBonemealAgeIncrease(Level level) {
        return Mth.nextInt(level.random, 1, 2);
    }

    //literally just copied from the SweetBerryBushBlock class
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        if (pEntity instanceof LivingEntity && pEntity.getType() != EntityType.HUSK) {
            pEntity.makeStuckInBlock(pState, new Vec3((double)0.8F, (double)0.75F, (double)0.8F));
            if (!pLevel.isClientSide && (Integer)pState.getValue(NOPAL_AGE) > 0 && (pEntity.xOld != pEntity.getX() || pEntity.zOld != pEntity.getZ())) {
                double d0 = Math.abs(pEntity.getX() - pEntity.xOld);
                double d1 = Math.abs(pEntity.getZ() - pEntity.zOld);
                if (d0 >= (double)0.003F || d1 >= (double)0.003F) {
                    pEntity.hurt(SOBDamageTypes.getSimpleDamageSource(pLevel, SOBDamageTypes.NOPAL_PRICK), 1.0F);
                }
            }
        }
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        int age = Math.min(getMaxAge(), state.getValue(NOPAL_AGE) + getBonemealAgeIncrease(level));
        level.setBlock(pos, state.setValue(NOPAL_AGE, age), 2);
    }
}