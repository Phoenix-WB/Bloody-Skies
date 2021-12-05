package com.phoenixwb.bloodyskies.core.init;

import com.phoenixwb.bloodyskies.BloodySkies;
import com.phoenixwb.bloodyskies.common.entity.Bloodjaw;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityTypesInit {

	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES,
			BloodySkies.MOD_ID);

	public static final RegistryObject<EntityType<Bloodjaw>> BLOODJAW = ENTITY_TYPES.register("bloodjaw",
			() -> EntityType.Builder.of(Bloodjaw::new, MobCategory.MONSTER).fireImmune().sized(1.3964844F, 1.4F)
					.build(new ResourceLocation(BloodySkies.MOD_ID, "bloodjaw").toString()));
}
