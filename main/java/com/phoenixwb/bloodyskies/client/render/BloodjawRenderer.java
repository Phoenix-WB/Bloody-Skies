package com.phoenixwb.bloodyskies.client.render;

import com.phoenixwb.bloodyskies.BloodySkies;
import com.phoenixwb.bloodyskies.client.model.BloodjawModel;
import com.phoenixwb.bloodyskies.common.entity.Bloodjaw;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class BloodjawRenderer<Type extends Bloodjaw> extends MobRenderer<Type, BloodjawModel<Type>> {
	private static final ResourceLocation BLOODJAW_LOCATION = new ResourceLocation(BloodySkies.MOD_ID,
			"textures/entity/bloodjaw/bloodjaw.png");

	public BloodjawRenderer(EntityRendererProvider.Context context) {
		super(context, new BloodjawModel<>(context.bakeLayer(BloodjawModel.LAYER_LOCATION)), 0.5F);
	}

	@Override
	public ResourceLocation getTextureLocation(Type p_114482_) {
		return BLOODJAW_LOCATION;
	}
}