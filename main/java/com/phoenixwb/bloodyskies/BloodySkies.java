package com.phoenixwb.bloodyskies;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.phoenixwb.bloodyskies.core.creativemodetab.BloodySkiesCreativeModeTab;
import com.phoenixwb.bloodyskies.core.init.BiomeInit;
import com.phoenixwb.bloodyskies.core.init.BlockEntityInit;
import com.phoenixwb.bloodyskies.core.init.BlockInit;
import com.phoenixwb.bloodyskies.core.init.EntityTypesInit;
import com.phoenixwb.bloodyskies.core.init.FeatureInit;
import com.phoenixwb.bloodyskies.core.init.ItemInit;
import com.phoenixwb.bloodyskies.core.init.MenuTypesInit;
import com.phoenixwb.bloodyskies.core.init.SurfaceBuilderInit;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fmllegacy.RegistryObject;

@Mod("bloodyskies")
@Mod.EventBusSubscriber(modid = BloodySkies.MOD_ID, bus = Bus.MOD)
public class BloodySkies {
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "bloodyskies";

	public BloodySkies() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

		bus.addListener(this::doClientStuff);

		EntityTypesInit.ENTITY_TYPES.register(bus);
		ItemInit.ITEMS.register(bus);
		BlockInit.BLOCKS.register(bus);
		BlockEntityInit.BLOCK_ENTITIES.register(bus);
		MenuTypesInit.MENU_TYPES.register(bus);
		FeatureInit.FEATURES.register(bus);
		SurfaceBuilderInit.SURFACE_BUILDERS.register(bus);
		BiomeInit.BIOMES.register(bus);
		BiomeInit.registerBiomes();

		MinecraftForge.EVENT_BUS.register(this);
	}

	private void doClientStuff(final FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			ItemBlockRenderTypes.setRenderLayer(BlockInit.CLOT_LILY.get(), RenderType.cutout());
		});
	}

	@SubscribeEvent
	public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
		BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
			event.getRegistry()
					.register(new BlockItem(block, new Item.Properties().tab(BloodySkiesCreativeModeTab.BLOODY_SKIES))
							.setRegistryName(block.getRegistryName()));
		});
	}
}
