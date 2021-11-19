package com.phoenixwb.bloodyskies.core.init;

import com.phoenixwb.bloodyskies.BloodySkies;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			BloodySkies.MOD_ID);

	public static final RegistryObject<Block> BLOODSTONE = BLOCKS.register("bloodstone",
			() -> new Block(Block.Properties.of(Material.STONE, MaterialColor.CRIMSON_NYLIUM).strength(1.3f, 0.8f)
					.sound(SoundType.ANCIENT_DEBRIS)));

	public static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
		ItemInit.ITEMS.register(name,
				() -> new BlockItem(BlockInit.BLOODSTONE.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	}
}