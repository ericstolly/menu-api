package com.ericstolly.menu.button;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.ericstolly.menu.button.listener.MenuButtonListener;

import lombok.NonNull;

public abstract class MenuButton {
	
	public abstract boolean isEditable(final @NonNull Player player);
	
	public abstract ItemStack getItemStack(final @NonNull Player player);
	
	public abstract MenuButtonListener getButtonListener(final @NonNull Player player);
}