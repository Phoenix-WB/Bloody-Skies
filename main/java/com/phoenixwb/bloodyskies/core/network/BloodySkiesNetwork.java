package com.phoenixwb.bloodyskies.core.network;

import com.phoenixwb.bloodyskies.BloodySkies;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fmllegacy.network.NetworkRegistry;
import net.minecraftforge.fmllegacy.network.simple.SimpleChannel;

public class BloodySkiesNetwork {

	public static final String NETWORK_VERSION = "0.1.0";

	public static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(
			new ResourceLocation(BloodySkies.MOD_ID, "network"), () -> NETWORK_VERSION,
			version -> version.equals(NETWORK_VERSION), version -> version.equals(NETWORK_VERSION));
	
	public static void init()
	{
		
	}
}
