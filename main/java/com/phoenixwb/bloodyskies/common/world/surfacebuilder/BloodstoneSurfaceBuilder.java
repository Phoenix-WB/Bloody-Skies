package com.phoenixwb.bloodyskies.common.world.surfacebuilder;

import java.util.Random;

import com.mojang.serialization.Codec;
import com.phoenixwb.bloodyskies.core.init.BlockInit;

import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;

public class BloodstoneSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderBaseConfiguration> {
	private static final BlockState BLOODSTONE = BlockInit.BLOODSTONE.get().defaultBlockState();
	public static final SurfaceBuilderBaseConfiguration CONFIG_BLOODSTONE = new SurfaceBuilderBaseConfiguration(BLOODSTONE, BLOODSTONE, BLOODSTONE);
	
	public BloodstoneSurfaceBuilder(Codec<SurfaceBuilderBaseConfiguration> p_75221_) {
		super(p_75221_);
	}

	@Override
	public void apply(Random p_164213_, ChunkAccess p_164214_, Biome p_164215_, int p_164216_, int p_164217_,
			int p_164218_, double p_164219_, BlockState p_164220_, BlockState p_164221_, int p_164222_, int p_164223_,
			long p_164224_, SurfaceBuilderBaseConfiguration p_164225_) {
		SurfaceBuilder.DEFAULT.apply(
				p_164213_, p_164214_, p_164215_, p_164216_, p_164217_, p_164218_, p_164219_, p_164220_, p_164221_, p_164222_, p_164223_, p_164224_, CONFIG_BLOODSTONE);
	}
}
