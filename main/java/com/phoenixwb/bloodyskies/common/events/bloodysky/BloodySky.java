package com.phoenixwb.bloodyskies.common.events.bloodysky;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.phoenixwb.bloodyskies.BloodySkies;

import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent.WorldTickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BloodySkies.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class BloodySky {

	@SubscribeEvent
	public static void handleBloodySky(PlayerEvent event) {
		Player player = event.getPlayer();

		Scanner dayReader = new Scanner("bloodyskydaydata.txt");

		if (dayReader.hasNextLine() && Integer.parseInt(dayReader.nextLine()) >= 1) {
			System.out.println("It works for: " + Integer.parseInt(dayReader.nextLine() + " days"));
		}
		
		if(dayReader.hasNextLine() && Integer.parseInt(dayReader.nextLine()) >= 10)
		{
			int spawnableMobs = HandleDayCount.calculateMobSpawns(Integer.parseInt(dayReader.nextLine()));
		}
	}

	@SubscribeEvent
	public void onTickEvent(WorldTickEvent event) {

		if (!event.world.dimensionType().bedWorks()) {
			return;
		}

		long worldTime = event.world.getDayTime();

		if (worldTime % 24000 != 0) {
			return;
		}

		Scanner dayReader = new Scanner("bloodyskydaydata.txt");

		if (!dayReader.hasNextLine() || Integer.parseInt(dayReader.nextLine()) <= 0) {
			try {
				FileWriter daySetter = new FileWriter("bloodyskydaydata.txt");
				daySetter.write(1);
				daySetter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		else {
			try {
				int dayValue = Integer.parseInt(dayReader.nextLine());
				FileWriter daySetter = new FileWriter("bloodyskydaydata.txt");
				daySetter.write(dayValue + 1);
				daySetter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}