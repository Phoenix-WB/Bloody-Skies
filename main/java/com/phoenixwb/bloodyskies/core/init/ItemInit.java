package com.phoenixwb.bloodyskies.core.init;

import com.phoenixwb.bloodyskies.BloodySkies;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			BloodySkies.MOD_ID);

	// Miscellaneous tab
	public static final RegistryObject<Item> VILLAGER_HEART = ITEMS.register("villager_heart",
			() -> new Item(new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_MISC)));

	public static final RegistryObject<Item> CRIMSON_ICHOR = ITEMS.register("crimsom_ichor",
			() -> new Item(new Item.Properties().stacksTo(8).tab(CreativeModeTab.TAB_MISC)));

	public static final RegistryObject<Item> BLOOD_HILT = ITEMS.register("blood_hilt",
			() -> new Item(new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_MISC)));

	public static final RegistryObject<Item> QUARTZ_BLADE = ITEMS.register("quartz_blade",
			() -> new Item(new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_MISC)));

	// Tools tab
	public static final RegistryObject<Item> TECPATL = ITEMS.register("tecpatl",
			() -> new Item(new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));
}