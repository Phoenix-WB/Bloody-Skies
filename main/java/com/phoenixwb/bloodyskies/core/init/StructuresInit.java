package com.phoenixwb.bloodyskies.core.init;

import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.phoenixwb.bloodyskies.BloodySkies;
import com.phoenixwb.bloodyskies.common.world.structures.crumbledaltar.CrumbledAltarStructure;

import net.minecraft.data.BuiltinRegistries;
import net.minecraft.world.level.levelgen.StructureSettings;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.StructureFeatureConfiguration;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class StructuresInit {
	public static final DeferredRegister<StructureFeature<?>> STRUCTURES = DeferredRegister
			.create(ForgeRegistries.STRUCTURE_FEATURES, BloodySkies.MOD_ID);

	public static final RegistryObject<StructureFeature<NoneFeatureConfiguration>> CRUMBLED_ALTAR = STRUCTURES
			.register("crumbled_altar", CrumbledAltarStructure::new);

	public static void setupStructures() {
		setupMapSpacingAndLand(CRUMBLED_ALTAR.get(), new StructureFeatureConfiguration(40, 24, 1234567890), true);
	}

	public static <F extends StructureFeature<?>> void setupMapSpacingAndLand(F structure,
			StructureFeatureConfiguration StructureFeatureConfiguration, boolean transformSurroundingLand) {
		StructureFeature.STRUCTURES_REGISTRY.put(structure.getRegistryName().toString(), structure);
		if (transformSurroundingLand) {
			StructureFeature.NOISE_AFFECTING_FEATURES = ImmutableList.<StructureFeature<?>>builder()
					.addAll(StructureFeature.NOISE_AFFECTING_FEATURES).add(structure).build();
		}

		StructureSettings.DEFAULTS = ImmutableMap.<StructureFeature<?>, StructureFeatureConfiguration>builder()
				.putAll(StructureSettings.DEFAULTS).put(structure, StructureFeatureConfiguration).build();
		BuiltinRegistries.NOISE_GENERATOR_SETTINGS.entrySet().forEach(settings -> {
            Map<StructureFeature<?>, StructureFeatureConfiguration> structureMap = settings.getValue().structureSettings().structureConfig();
            if(structureMap instanceof ImmutableMap){
                Map<StructureFeature<?>, StructureFeatureConfiguration> tempMap = new HashMap<>(structureMap);
                tempMap.put(structure, StructureFeatureConfiguration);
                settings.getValue().structureSettings().structureConfig = tempMap;
            }
            else{
                structureMap.put(structure, StructureFeatureConfiguration);
            }
        });
	}
}