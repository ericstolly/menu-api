package com.ericstolly.menu.button.impl;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.ericstolly.menu.button.MenuButton;
import com.ericstolly.menu.button.listener.MenuButtonListener;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
public class SimpleButton extends MenuButton {
	
	public ItemStack itemstack;
	public boolean editable;
	public MenuButtonListener buttonListener;

	@Override
	public ItemStack getItemStack(final @NonNull Player player) {
		return itemstack;
	}

	@Override
	public boolean isEditable(final @NonNull Player player) {
		return editable;
	}

	@Override
	public MenuButtonListener getButtonListener(@NonNull Player player) {
		return buttonListener;
	}
}