package bloodyskies.core.init;

import bloodyskies.BloodySkies;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			BloodySkies.MOD_ID);

	public static final RegistryObject<Item> VILLAGER_HEART = ITEMS.register("villager_heart",
			() -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));
}