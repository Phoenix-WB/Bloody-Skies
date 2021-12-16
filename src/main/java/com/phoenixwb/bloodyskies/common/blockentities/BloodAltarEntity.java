package com.phoenixwb.bloodyskies.common.blockentities;

import java.util.ArrayList;

import com.phoenixwb.bloodyskies.BloodySkies;
import com.phoenixwb.bloodyskies.common.container.BloodAltarContainer;
import com.phoenixwb.bloodyskies.core.init.BlockEntityInit;
import com.phoenixwb.bloodyskies.core.init.ItemInit;

import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

public class BloodAltarEntity extends RandomizableContainerBlockEntity {

	private static final int diameter = 20;
	private static final int radius = diameter / 2;
	public static int slots = 1;

	protected NonNullList<ItemStack> items = NonNullList.withSize(slots, ItemStack.EMPTY);

	public BloodAltarEntity(BlockPos pos, BlockState state) {
		super(BlockEntityInit.BLOOD_ALTAR_ENTITY.get(), pos, state);
	}

	public void resetItems() {
		this.items = NonNullList.withSize(slots, ItemStack.EMPTY);
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
		if (!this.trySaveLootTable(compound)) {
			ContainerHelper.saveAllItems(compound, items);
		}

		return compound;
	}

	public void load(CompoundTag nbt) {
		super.load(nbt);
		this.items = NonNullList.withSize(getContainerSize(), ItemStack.EMPTY);
		if (!this.tryLoadLootTable(nbt)) {
			ContainerHelper.loadAllItems(nbt, this.items);
		}
	}

	public static <T extends BlockEntity> void tick(Level level, BlockPos pos, BlockState state, T blockEntity) {
		ArrayList<Player> rangePlayers = (ArrayList<Player>) level.getEntitiesOfClass(Player.class,
				new AABB(pos).inflate((diameter / 2) + 1));

		if (rangePlayers == null) {
			return;
		}

		ItemStack itemStack = ((BloodAltarEntity) level.getBlockEntity(pos)).getItems().get(0);

		if (!itemStack.getItem().equals(ItemInit.VILLAGER_HEART.get())) {
			return;
		}

		for (int i = 0; !rangePlayers.isEmpty(); i++) {
			BlockPos playerPos = rangePlayers.get(i).blockPosition();
			BlockPos worldPosition = blockEntity.getBlockPos();

			int playerX = playerPos.getX();
			int playerY = playerPos.getY();
			int playerZ = playerPos.getZ();

			int blockX = worldPosition.getX();
			int blockY = worldPosition.getY();
			int blockZ = worldPosition.getZ();

			boolean betweenX = blockX - radius < playerX && blockX + radius > playerX;
			boolean betweenY = blockY - radius < playerY && blockY + radius > playerY;
			boolean betweenZ = blockZ - radius < playerZ && blockZ + radius > playerZ;

			if (betweenX && betweenY && betweenZ) {
				rangePlayers.get(i).addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 300), rangePlayers.get(i));
				rangePlayers.get(i).addEffect(new MobEffectInstance(MobEffects.JUMP, 300), rangePlayers.get(i));
				rangePlayers.get(i).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300),
						rangePlayers.get(i));
				rangePlayers.get(i).addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 300), rangePlayers.get(i));
			}
			rangePlayers.remove(i);
		}
	}
}