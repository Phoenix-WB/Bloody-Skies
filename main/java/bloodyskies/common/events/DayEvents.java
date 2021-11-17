package bloodyskies.common.events;

import bloodyskies.BloodySkies;

import bloodyskies.core.init.BlockInit;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.IntTag;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.TagType;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.storage.LevelResource;
import net.minecraft.world.level.storage.LevelStorageSource;
import net.minecraftforge.common.crafting.NBTIngredient;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fmlserverevents.FMLServerStoppingEvent;
import org.apache.logging.log4j.Logger;

import java.io.File;


@Mod.EventBusSubscriber(modid = BloodySkies.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class DayEvents {

    private static DoDeathEvent doDeathEvent = new DoDeathEvent();
    private static final Minecraft minecraft = Minecraft.getInstance();
    private static final Logger LOGGER = BloodySkies.LOGGER;
    private static File playerDir;
    private static long day = 0;
    private static long dayToDie = 10;
    private static int checkDeathEvent = -2;



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
    /*
    public SavedData create() {
        return new SavedData();
    }

    public ExampleSavedData load(CompoundTag tag) {
        ExampleSavedData data = this.create();
        // Load saved data
        return data;
    }*/



    /* I am still working on this, idk if i should use it or something else

    public static void onWorldStart() {

        File playerDataDir = new File(LevelResource.PLAYER_DATA_DIR.toString());

        try {
            File file = new File("filename.txt");
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    } */

    @SubscribeEvent
    public static void onWorldSave(FMLServerStoppingEvent event) {

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

    public static long getDay() {
        return day;
    }

    public static long getDayToDie() {
        return dayToDie;
    }


    public static int getCheckDeathEvent() {
        return checkDeathEvent;
    }
}
