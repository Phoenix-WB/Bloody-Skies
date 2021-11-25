package com.phoenixwb.bloodyskies.common.events;

import com.phoenixwb.bloodyskies.BloodySkies;
import com.phoenixwb.bloodyskies.bloodyskiesutility.BloodySky;
import com.phoenixwb.bloodyskies.bloodyskiesutility.DayCountUtility;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.ServerStatsCounter;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.client.event.EntityViewRenderEvent.RenderFogEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = BloodySkies.MOD_ID, bus = Bus.FORGE)
public class BloodySkyEvents {
	@SubscribeEvent
	public void defineFirstDay(PlayerTickEvent event) {
		Player player = event.player;
		ServerStatsCounter serverstatscounter = ((ServerPlayer) player).getStats();
		if (serverstatscounter.getValue(Stats.CUSTOM.get(Stats.PLAY_TIME)) <= 100) {
			DayCountUtility.defineDayOne(player);
		}
	}

	@SubscribeEvent
	public void dayOver(PlayerTickEvent event) {
		Player player = event.player;
		if (DayCountUtility.isNewDay() == true) {
			DayCountUtility.incrementDay(player);
		}
	}

	@SubscribeEvent
	public void bloodySkyInformer(PlayerTickEvent event) {
		Player player = event.player;
		if (DayCountUtility.isBloodySky(player) == true && DayCountUtility.isNewDay() == true) {
			player.sendMessage(new TextComponent(BloodySky.bloodySkyInform()), player.getUUID());
		}
	}

	@SuppressWarnings("resource")
	@SubscribeEvent
	public void bloodySkyFogChanger(RenderFogEvent.FogColors event) {
		LocalPlayer player = Minecraft.getInstance().player;
		if (DayCountUtility.isBloodySky(player) == true && DayCountUtility.isNewDay() == true) {
			event.setRed(BloodySky.getRed());
			event.setGreen(BloodySky.getGreen());
			event.setBlue(BloodySky.getBlue());
		}
	}

	/*
	 * @SubscribeEvent public void bloodySkySpawner(PlayerEvent event) {
	 * 
	 * }
	 */
}
