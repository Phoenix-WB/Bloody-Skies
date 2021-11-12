package bloodyskies.common.events;

import bloodyskies.BloodySkies;
import bloodyskies.core.init.ItemInit;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
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
}
