package com.ericstolly.menu.button.update;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.ericstolly.menu.Menu;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ButtonUpdateTask extends BukkitRunnable {
	
	public Player player;
	public Menu menu;
	
	public void run() {
		menu.open(player, true);
	}
}
