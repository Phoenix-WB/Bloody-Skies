package bloodyskies.common.events;

import bloodyskies.BloodySkies;

import bloodyskies.core.init.BlockInit;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.DeathScreen;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.Logger;


@Mod.EventBusSubscriber(modid = BloodySkies.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class DayEvents {

    public static long day = 0;
    public static long dayToDie = 10;
    private static DoDeathEvent doDeathEvent = new DoDeathEvent();
    private static final Minecraft minecraft = Minecraft.getInstance();
    private static final Logger LOGGER = BloodySkies.LOGGER;
    public static int checkDeathEvent = -2;

    // CHANGE ALL OF THESE TO PRIVATE WHEN DONE WITH COMMAND ^^^


    @SubscribeEvent
    public static void nextDay(TickEvent event) {

        if(minecraft.level != null) {
            long currentDay = minecraft.level.getDayTime() / 24000L;
            if(currentDay != day) {
                day = currentDay;

                System.out.println(day);
            }

            if(day == dayToDie - 2 && checkDeathEvent <= -2) {

                checkDeathEvent = -1;
                doDeathEvent.twoToGo();

            } else if(day == dayToDie - 1 && checkDeathEvent <= -1) {

                checkDeathEvent = 0;
                doDeathEvent.oneToGo();

            } else if(day == dayToDie && checkDeathEvent <= 0) {

                checkDeathEvent = 1;
                doDeathEvent.firstDay();

            } else if(day == dayToDie + 1 && checkDeathEvent <= 1) {

                checkDeathEvent = 2;
                doDeathEvent.secondDay();

            } else if(day >= dayToDie + 2 && checkDeathEvent <= 2) {

                checkDeathEvent = 3;
                doDeathEvent.thirdDay();

            }
        }
    }

    @SubscribeEvent
    public static void resetDayToDie(PlayerEvent.PlayerRespawnEvent event) {
        dayToDie = day + 10;
        checkDeathEvent = -2;
    }

    @SubscribeEvent
    public static void currentDay(PlayerInteractEvent.EntityInteract event) {
        Entity mobHovered = event.getTarget();
        Player player = event.getPlayer();
        if (mobHovered.getType() == EntityType.COW && player.getPose() == Pose.CROUCHING) {
            mobHovered.hurt(DamageSource.playerAttack(player), 20.0f);
            mobHovered.spawnAtLocation(BlockInit.TEST_BLOCK.get());
            System.out.println(day);
        }
    }
}
