package com.phoenixwb.bloodyskies.core.init;


import java.util.function.Supplier;

import com.phoenixwb.bloodyskies.BloodySkies;

import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.biome.VanillaBiomes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeInit {
	public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES,
			BloodySkies.MOD_ID);	
	
	static {
		createBiome("sanguine_scapes", VanillaBiomes::theVoidBiome);
	}

	public static ResourceKey<Biome> SANGUINE_SCAPES = registerBiome("sanguine_scapes");

	public static ResourceKey<Biome> registerBiome(String biomeName) {
		return ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(BloodySkies.MOD_ID, biomeName));
	}
	
	public static RegistryObject<Biome> createBiome(String biomeName, Supplier<Biome> biome) {
		return BIOMES.register(biomeName, biome);
	}

	public static void registerBiomes() {
		BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(SANGUINE_SCAPES, 4));
	}
}