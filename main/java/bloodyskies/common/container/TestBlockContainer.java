package bloodyskies.common.container;

import bloodyskies.common.blockentities.TestBlockEntity;
import bloodyskies.core.init.BlockInit;
import bloodyskies.core.init.MenuTypesInit;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;

import javax.annotation.Nullable;
import java.util.Objects;

public class TestBlockContainer extends AbstractContainerMenu {

    public final TestBlockEntity be;
    private final ContainerLevelAccess canInteractWithCallable;
    public static ItemStack item;

    public TestBlockContainer(final int windowId, final Inventory inv, final TestBlockEntity be) {
        super(MenuTypesInit.TEST_BLOCK_MENU_TYPE.get(), windowId);
        this.be = be;
        this.canInteractWithCallable = ContainerLevelAccess.create(be.getLevel(), be.getBlockPos());

        // Block Entity
        this.addSlot(new Slot((Container) be, 0, 80, 35));


        // Main Player Inventory
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                this.addSlot(new Slot(inv, col + row * 9 + 9, 8 + col * 18, 166 - (4 - row) * 18 - 10));
            }
        }

        // Player Hotbar
        for (int col = 0; col < 9; col++) {
            this.addSlot(new Slot(inv, col, 8 + col * 18, 142));
        }
    }

    public TestBlockContainer(final int windowId, final Inventory inv, final FriendlyByteBuf data) {
        this(windowId, inv, getBlockEntity(inv, data));
    }

    private static TestBlockEntity getBlockEntity(final Inventory inv, final FriendlyByteBuf data) {
        Objects.requireNonNull(inv, "Player Inventory cannot be null.");
        Objects.requireNonNull(data, "FriendlyByteBuf cannot be null");
        final BlockEntity be = inv.player.level.getBlockEntity(data.readBlockPos());
        if(be instanceof TestBlockEntity) {
            return (TestBlockEntity) be;
        }
        throw new IllegalStateException("Block Entity is Not Correct");
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(canInteractWithCallable, player, BlockInit.TEST_BLOCK.get());
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack stack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if(slot != null && slot.hasItem()) {
            ItemStack stack1 = slot.getItem();
            stack = stack1.copy();
            if(index < TestBlockEntity.slots && !this.moveItemStackTo(stack1, TestBlockEntity.slots, this.slots.size(), true)) {
                return ItemStack.EMPTY;
            }
            if(!this.moveItemStackTo(stack1, 0, this.slots.size(), false)) {
                return ItemStack.EMPTY;
            }

            if(stack1.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }

        return stack;
    }
}
