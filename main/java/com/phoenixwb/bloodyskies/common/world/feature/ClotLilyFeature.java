package com.phoenixwb.bloodyskies.common.world.feature;

import java.util.Random;

import com.mojang.serialization.Codec;
import com.phoenixwb.bloodyskies.core.init.BlockInit;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class ClotLilyFeature extends Feature<NoneFeatureConfiguration> {
	private static final BlockState CLOT_LILY = BlockInit.CLOT_LILY.get().defaultBlockState();

	public ClotLilyFeature(Codec<NoneFeatureConfiguration> codec) {
		super(codec);
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> feature) {
		BlockPos pos = feature.origin();
		Random rand = new Random();
		WorldGenLevel level = feature.level();
		BlockPos directionsNS[] = {pos.north(), pos.south()};
		BlockPos directionsEW[] = {pos.east(), pos.west()};
		while (pos.getY() > 1 && level.isEmptyBlock(pos)) {
			pos = pos.below();
		}
		
		if(isBloodstone(pos, level) != true)
		{
			return false;
		}
		
		pos = pos.above();

		level.setBlock(pos, CLOT_LILY, 1);
		level.setBlock(heightCheck(directionsNS[rand.nextInt(2)], level), CLOT_LILY, 1);
		level.setBlock(heightCheck(directionsEW[rand.nextInt(2)], level), CLOT_LILY, 1);
		return true;
	}
	
	public BlockPos heightCheck(BlockPos pos, WorldGenLevel level)
	{
		BlockPos newPos = pos;
		while (pos.getY() > 1 && level.isEmptyBlock(pos)) {
			newPos = pos.below();
		}
		newPos = pos.above();
		return newPos;
	}
	
	public boolean isBloodstone(BlockPos pos, WorldGenLevel level)
	{
		if(level.getBlockState(pos) != BlockInit.BLOODSTONE.get().defaultBlockState())
		{
			return false;
		}
		return true;
	}
}
