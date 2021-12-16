package com.phoenixwb.bloodyskies.common.block;

import java.util.stream.Stream;

import com.phoenixwb.bloodyskies.core.init.BlockInit;
import com.phoenixwb.bloodyskies.core.init.ItemInit;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PedestalBlock extends Block {
	protected static final VoxelShape SHAPE = Stream
			.of(Block.box(3, 0, 3, 13, 2, 13), Block.box(1, 13, 1, 15, 16, 15), Block.box(6, 2, 6, 10, 13, 10))
			.reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

	public PedestalBlock(Properties p_49795_) {
		super(p_49795_);
	}

	@SuppressWarnings("deprecation")
	@Override
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand,
			BlockHitResult result) {
		ItemStack cloth = player.getItemInHand(hand);
		Boolean side = level.isClientSide;
		if (cloth.is(ItemInit.BLOOD_CLOTH.get()) && !side) {
			level.setBlockAndUpdate(pos, BlockInit.BLOOD_ALTAR.get().defaultBlockState());
			cloth.shrink(1);
			return InteractionResult.sidedSuccess(side);
		}
		return super.use(state, level, pos, player, hand, result);
	}

	@Override
	public RenderShape getRenderShape(BlockState p_49232_) {
		return RenderShape.MODEL;
	}

	@Override
	public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_,
			CollisionContext p_60558_) {
		return SHAPE;
	}
}
