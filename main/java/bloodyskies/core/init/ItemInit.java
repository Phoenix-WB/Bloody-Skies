package bloodyskies.core.init;

import bloodyskies.BloodySkies;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			BloodySkies.MOD_ID);

	public static final RegistryObject<Item> VILLAGER_HEART = ITEMS.register("villager_heart",
			() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	
	public static final RegistryObject<Item> TECPATL = ITEMS.register("tecpatl",
			() -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
}