package com.phoenixwb.bloodyskies.common.world.structures.crumbledaltar;

import org.apache.logging.log4j.Level;

import com.phoenixwb.bloodyskies.BloodySkies;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.Vec3i;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.NoiseColumn;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.JigsawConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.structures.JigsawPlacement;
import net.minecraft.world.level.levelgen.structure.NoiseAffectingStructureStart;
import net.minecraft.world.level.levelgen.structure.PoolElementStructurePiece;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureManager;

public class CrumbledAltarStructure extends StructureFeature<NoneFeatureConfiguration> {
	public CrumbledAltarStructure() {
		super(NoneFeatureConfiguration.CODEC);
	}

	@Override
	public GenerationStep.Decoration step() {
		return GenerationStep.Decoration.SURFACE_STRUCTURES;
	}

	@Override
	public StructureFeature.StructureStartFactory<NoneFeatureConfiguration> getStartFactory() {
		return CrumbledAltarStructure.Start::new;
	}

	@Override
	protected boolean isFeatureChunk(ChunkGenerator chunkGenerator, BiomeSource biomeSource, long seed,
			WorldgenRandom random, ChunkPos chunkPos1, Biome biome, ChunkPos chunkPos2,
			NoneFeatureConfiguration featureConfig, LevelHeightAccessor heightLimitView) {
		BlockPos blockPos = chunkPos1.getWorldPosition();
		int landHeight = chunkGenerator.getFirstOccupiedHeight(blockPos.getX(), blockPos.getZ(),
				Heightmap.Types.WORLD_SURFACE_WG, heightLimitView);
		NoiseColumn columnOfBlocks = chunkGenerator.getBaseColumn(blockPos.getX(), blockPos.getZ(), heightLimitView);
		BlockState topBlock = columnOfBlocks.getBlockState(blockPos.above(landHeight));
		return topBlock.getFluidState().isEmpty();
	}

	public static class Start extends NoiseAffectingStructureStart<NoneFeatureConfiguration> {
		public Start(StructureFeature<NoneFeatureConfiguration> structureIn, ChunkPos chunkPos, int referenceIn,
				long seedIn) {
			super(structureIn, chunkPos, referenceIn, seedIn);
		}

		@Override
		public void generatePieces(RegistryAccess dynamicRegistryAccess, ChunkGenerator chunkGenerator,
				StructureManager structureManager, ChunkPos chunkPos, Biome biomeIn, NoneFeatureConfiguration config,
				LevelHeightAccessor heightLimitView) {
			BlockPos structureBlockPos = new BlockPos(chunkPos.getMinBlockX(), 0, chunkPos.getMinBlockZ());
			JigsawPlacement.addPieces(dynamicRegistryAccess,
					new JigsawConfiguration(() -> dynamicRegistryAccess.registryOrThrow(Registry.TEMPLATE_POOL_REGISTRY)
							.get(new ResourceLocation(BloodySkies.MOD_ID, "crumbled_altar/start_pool")), 1),
					PoolElementStructurePiece::new, chunkGenerator, structureManager, structureBlockPos, this,
					this.random, false, true, heightLimitView);
			Vec3i structureCenter = this.pieces.get(0).getBoundingBox().getCenter();
			int xOffset = structureBlockPos.getX() - structureCenter.getX();
			int zOffset = structureBlockPos.getZ() - structureCenter.getZ();
			for (StructurePiece structurePiece : this.pieces) {
				structurePiece.move(xOffset, 0, zOffset);
			}

			this.getBoundingBox();
			BloodySkies.LOGGER.log(Level.DEBUG,
					"Crumbled Altar at... " + this.pieces.get(0).getBoundingBox().getCenter());
		}
	}
}
