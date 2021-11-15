package bloodyskies.client.renderer;

import bloodyskies.common.blockentities.TestBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
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

@SuppressWarnings("deprecation")
@OnlyIn(Dist.CLIENT)
public class TestBlockRenderer implements BlockEntityRenderer<TestBlockEntity> {

	private float degrees;

	public TestBlockRenderer(BlockEntityRendererProvider.Context rendererDispatcherIn) {
		super();
		degrees = 0.0f;
	}




	@Override
	public void render(TestBlockEntity blockEntity, float partialTicks, PoseStack poseStack, MultiBufferSource bufferSource, int combinedLight, int combinedOverlay) {
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


	private void renderItem(ItemStack stack, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn,
			int combinedLightIn, int combinedOverlay) {
		BakedModel model = Minecraft.getInstance().getItemRenderer().getModel(stack, null, null, 0);
		Minecraft.getInstance().getItemRenderer().render(stack, ItemTransforms.TransformType.FIXED, true, matrixStackIn, bufferIn, combinedLightIn, combinedOverlay, model);
	}
}
