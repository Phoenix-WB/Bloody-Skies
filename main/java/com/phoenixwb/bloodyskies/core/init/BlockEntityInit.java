package com.phoenixwb.bloodyskies.core.init;

import com.phoenixwb.bloodyskies.BloodySkies;
import com.phoenixwb.bloodyskies.common.blockentities.BloodAltarEntity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockEntityInit {

	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister
			.create(ForgeRegistries.BLOCK_ENTITIES, BloodySkies.MOD_ID);

	public static final RegistryObject<BlockEntityType<BloodAltarEntity>> BLOOD_ALTAR_ENTITY = BLOCK_ENTITIES.register(
			"blood_altar",
			() -> BlockEntityType.Builder.of(BloodAltarEntity::new, BlockInit.BLOOD_ALTAR.get()).build(null));
}