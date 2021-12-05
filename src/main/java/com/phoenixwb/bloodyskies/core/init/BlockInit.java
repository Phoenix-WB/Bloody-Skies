package com.phoenixwb.bloodyskies.core.init;

import com.phoenixwb.bloodyskies.BloodySkies;
import com.phoenixwb.bloodyskies.common.block.BloodAltar;
import com.phoenixwb.bloodyskies.common.block.ClotLilyBlock;
import com.phoenixwb.bloodyskies.common.block.PedestalBlock;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			BloodySkies.MOD_ID);

	public static final RegistryObject<Block> BLOODSTONE = BLOCKS.register("bloodstone",
			() -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.CRIMSON_NYLIUM)
					.strength(3f, 0.8f).sound(SoundType.ANCIENT_DEBRIS).requiresCorrectToolForDrops()));

	public static final RegistryObject<Block> BLOOD_ALTAR = BLOCKS.register("blood_altar",
			() -> new BloodAltar(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_RED)
					.strength(1.5F, 6.0F).sound(SoundType.STONE).noOcclusion().requiresCorrectToolForDrops()));

	public static final RegistryObject<Block> CLOT_LILY = BLOCKS.register("clot_lily",
			() -> new ClotLilyBlock(MobEffects.HUNGER, 240,
					BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
	
	public static final RegistryObject<Block> PEDESTAL = BLOCKS.register("pedestal",
			() -> new PedestalBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE)
					.strength(1.5F, 6.0F).sound(SoundType.STONE).requiresCorrectToolForDrops()));
}
