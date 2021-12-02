package com.phoenixwb.bloodyskies.core.init;

import com.phoenixwb.bloodyskies.BloodySkies;
import com.phoenixwb.bloodyskies.common.container.BloodAltarContainer;

import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class MenuTypesInit {

	public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.CONTAINERS,
			BloodySkies.MOD_ID);

	public static final RegistryObject<MenuType<BloodAltarContainer>> BLOOD_ALTAR_MENU_TYPE = MENU_TYPES
			.register("blood_altar", () -> IForgeContainerType.create(BloodAltarContainer::new));
}