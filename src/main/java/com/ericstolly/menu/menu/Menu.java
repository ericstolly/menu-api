package com.ericstolly.menu.menu;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import com.ericstolly.menu.button.MenuButton;
import com.ericstolly.menu.menu.type.MenuType;
import com.ericstolly.menu.menu.update.MenuUpdateTask;
import com.ericstolly.menu.menu.update.MenuUpdateType;

import lombok.Getter;
import lombok.NonNull;

@Getter
public abstract class Menu {
	
	private JavaPlugin owningPlugin;
	private Inventory inventory;
	private BukkitTask updateRunnable;
	
	@Getter public static Map<Player, Menu> openedMenus = new HashMap<Player, Menu>();
	
	// This is used to add compatibility to people who are using the plugin in a .jar format.
	public Menu(final @NonNull JavaPlugin owningPlugin) {
		this.owningPlugin = owningPlugin;
	}
	
	public void open(final @NonNull Player player) {
		open(player, false);
	}

	public void open(final @NonNull Player player, final boolean update) {
		String title = ChatColor.translateAlternateColorCodes('&', getTitle(player));
		
		// Removes any characters that breach the 32 character line limit.
		if (title.length() > 32) {
			title = title.substring(0, 32);
		}
		
		// Prevents opening a menu that has more buttons that it can physically fit.
		if (getButtons(player).size() > getMenuType().getSize()) return;
		
		// Checks if the menu is being updated or freshly opened.
		if (update) {
			inventory = player.getOpenInventory().getTopInventory();
		} else {
			// Allows for sizing of regular chest menus when possible.
			if (getMenuType().getInventoryType().equals(InventoryType.CHEST)) {
				inventory = Bukkit.createInventory(player, getMenuType().getSize(), title);
			} else {
				inventory = Bukkit.createInventory(player, getMenuType().getInventoryType(), title);
			}
		}
		
		// Adds buttons to said menu.
		getButtons(player).forEach((slot, button) -> {
			inventory.setItem(slot, button.getItemStack(player));
		});
		
		// Checks if menu is being updated or freshly opened once again.
		if (update) {
			player.updateInventory();
		} else {
			player.openInventory(inventory);
			
			// Creates new runnable if applicable.
			if (getUpdateType().equals(MenuUpdateType.RUNNABLE)) {
				updateRunnable = new MenuUpdateTask(player, this).runTaskTimer(owningPlugin, 20L, 20L);	
			}
			
			// Adds menu to list of opened menus.
			openedMenus.put(player, this);
		}
	}
	
	public abstract Map<Integer, MenuButton> getButtons(final @NonNull Player player);
	
	public abstract String getTitle(final @NonNull Player player);
	
	public abstract MenuType getMenuType();
	
	public MenuUpdateType getUpdateType() {
		return MenuUpdateType.NONE;
	}
	
	public static Menu getByPlayer(final @NonNull Player player) {
		if (openedMenus.containsKey(player)) {
			return openedMenus.get(player);
		}
		
		return null;
	}
}