package com.phoenixwb.bloodyskies.client.render;

import com.phoenixwb.bloodyskies.client.model.BloodjawModel;
import com.phoenixwb.bloodyskies.common.entity.Bloodjaw;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class BloodjawRenderer<Type extends Bloodjaw> extends MobRenderer<Type, BloodjawModel<Type>> {
	private static final ResourceLocation BLOODJAW_LOCATION = new ResourceLocation(
			"textures/entities/bloodjaw.png");

	public BloodjawRenderer(Context context) {
		super(context, new BloodjawModel<>(context.bakeLayer(BloodjawModel.LAYER_LOCATION)), 0.7F);
	}

	@Override
	public ResourceLocation getTextureLocation(Bloodjaw p_114482_) {
		return BLOODJAW_LOCATION;
	}
}