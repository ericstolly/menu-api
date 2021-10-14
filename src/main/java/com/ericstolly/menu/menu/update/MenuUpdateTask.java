package com.ericstolly.menu.menu.update;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.ericstolly.menu.menu.Menu;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MenuUpdateTask extends BukkitRunnable {
	
	public final Player player;
	public final Menu menu;
	
	public void run() {
		menu.open(player, true);
	}
}
