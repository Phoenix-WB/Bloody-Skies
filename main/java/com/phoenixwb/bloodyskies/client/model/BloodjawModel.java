package com.phoenixwb.bloodyskies.client.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.phoenixwb.bloodyskies.BloodySkies;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.hoglin.HoglinBase;

public class BloodjawModel<Type extends Entity & HoglinBase> extends EntityModel<Type> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation(BloodySkies.MOD_ID, "bloodjaw"), "main");
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart right_ear;
	private final ModelPart left_ear;
	private final ModelPart leg_back_right;
	private final ModelPart leg_back_left;
	private final ModelPart leg_front_right;
	private final ModelPart leg_front_left;

	public BloodjawModel(ModelPart root) {
		this.body = root.getChild("body");
		this.head = body.getChild("head");
		this.right_ear = head.getChild("right_ear");
		this.left_ear = head.getChild("left_ear");
		this.leg_back_right = root.getChild("leg_back_right");
		this.leg_back_left = root.getChild("leg_back_left");
		this.leg_front_right = root.getChild("leg_front_right");
		this.leg_front_left = root.getChild("leg_front_left");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-8.0F, -6.0F, -4.0F, 16.0F, 14.0F, 26.0F, new CubeDeformation(0.02F)).texOffs(0, 46)
						.addBox(0.0F, -13.0F, -7.0F, 0.0F, 10.0F, 19.0F, new CubeDeformation(0.02F)),
				PartPose.offset(0.0F, 5.0F, -3.0F));

		PartDefinition head = body.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(0, 40)
						.addBox(-7.0F, -5.0F, -19.0F, 14.0F, 6.0F, 19.0F, new CubeDeformation(0.0F)).texOffs(8, 40)
						.addBox(-8.0F, -8.0F, -11.5F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 40)
						.addBox(6.0F, -8.0F, -11.5F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(8, 48)
						.addBox(6.0F, -7.0F, -14.8F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 48)
						.addBox(-8.0F, -7.0F, -14.8F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(38, 65)
						.addBox(6.0F, -6.0F, -18.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(18, 0)
						.addBox(-8.0F, -6.0F, -18.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -3.0F, -2.0F, 0.8727F, 0.0F, 0.0F));

		head.addOrReplaceChild("right_ear",
				CubeListBuilder.create().texOffs(58, 20).addBox(-6.0F, 0.0F, -3.0F, 6.0F, 1.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-7.0F, -5.0F, -2.0F, 0.0F, 0.0F, -0.8727F));

		head.addOrReplaceChild("left_ear",
				CubeListBuilder.create().texOffs(0, 20).addBox(0.0F, 0.0F, -3.0F, 6.0F, 1.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(7.0F, -5.0F, -2.0F, 0.0F, 0.0F, 0.8727F));

		partdefinition.addOrReplaceChild("leg_back_right", CubeListBuilder.create()
				.texOffs(61, 60).addBox(-14.0F, -3.0F, -4.0F, 5.0F, 11.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(6.0F, 16.0F, 17.0F));

		partdefinition.addOrReplaceChild("leg_back_left", CubeListBuilder.create()
				.texOffs(47, 40).addBox(9.0F, -3.0F, -4.0F, 5.0F, 11.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-6.0F, 16.0F, 17.0F));

		partdefinition.addOrReplaceChild("leg_front_right", CubeListBuilder.create()
				.texOffs(58, 0).addBox(-2.0F, -2.0F, -3.0F, 6.0F, 14.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-6.0F, 12.0F, -3.0F));

		partdefinition.addOrReplaceChild("leg_front_left", CubeListBuilder.create()
				.texOffs(0, 0).addBox(-4.0F, -2.0F, -3.0F, 6.0F, 14.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(6.0F, 12.0F, -3.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	protected Iterable<ModelPart> headParts() {
		return ImmutableList.of(this.head);
	}

	protected Iterable<ModelPart> bodyParts() {
		return ImmutableList.of(this.body, this.leg_front_right, this.leg_front_left, this.leg_back_right,
				this.leg_back_left);
	}

	public void setupAnim(Type p_102744_, float p_102745_, float p_102746_, float p_102747_, float p_102748_,
			float p_102749_) {
		this.right_ear.zRot = -0.6981317F - p_102746_ * Mth.sin(p_102745_);
		this.left_ear.zRot = 0.6981317F + p_102746_ * Mth.sin(p_102745_);
		this.head.yRot = p_102748_ * ((float) Math.PI / 180F);
		int i = p_102744_.getAttackAnimationRemainingTicks();
		float f = 1.0F - (float) Mth.abs(10 - 2 * i) / 10.0F;
		this.head.xRot = Mth.lerp(f, 0.87266463F, -0.34906584F);
		this.leg_front_right.xRot = Mth.cos(p_102745_) * 1.2F * p_102746_;
		this.leg_front_left.xRot = Mth.cos(p_102745_ + (float) Math.PI) * 1.2F * p_102746_;
		this.leg_back_right.xRot = this.leg_front_left.xRot;
		this.leg_back_left.xRot = this.leg_front_right.xRot;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		body.render(poseStack, buffer, packedLight, packedOverlay);
		leg_back_right.render(poseStack, buffer, packedLight, packedOverlay);
		leg_back_left.render(poseStack, buffer, packedLight, packedOverlay);
		leg_front_right.render(poseStack, buffer, packedLight, packedOverlay);
		leg_front_left.render(poseStack, buffer, packedLight, packedOverlay);
	}
}