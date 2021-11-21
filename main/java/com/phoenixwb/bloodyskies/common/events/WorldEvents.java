package com.phoenixwb.bloodyskies.common.events;

import com.phoenixwb.bloodyskies.BloodySkies;
import com.phoenixwb.bloodyskies.common.world.savedata.DayCountUtility;
import com.phoenixwb.bloodyskies.core.init.ItemInit;

import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent.WorldTickEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = BloodySkies.MOD_ID, bus = Bus.MOD)
public class WorldEvents {
	private final String FILE_LOCATION = "daycountdata.txt";
	
	@SubscribeEvent
	public void test(PlayerInteractEvent.RightClickItem event)
	{
		ItemStack heart = event.getItemStack();
		if(heart.getItem() == ItemInit.VILLAGER_HEART.get())
		{
			System.out.println("Works");
		}
	}
	
	@SubscribeEvent
	public void dayOver(WorldTickEvent event) {

	}
}