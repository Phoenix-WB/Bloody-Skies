package com.phoenixwb.bloodyskies.core.creativemodetab;

import com.phoenixwb.bloodyskies.core.init.ItemInit;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class BloodySkiesCreativeModeTab extends CreativeModeTab {
	public static final BloodySkiesCreativeModeTab BLOODY_SKIES = new BloodySkiesCreativeModeTab(CreativeModeTab.TABS.length,
			"bloody_skies");

	public BloodySkiesCreativeModeTab(int p_i1853_1_, String p_i1853_2_) {
		super(p_i1853_1_, p_i1853_2_);
	}

	@Override
	public ItemStack makeIcon() {
		return new ItemStack(ItemInit.VILLAGER_HEART.get());
	}
}
