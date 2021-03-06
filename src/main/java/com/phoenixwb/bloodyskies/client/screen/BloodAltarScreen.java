package com.phoenixwb.bloodyskies.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.phoenixwb.bloodyskies.BloodySkies;
import com.phoenixwb.bloodyskies.common.container.BloodAltarContainer;

import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BloodAltarScreen extends AbstractContainerScreen<BloodAltarContainer> {

    private static final ResourceLocation BLOOD_ALTAR_GUI = new ResourceLocation(BloodySkies.MOD_ID, "textures/gui/blood_altar_gui.png");

    public BloodAltarScreen(BloodAltarContainer screenContainer, Inventory inv, Component title) {
        super(screenContainer, inv, title);

        this.leftPos = 0;
        this.topPos = 0;
        this.imageWidth = 175;
        this.imageHeight = 201;
    }

    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(poseStack);
        super.render(poseStack, mouseX, mouseY, partialTicks);
        this.renderTooltip(poseStack, mouseX, mouseY);
    }

    @Override
    protected void renderLabels(PoseStack poseStack, int p_97809_, int p_97810_) {
        this.font.draw(poseStack, this.playerInventoryTitle.getContents(), (float) this.inventoryLabelX, this.inventoryLabelY, 4210752 );
    }



    @Override
    protected void renderBg(PoseStack poseStack, float partialTicks, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        RenderSystem.setShaderTexture(0, BLOOD_ALTAR_GUI);
        this.minecraft.textureManager.bindForSetup(BLOOD_ALTAR_GUI);
        int x = (this.width - this.imageWidth) / 2;
        int y = (this.height - imageHeight) / 2;
        this.blit(poseStack, x, y, 0, 0, this.imageWidth, this.imageHeight);
    }
}