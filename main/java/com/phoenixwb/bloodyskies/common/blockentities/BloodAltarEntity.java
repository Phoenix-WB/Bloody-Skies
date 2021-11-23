package com.phoenixwb.bloodyskies.common.blockentities;

import com.phoenixwb.bloodyskies.BloodySkies;
import com.phoenixwb.bloodyskies.common.container.BloodAltarContainer;
import com.phoenixwb.bloodyskies.core.init.BlockEntityInit;

import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class BloodAltarEntity extends RandomizableContainerBlockEntity {

    public static int slots = 1;

    protected NonNullList<ItemStack> items = NonNullList.withSize(slots, ItemStack.EMPTY);

    public BloodAltarEntity(BlockPos p_155229_, BlockState p_155230_) {
        super(BlockEntityInit.BLOOD_ALTAR_ENTITY.get(), p_155229_, p_155230_);
    }

    @Override
    public NonNullList<ItemStack> getItems() {
        return this.items;
    }

    @Override
    public void setItems(NonNullList<ItemStack> items) {
        this.items = items;
    }

    @Override
    protected Component getDefaultName() {
        return new TranslatableComponent("container." + BloodySkies.MOD_ID + ".test_block");
    }

    @Override
    protected AbstractContainerMenu createMenu(int id, Inventory player) {
        return new BloodAltarContainer(id, player, this);
    }

    @Override
    public int getContainerSize() {
        return slots;
    }

    @Override
    public CompoundTag save(CompoundTag compound) {
        super.save(compound);
        if(!this.trySaveLootTable(compound)) {
            ContainerHelper.saveAllItems(compound, items);
        }

        return compound;
    }


    public void load(CompoundTag nbt) {
        super.load(nbt);
        this.items  = NonNullList.withSize(getContainerSize(), ItemStack.EMPTY);
        if(!this.tryLoadLootTable(nbt)) {
            ContainerHelper.loadAllItems(nbt, this.items);
        }
    }
}