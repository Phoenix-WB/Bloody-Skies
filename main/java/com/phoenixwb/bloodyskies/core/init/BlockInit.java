package com.phoenixwb.bloodyskies.core.init;

import com.google.common.base.Supplier;
import com.phoenixwb.bloodyskies.BloodySkies;
import com.phoenixwb.bloodyskies.core.creativemodetab.BloodySkiesCreativeModeTab;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			BloodySkies.MOD_ID);

	public static final RegistryObject<Block> BLOODSTONE = registerBlock("bloodstone",
			() -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.CRIMSON_NYLIUM).strength(3f, 0.8f)
					.sound(SoundType.ANCIENT_DEBRIS)));

	private static <Type extends Block> RegistryObject<Type> registerBlock(String name, Supplier<Type> block) {
		RegistryObject<Type> toReturn = BLOCKS.register(name, block);
		registerBlockItem(name, toReturn);
		return toReturn;
	}

	private static <Type extends Block> void registerBlockItem(String name, RegistryObject<Type> block) {
		ItemInit.ITEMS.register(name,
				() -> new BlockItem(block.get(), new Item.Properties().tab(BloodySkiesCreativeModeTab.BLOODY_SKIES)));
	}

	public static void register(IEventBus eventBus) {
		BLOCKS.register(eventBus);
	}
}
