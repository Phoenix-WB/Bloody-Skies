package com.phoenixwb.bloodyskies.core.util;


import com.phoenixwb.bloodyskies.BloodySkies;
import com.phoenixwb.bloodyskies.client.render.BloodAltarRenderer;
import com.phoenixwb.bloodyskies.client.screen.BloodAltarScreen;
import com.phoenixwb.bloodyskies.core.init.BlockEntityInit;
import com.phoenixwb.bloodyskies.core.init.MenuTypesInit;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = BloodySkies.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        MenuScreens.register(MenuTypesInit.BLOOD_ALTAR_MENU_TYPE.get(), BloodAltarScreen::new);
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(BlockEntityInit.BLOOD_ALTAR_ENTITY.get(), BloodAltarRenderer::new);
    }
}