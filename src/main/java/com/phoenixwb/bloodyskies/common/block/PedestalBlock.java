package com.phoenixwb.bloodyskies.common.block;

import java.util.stream.Stream;

import com.phoenixwb.bloodyskies.BloodySkies;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = BloodySkies.MOD_ID, bus = Bus.FORGE)
public class PedestalBlock extends Block {
	protected static final VoxelShape SHAPE = Stream
			.of(Block.box(3, 0, 3, 13, 2, 13), Block.box(1, 13, 1, 15, 16, 15), Block.box(6, 2, 6, 10, 13, 10))
			.reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

	public PedestalBlock(Properties p_49795_) {
		super(p_49795_);
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
