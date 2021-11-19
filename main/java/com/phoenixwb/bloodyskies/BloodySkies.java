package com.phoenixwb.bloodyskies;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.phoenixwb.bloodyskies.core.init.BlockInit;
import com.phoenixwb.bloodyskies.core.init.EntityTypesInit;
import com.phoenixwb.bloodyskies.core.init.ItemInit;
import com.phoenixwb.bloodyskies.core.network.BloodySkiesNetwork;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("bloodyskies")
@Mod.EventBusSubscriber(modid = BloodySkies.MOD_ID, bus = Bus.MOD)
public class BloodySkies {
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "bloodyskies";

	public BloodySkies() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

		bus.addListener(this::commonSetup);

		EntityTypesInit.ENTITY_TYPES.register(bus);
		ItemInit.ITEMS.register(bus);
		BlockInit.BLOCKS.register(bus);

		MinecraftForge.EVENT_BUS.register(this);
	}

	public void commonSetup(final FMLCommonSetupEvent event) {
		BloodySkiesNetwork.init();
	}
}
