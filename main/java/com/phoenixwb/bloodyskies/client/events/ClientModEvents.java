package com.phoenixwb.bloodyskies.client.events;

import com.phoenixwb.bloodyskies.BloodySkies;
import com.phoenixwb.bloodyskies.client.model.BloodjawModel;
import com.phoenixwb.bloodyskies.client.render.BloodjawRenderer;
import com.phoenixwb.bloodyskies.core.init.EntityTypesInit;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = BloodySkies.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {

	@SubscribeEvent
	public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(BloodjawModel.LAYER_LOCATION, BloodjawModel::createBodyLayer);
	}

	@SubscribeEvent
	public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(EntityTypesInit.BLOODJAW.get(), BloodjawRenderer::new);
	}
}
