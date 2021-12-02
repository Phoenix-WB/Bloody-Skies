package com.phoenixwb.bloodyskies.common.block;


import javax.annotation.Nullable;

import com.phoenixwb.bloodyskies.common.blockentities.BloodAltarEntity;
import com.phoenixwb.bloodyskies.core.init.BlockEntityInit;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.fmllegacy.network.NetworkHooks;

public class BloodAltar extends BaseEntityBlock {

    protected static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 16, 16);

    public BloodAltar(Properties p_49224_) {
        super(p_49224_);
    }



    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new BloodAltarEntity(pos, state);
    }

    @Override
    public RenderShape getRenderShape(BlockState p_49232_) {
        return RenderShape.MODEL;
    }

    @Override
    public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        return SHAPE;
    }

    @SuppressWarnings("deprecation")
    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if(!level.isClientSide) {
            BlockEntity be = level.getBlockEntity(pos);
            ItemStack item = player.getItemInHand(hand);
            if (be instanceof BloodAltarEntity) {
                if(!(item.getItem() instanceof SwordItem)) {
                    NetworkHooks.openGui((ServerPlayer) player, (BloodAltarEntity) be, pos);
                } else {
                    ((BloodAltarEntity) be).bloodEssence(item);
                }
            }
        }
        return super.use(state, level, pos, player, hand, result);
    }
    
    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return type == BlockEntityInit.BLOOD_ALTAR_ENTITY.get() ? BloodAltarEntity::tick : null;
    }
}