package bloodyskies.common.events;

import bloodyskies.BloodySkies;
import bloodyskies.core.init.ItemInit;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.npc.Villager;
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
		Player player = event.getPlayer();
		LivingEntity villager = event.getEntityLiving();
		if (tecpatl.getItem() == ItemInit.TECPATL.get() && villager instanceof Villager) {
				villager.hurt(DamageSource.playerAttack(player), 20.0f);
		}
	}
}