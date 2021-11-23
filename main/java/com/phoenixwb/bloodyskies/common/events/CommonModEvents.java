package com.phoenixwb.bloodyskies.common.events;

import com.phoenixwb.bloodyskies.BloodySkies;
import com.phoenixwb.bloodyskies.common.entity.Bloodjaw;
import com.phoenixwb.bloodyskies.core.init.EntityTypesInit;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = BloodySkies.MOD_ID, bus = Bus.MOD)
public class CommonModEvents {
	
	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(EntityTypesInit.BLOODJAW.get(), Bloodjaw.createAttributes().build());
	}
}
