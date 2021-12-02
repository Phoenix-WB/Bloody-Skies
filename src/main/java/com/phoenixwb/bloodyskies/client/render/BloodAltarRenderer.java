package com.phoenixwb.bloodyskies.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import com.phoenixwb.bloodyskies.common.blockentities.BloodAltarEntity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BloodAltarRenderer implements BlockEntityRenderer<BloodAltarEntity> {

	private float degrees;
	private static Minecraft minecraft = Minecraft.getInstance();

	public BloodAltarRenderer(BlockEntityRendererProvider.Context rendererDispatcherIn) {
		super();
		degrees = 0.0f;
	}

	@Override
	public void render(BloodAltarEntity blockEntity, float partialTicks, PoseStack poseStack,
			MultiBufferSource bufferSource, int combinedLight, int combinedOverlay) {
		NonNullList<ItemStack> items = blockEntity.getItems();
		for (ItemStack stack : items) {
			if (!stack.isEmpty()) {
				poseStack.pushPose();
				poseStack.translate(0.5D, 1.5D, 0.5D);
				float currentTime = blockEntity.getLevel().getGameTime() + partialTicks;
				poseStack.translate(0D, (Math.sin(Math.PI * currentTime / 16) / 4) + 0.1D, 0D);
				poseStack.mulPose(Vector3f.YP.rotationDegrees(degrees++ / 2));
				renderItem(stack, partialTicks, poseStack, bufferSource, combinedLight, combinedOverlay);
				poseStack.popPose();
			}
		}
	}

	private void renderItem(ItemStack stack, float partialTicks, PoseStack poseStack, MultiBufferSource buffer,
			int combinedLight, int combinedOverlay) {
		poseStack.pushPose();
		poseStack.scale(0.87F, 0.87F, 0.87F);
		poseStack.translate(0, 0.25, 0);
		BakedModel model = minecraft.getItemRenderer().getModel(stack, null, null, 0);
		minecraft.getItemRenderer().render(stack, ItemTransforms.TransformType.FIXED, true, poseStack, buffer,
				combinedLight, combinedOverlay, model);
		poseStack.popPose();
	}

}