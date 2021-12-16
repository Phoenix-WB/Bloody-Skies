package com.phoenixwb.bloodyskies.common.block;

import com.phoenixwb.bloodyskies.core.init.BlockInit;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;

public class ClotLilyBlock extends FlowerBlock {

	public ClotLilyBlock(MobEffect p_53512_, int p_53513_, Properties p_53514_) {
		super(p_53512_, p_53513_, p_53514_);
	}
	public boolean mayPlaceOn(BlockState blockstate, BlockGetter blockgetter, BlockPos blockpos) {
		return super.mayPlaceOn(blockstate, blockgetter, blockpos) || blockstate.is(BlockInit.BLOODSTONE.get());
	}
}
