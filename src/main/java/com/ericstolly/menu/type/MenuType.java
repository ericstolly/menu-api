package com.ericstolly.menu.type;

import org.bukkit.event.inventory.InventoryType;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MenuType {
	
	SINGLE_ROW_CHEST(InventoryType.CHEST, 9),
	DOUBLE_ROW_CHEST(InventoryType.CHEST, 18),
	TRIPPLE_ROW_CHEST(InventoryType.CHEST, 27),
	QUADRUPLE_ROW_CHEST(InventoryType.CHEST, 36),
	QUINTUPLE_ROW_CHEST(InventoryType.CHEST, 45),
	SEXTUPLE_ROW_CHEST(InventoryType.CHEST, 54),
	HOPPER(InventoryType.HOPPER, 5),
	BREWING_STAND(InventoryType.BREWING, 4),
	DISPENSER(InventoryType.DISPENSER, 9),
	DROPPER(InventoryType.DROPPER, 9);
	
	public InventoryType inventoryType;
	public int size;
}