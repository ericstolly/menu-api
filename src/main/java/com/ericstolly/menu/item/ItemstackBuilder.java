package com.ericstolly.menu.item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import lombok.NonNull;

public class ItemstackBuilder implements Listener {

	private ItemStack itemStack;

	public ItemstackBuilder(final @NonNull Material material) {
		itemStack = new ItemStack(material);
	}

	public ItemstackBuilder(final @NonNull ItemStack itemStack) {
		this.itemStack = itemStack;
	}

	public ItemstackBuilder amount(final int amount) {
		itemStack.setAmount(amount);
		
		return this;
	}

	public ItemstackBuilder name(final @NonNull String name) {
		ItemMeta meta = itemStack.getItemMeta();
		
		meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
		
		itemStack.setItemMeta(meta);
		
		return this;
	}

	public ItemstackBuilder lore(final @NonNull String name) {
		ItemMeta meta = itemStack.getItemMeta();
		List<String> lore = meta.getLore();

		if (lore == null) {
			lore = new ArrayList<>();
		}

		lore.add(ChatColor.translateAlternateColorCodes('&', name));
		
		meta.setLore(lore);

		itemStack.setItemMeta(meta);

		return this;
	}

	public ItemstackBuilder lore(final @NonNull String... lore) {		
		List<String> toSet = new ArrayList<>();
		ItemMeta itemMeta = itemStack.getItemMeta();
		
		Arrays.asList(lore).forEach(string -> {
			toSet.add(ChatColor.translateAlternateColorCodes('&', string));
		});

		itemMeta.setLore(toSet);
		
		itemStack.setItemMeta(itemMeta);

		return this;
	}

	public ItemstackBuilder lore(final @NonNull List<String> lore) {		
		List<String> toSet = new ArrayList<>();
		ItemMeta itemMeta = itemStack.getItemMeta();
		
		lore.forEach(string -> {
			toSet.add(ChatColor.translateAlternateColorCodes('&', string));
		});

		itemMeta.setLore(toSet);
		
		itemStack.setItemMeta(itemMeta);

		return this;
	}

	public ItemstackBuilder durability(final int durability) {
		itemStack.setDurability((short) durability);		
		return this;
	}

	public ItemstackBuilder enchantment(final @NonNull Enchantment enchantment, final int level) {
		itemStack.addUnsafeEnchantment(enchantment, level);		
		return this;
	}

	public ItemstackBuilder enchantment(final @NonNull Enchantment enchantment) {
		itemStack.addUnsafeEnchantment(enchantment, 1);
		return this;
	}

	public ItemstackBuilder type(final @NonNull Material material) {
		itemStack.setType(material);
		return this;
	}

	public ItemstackBuilder clearLore() {
		ItemMeta meta = itemStack.getItemMeta();

		meta.setLore(new ArrayList<>());
		
		itemStack.setItemMeta(meta);

		return this;
	}

	public ItemstackBuilder clearEnchantments() {
		itemStack.getEnchantments().keySet().forEach(enchantment -> itemStack.removeEnchantment(enchantment));
		return this;
	}

	public ItemStack build() {
		return itemStack;
	}
}