package com.phoenixwb.bloodyskies.common.events;

import com.phoenixwb.bloodyskies.BloodySkies;
import com.phoenixwb.bloodyskies.core.init.ItemInit;

import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = BloodySkies.MOD_ID, bus = Bus.FORGE)
public class PlayerEvents {
	@SubscribeEvent
	public static void villagerSacrifice(PlayerInteractEvent.EntityInteract event) {
		ItemStack tecpatl = event.getItemStack();
		Entity mobHovered = event.getTarget();
		Player player = event.getPlayer();
		if (tecpatl.getItem() == ItemInit.TECPATL.get() && mobHovered.getType() == EntityType.VILLAGER
				&& mobHovered.getPose() == Pose.SLEEPING && player.getPose() == Pose.CROUCHING) {
			mobHovered.hurt(DamageSource.playerAttack(player), 20.0f);
			mobHovered.spawnAtLocation(ItemInit.VILLAGER_HEART.get());
			tecpatl.shrink(1);
		}
	}

	@SubscribeEvent
	public static void playerSanguineScapesDetection(LivingEvent.LivingUpdateEvent event) {
		LivingEntity player = event.getEntityLiving();
		BlockPos pos = new BlockPos(player.getPosition(0));
		Level world = player.level;
		int biomeskycolour = world.getBiome(pos).getSkyColor();
		if (biomeskycolour == 12132898 && world.getDayTime() % 24000 < 13000 && pos.getY() >= world.getSeaLevel()) {
			player.addEffect(new MobEffectInstance(MobEffects.WITHER, 200, 6));
			player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 4));
			player.addEffect(new MobEffectInstance(MobEffects.HUNGER, 200, 4));
			player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 200, 4));
		}
	}
}