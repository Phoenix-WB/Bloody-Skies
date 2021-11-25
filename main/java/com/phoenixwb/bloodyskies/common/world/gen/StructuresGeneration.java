package com.phoenixwb.bloodyskies.common.world.gen;

import java.util.Set;

import com.phoenixwb.bloodyskies.common.world.structures.ConfiguredStructures;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class StructuresGeneration {
	@SubscribeEvent
	public void generateStructures(final BiomeLoadingEvent event) {
		ResourceKey<Biome> key = ResourceKey.create(Registry.BIOME_REGISTRY, event.getName());
		Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(key);
		
		if(types.contains(BiomeDictionary.Type.MOUNTAIN)) {
			event.getGeneration().getStructures().add(() -> ConfiguredStructures.CONFIGURED_CRUMBLED_ALTAR);
		}
	}
}
