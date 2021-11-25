package com.phoenixwb.bloodyskies.common.world.structures;

import com.phoenixwb.bloodyskies.BloodySkies;
import com.phoenixwb.bloodyskies.core.init.StructuresInit;

import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredStructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class ConfiguredStructures {
	public static ConfiguredStructureFeature<?, ?> CONFIGURED_CRUMBLED_ALTAR = StructuresInit.CRUMBLED_ALTAR.get()
			.configured(NoneFeatureConfiguration.INSTANCE);

	public static void registerConfiguredStructures() {
		Registry<ConfiguredStructureFeature<?, ?>> registry = BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE;
		Registry.register(registry, new ResourceLocation(BloodySkies.MOD_ID, "configured_crumbled_altar"),
				CONFIGURED_CRUMBLED_ALTAR);
	}
}