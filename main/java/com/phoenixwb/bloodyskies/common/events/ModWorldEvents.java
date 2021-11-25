package com.phoenixwb.bloodyskies.common.events;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.mojang.serialization.Codec;
import com.phoenixwb.bloodyskies.BloodySkies;
import com.phoenixwb.bloodyskies.core.init.StructuresInit;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.FlatLevelSource;
import net.minecraft.world.level.levelgen.StructureSettings;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.StructureFeatureConfiguration;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;

@Mod.EventBusSubscriber(modid = BloodySkies.MOD_ID)
public class ModWorldEvents {
	private static Method GETCODEC_METHOD;

	@SubscribeEvent
	public void addDimensionalSpacing(final WorldEvent.Load event) {
		if (event.getWorld() instanceof ServerLevel) {
			ServerLevel serverWorld = (ServerLevel) event.getWorld();
			try {
				if (GETCODEC_METHOD == null)
					GETCODEC_METHOD = ObfuscationReflectionHelper.findMethod(ChunkGenerator.class, "func_230347_a_");
				ResourceLocation cgRL = Registry.CHUNK_GENERATOR
						.getKey((Codec<? extends ChunkGenerator>) GETCODEC_METHOD
								.invoke(serverWorld.getChunkSource().generator));
				if (cgRL != null && cgRL.getNamespace().equals("terraforged"))
					return;
			} catch (Exception e) {
				BloodySkies.LOGGER.error("Was unable to check if " + serverWorld.dimension().location()
						+ " is using Terraforged's ChunkGenerator.");
			}

			if (serverWorld.getChunkSource().getGenerator() instanceof FlatLevelSource
					&& serverWorld.dimension().equals(Level.OVERWORLD)) {
				return;
			}

			Map<StructureFeature<?>, StructureFeatureConfiguration> tempMap = new HashMap<>(
					serverWorld.getChunkSource().generator.getSettings().structureConfig());
			tempMap.putIfAbsent(StructuresInit.CRUMBLED_ALTAR.get(),
					StructureSettings.DEFAULTS.get(StructuresInit.CRUMBLED_ALTAR.get()));
			serverWorld.getChunkSource().generator.getSettings().structureConfig = tempMap;
		}
	}
}
