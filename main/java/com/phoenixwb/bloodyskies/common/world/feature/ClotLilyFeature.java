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
		Random rand = feature.random();
		BlockPos pos = feature.origin();
		WorldGenLevel level = feature.level();
		while (pos.getY() > 1 && level.isEmptyBlock(pos)) {
			pos = pos.below();
		}
		pos = pos.above();

		feature.level().setBlock(pos, CLOT_LILY, 0);
		feature.level().setBlock(placementDirection("N/S", rand.nextInt(3), pos, feature), CLOT_LILY, 0);
		feature.level().setBlock(placementDirection("E/W", rand.nextInt(3), pos, feature), CLOT_LILY, 0);
		feature.level().setBlock(placementDirection("C", rand.nextInt(5), pos, feature), CLOT_LILY, 0);

		return false;
	}

	public BlockPos placementDirection(String direction, int rand, BlockPos pos,
			FeaturePlaceContext<NoneFeatureConfiguration> feature) {
		BlockPos position = pos;
		BlockPos north = pos.north();
		BlockPos south = pos.south();
		BlockPos east = pos.east();
		BlockPos west = pos.west();
		WorldGenLevel level = feature.level();
		if (direction == "N/S" && rand == 1
				&& level.getBlockState(north.below()) == BlockInit.BLOODSTONE.get().defaultBlockState()) {
			position = north;
			return position;
		} else if (direction == "N/S" && rand == 2
				&& level.getBlockState(south.below()) == BlockInit.BLOODSTONE.get().defaultBlockState()) {
			position = south;
			return position;
		} else if (direction == "E/W" && rand == 1
				&& level.getBlockState(east.below()) == BlockInit.BLOODSTONE.get().defaultBlockState()) {
			position = east;
			return position;
		} else if (direction == "E/W" && rand == 2
				&& level.getBlockState(west.below()) == BlockInit.BLOODSTONE.get().defaultBlockState()) {
			position = west;
			return position;
		} else if (direction == "C" && rand == 1
				&& level.getBlockState(north.east().below()) == BlockInit.BLOODSTONE.get().defaultBlockState()) {
			position = north.east();
			return position;
		} else if (direction == "C" && rand == 2
				&& level.getBlockState(north.west().below()) == BlockInit.BLOODSTONE.get().defaultBlockState()) {
			position = north.west();
			return position;
		} else if (direction == "C" && rand == 3
				&& level.getBlockState(south.east().below()) == BlockInit.BLOODSTONE.get().defaultBlockState()) {
			position = south.east();
			return position;
		} else if (direction == "C" && rand == 4
				&& level.getBlockState(south.west().below()) == BlockInit.BLOODSTONE.get().defaultBlockState()) {
			position = south.west();
			return position;
		}
		return position;
	}
}
