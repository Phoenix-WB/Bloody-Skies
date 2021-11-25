package com.phoenixwb.bloodyskies.bloodyskiesutility;

import net.minecraft.client.Minecraft;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.ServerStatsCounter;
import net.minecraft.stats.StatFormatter;
import net.minecraft.stats.StatType;
import net.minecraft.world.entity.player.Player;

public abstract class DayCountUtility {
	private static final Minecraft minecraft = Minecraft.getInstance();

	public static final StatType<ResourceLocation> CUSTOM = makeRegistryStatType("custom", Registry.CUSTOM_STAT);
	public static final ResourceLocation TIME_SINCE_SACRIFICE = makeCustomStat("time_since_sacrifice",
			StatFormatter.TIME);

	public static void defineDayOne(Player player) {
		player.awardStat(TIME_SINCE_SACRIFICE, 1);
	}

	public static void incrementDay(Player player) {
		ServerStatsCounter serverstatscounter = ((ServerPlayer) player).getStats();
		player.awardStat(TIME_SINCE_SACRIFICE,
				serverstatscounter.getValue(DayCountUtility.CUSTOM.get(TIME_SINCE_SACRIFICE)) + 1);
	}

	public static int getDay(Player player) {
		int day;
		ServerStatsCounter serverstatscounter = ((ServerPlayer) player).getStats();
		day = serverstatscounter.getValue(DayCountUtility.CUSTOM.get(TIME_SINCE_SACRIFICE));
		return day;
	}

	public static boolean isNewDay() {
		boolean trfa = false;
		if (minecraft.level.dayTime() % 24000 == 0) {
			trfa = true;
			return trfa;
		}
		return trfa;
	}

	public static boolean isBloodySky(Player player) {
		boolean trfa = false;
		if (getDay(player) >= 10) {
			trfa = true;
			return trfa;
		}
		return trfa;
	}

	private static ResourceLocation makeCustomStat(String p_13008_, StatFormatter p_13009_) {
		ResourceLocation resourcelocation = new ResourceLocation(p_13008_);
		Registry.register(Registry.CUSTOM_STAT, p_13008_, resourcelocation);
		CUSTOM.get(resourcelocation, p_13009_);
		return resourcelocation;
	}

	@SuppressWarnings("deprecation")
	private static <T> StatType<T> makeRegistryStatType(String p_13011_, Registry<T> p_13012_) {
		return Registry.register(Registry.STAT_TYPE, p_13011_, new StatType<>(p_13012_));
	}
}
