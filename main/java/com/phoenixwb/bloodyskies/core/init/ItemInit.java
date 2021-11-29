package com.phoenixwb.bloodyskies.core.init;

import com.phoenixwb.bloodyskies.BloodySkies;
import com.phoenixwb.bloodyskies.core.creativemodetab.BloodySkiesCreativeModeTab;

import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			BloodySkies.MOD_ID);

	public static final RegistryObject<Item> VILLAGER_HEART = ITEMS.register("villager_heart",
			() -> new Item(new Item.Properties().stacksTo(1).tab(BloodySkiesCreativeModeTab.BLOODY_SKIES)));

	public static final RegistryObject<Item> CRIMSON_ICHOR = ITEMS.register("crimson_ichor",
			() -> new Item(new Item.Properties().stacksTo(8).tab(BloodySkiesCreativeModeTab.BLOODY_SKIES)));

	public static final RegistryObject<Item> TECPATL = ITEMS.register("tecpatl",
			() -> new Item(new Item.Properties().stacksTo(1).tab(BloodySkiesCreativeModeTab.BLOODY_SKIES)));

	public static final RegistryObject<ForgeSpawnEggItem> BLOODJAW_SPAWN_EGG = ITEMS.register("bloodjaw_spawn_egg",
			() -> new ForgeSpawnEggItem(EntityTypesInit.BLOODJAW, 0x853131, 0xf2dca2,
					new Item.Properties().tab(BloodySkiesCreativeModeTab.BLOODY_SKIES)));
}