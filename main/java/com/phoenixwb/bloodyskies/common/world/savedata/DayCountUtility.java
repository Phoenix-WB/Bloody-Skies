package com.phoenixwb.bloodyskies.common.world.savedata;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.client.Minecraft;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.LivingEntity;

public abstract class DayCountUtility {
	public static final Logger LOGGER = LogManager.getLogger();
	private static final Minecraft minecraft = Minecraft.getInstance();
	
	protected final SynchedEntityData entityData = null;

	private static final EntityDataAccessor<Integer> DAY_COUNTDOWN = SynchedEntityData.defineId(LivingEntity.class,
			EntityDataSerializers.INT);

	protected void defineSynchedData() {
		this.entityData.define(DAY_COUNTDOWN, 1);
	}
	
	public void incrementDay()
	{
		this.entityData.set(DAY_COUNTDOWN, this.entityData.get(DAY_COUNTDOWN) + 1);
	}
	
	protected void resetDay()
	{
		this.entityData.set(DAY_COUNTDOWN, 1);
	}
	
	protected void getDay()
	{
		this.entityData.get(DAY_COUNTDOWN);
	}

	public boolean isNewDay() {
		boolean trfa = false;
		if (minecraft.level.dayTime() % 24000 == 0) {
			trfa = true;
			return trfa;
		}
		return trfa;
	}

	public boolean isBloodySky() {
		boolean trfa = false;
		if (this.entityData.get(DAY_COUNTDOWN) >= 10) {
			trfa = true;
			return trfa;
		}
		return trfa;
	}
}
