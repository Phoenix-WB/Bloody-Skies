package com.phoenixwb.bloodyskies.core.init;

import com.phoenixwb.bloodyskies.BloodySkies;
import com.phoenixwb.bloodyskies.common.world.feature.ClotLilyFeature;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FeatureInit {
	public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES,
			BloodySkies.MOD_ID);

	public static final RegistryObject<ClotLilyFeature> CLOT_LILY_FEATURE = FEATURES.register("clot_lily_feature",
			() -> new ClotLilyFeature(NoneFeatureConfiguration.CODEC));
}
