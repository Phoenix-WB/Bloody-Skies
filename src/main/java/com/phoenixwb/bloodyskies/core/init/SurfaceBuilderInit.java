package com.phoenixwb.bloodyskies.core.init;

import com.phoenixwb.bloodyskies.BloodySkies;
import com.phoenixwb.bloodyskies.common.world.surfacebuilder.BloodstoneSurfaceBuilder;

import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderConfiguration;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SurfaceBuilderInit<C extends SurfaceBuilderConfiguration>
		extends net.minecraftforge.registries.ForgeRegistryEntry<SurfaceBuilder<?>> {
	
	public static final DeferredRegister<SurfaceBuilder<?>> SURFACE_BUILDERS = DeferredRegister
			.create(ForgeRegistries.SURFACE_BUILDERS, BloodySkies.MOD_ID);

	public static final RegistryObject<BloodstoneSurfaceBuilder> BLOODSTONE_SURFACE_BUILDER = SURFACE_BUILDERS
			.register("bloodstone_surface", () -> new BloodstoneSurfaceBuilder(SurfaceBuilderBaseConfiguration.CODEC));
}
