package com.phoenixwb.bloodyskies.common.world.surfacebuilder;

import java.util.Random;

import com.mojang.serialization.Codec;
import com.phoenixwb.bloodyskies.core.init.BlockInit;

import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;

public class BloodstoneSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderBaseConfiguration> {
	public static final BlockState BLOODSTONE = BlockInit.BLOODSTONE.get().defaultBlockState();
	public static final BlockState GRASS = Blocks.GRASS_BLOCK.defaultBlockState();
	public static final BlockState DIRT = Blocks.DIRT.defaultBlockState();
	public static final BlockState REDSAND = Blocks.RED_SAND.defaultBlockState();
	public static final BlockState REDSANDSTONE = Blocks.RED_SANDSTONE.defaultBlockState();
	public static final SurfaceBuilderBaseConfiguration CONFIG_BLOODSTONE = new SurfaceBuilderBaseConfiguration(
			BLOODSTONE, BLOODSTONE, BLOODSTONE);
	public static final SurfaceBuilderBaseConfiguration CONFIG_OVERWORLDGRASS = new SurfaceBuilderBaseConfiguration(
			GRASS, DIRT, DIRT);
	Random rand = new Random();

	public BloodstoneSurfaceBuilder(Codec<SurfaceBuilderBaseConfiguration> codec) {
		super(codec);
	}

	@Override
	public void apply(Random random, ChunkAccess chunkAccess, Biome biome, int int1, int int2, int int3, double double1,
			BlockState blockState1, BlockState blockState2, int int4, int int5, long long1,
			SurfaceBuilderBaseConfiguration surfaceBuilderConfiguration) {
		int rand = this.rand.nextInt(6);
		if (rand == 0 || rand == 1 || rand == 2 || rand == 3) {
			SurfaceBuilder.DEFAULT.apply(random, chunkAccess, biome, int1, int2, int3, double1, blockState1,
					blockState2, int4, int5, long1, CONFIG_BLOODSTONE);
		} else {
			SurfaceBuilder.DEFAULT.apply(random, chunkAccess, biome, int1, int2, int3, long1, blockState1, blockState2,
					int4, int5, rand, CONFIG_OVERWORLDGRASS);
		}
	}
}
