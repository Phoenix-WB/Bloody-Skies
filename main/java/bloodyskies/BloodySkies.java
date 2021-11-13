package bloodyskies;

import bloodyskies.core.init.BlockEntityInit;
import bloodyskies.core.init.BlockInit;
import bloodyskies.core.init.MenuTypesInit;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.IForgeRegistry;
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
		BlockInit.BLOCKS.register(bus);
		BlockEntityInit.BLOCK_ENTITIES.register(bus);
		MenuTypesInit.MENU_TYPES.register(bus);

		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
		final IForgeRegistry<Item> registry = event.getRegistry();


		BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
			final Item.Properties properties = new Item.Properties().tab(CreativeModeTab.TAB_MISC);
			final BlockItem blockItem = new BlockItem(block, properties);
			blockItem.setRegistryName(block.getRegistryName());
			registry.register(blockItem);
		});
	}
}
