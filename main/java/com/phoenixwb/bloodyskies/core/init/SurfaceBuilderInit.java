package com.phoenixwb.bloodyskies.core.init;

import com.phoenixwb.bloodyskies.BloodySkies;
import com.phoenixwb.bloodyskies.common.world.surfacebuilder.BloodstoneSurfaceBuilder;

import net.minecraft.data.BuiltinRegistries;
import net.minecraft.world.level.levelgen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderConfiguration;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SurfaceBuilderInit<C extends SurfaceBuilderConfiguration> extends net.minecraftforge.registries.ForgeRegistryEntry<SurfaceBuilder<?>> {
	//Surface Builder Registry
	public static final DeferredRegister<SurfaceBuilder<?>> SURFACE_BUILDERS = DeferredRegister
			.create(ForgeRegistries.SURFACE_BUILDERS, BloodySkies.MOD_ID);

	public static final RegistryObject<BloodstoneSurfaceBuilder> BLOODSTONE_LAYER = SURFACE_BUILDERS
			.register("bloodstone_surface", () -> new BloodstoneSurfaceBuilder(SurfaceBuilderBaseConfiguration.CODEC));
	
	//Configured Surface Builder Registry	
	public ConfiguredSurfaceBuilder<C> CONFIGURED_BLOODSTONE_SURFACE = new ConfiguredSurfaceBuilder(this, BLOODSTONE_SURFACE);
	
	public static final ConfiguredSurfaceBuilder<SurfaceBuilderBaseConfiguration> BLOODSTONE_SURFACE = registerConfiguredSurfaceBuilder("bloodstone", SurfaceBuilderInit.BLOODSTONE_SURFACE);
	
	private static <SC extends SurfaceBuilderConfiguration> ConfiguredSurfaceBuilder<SC> registerConfiguredSurfaceBuilder(String p_127301_, ConfiguredSurfaceBuilder<SC> p_127302_) {
	      return BuiltinRegistries.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER, p_127301_, p_127302_);
	   }
}
