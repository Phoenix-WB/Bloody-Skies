package bloodyskies.core.util;


import bloodyskies.BloodySkies;
import bloodyskies.client.screen.TestBlockScreen;
import bloodyskies.core.init.MenuTypesInit;
import com.mojang.blaze3d.platform.ScreenManager;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = BloodySkies.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        MenuScreens.register(MenuTypesInit.TEST_BLOCK_MENU_TYPE.get(), TestBlockScreen::new);
    }
}
