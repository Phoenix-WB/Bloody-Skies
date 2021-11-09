package bloodyskies;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import bloodyskies.core.init.ItemInit;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("bloodyskies")
@Mod.EventBusSubscriber(modid = BloodySkies.MOD_ID, bus = Bus.MOD)
public class BloodySkies {
	private static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "bloodyskies";

	public BloodySkies() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

		ItemInit.ITEMS.register(bus);
		
		MinecraftForge.EVENT_BUS.register(this);
	}
}
