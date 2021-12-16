package com.phoenixwb.bloodyskies.core.util;

import com.phoenixwb.bloodyskies.BloodySkies;
import com.phoenixwb.bloodyskies.core.init.BlockInit;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BloodySkies.MOD_ID)
public class WorldEventBusSubscriber {

    @SubscribeEvent
    public static void stopMobSpawnAroundAltar(LivingSpawnEvent event) {

        Minecraft minecraft = Minecraft.getInstance();
        Level level = minecraft.level;

        if(level == null) {
            return;
        }

        if(event.getEntity() instanceof Player) {
            return;
        }

        if(!(event.getEntity() instanceof Monster)) {
            return;
        }

        BlockPos pos = event.getEntity().blockPosition();


        int diameter = 20;


        int radius = diameter / 2;

        for(int xCount = 0; xCount < diameter; xCount++) {
            int x = xCount - radius;

            for(int yCount = 0; yCount < diameter; yCount++) {
                int y = yCount - radius;

                for(int zCount = 0; zCount < diameter; zCount++) {
                    int z = zCount - radius;

                    int actualX = pos.getX() + x;
                    int actualY = pos.getY() + y;
                    int actualZ = pos.getZ() + z;

                    if(actualY <= 0) {
                        actualY = 1;
                    }

                    BlockPos posToCheck = new BlockPos(actualX, actualY, actualZ);


                    BlockState state = level.getBlockState(posToCheck);


                    if(state.getBlock().equals(BlockInit.BLOOD_ALTAR.get())) {
                        if(event.isCancelable()) {
                            event.setCanceled(true);
                        }
                        return;
                    }
                }
            }
        }
     }
}