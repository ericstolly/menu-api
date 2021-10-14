package com.ericstolly.menu.menu.type;

import org.bukkit.event.inventory.InventoryType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public enum MenuType {
	
	AUTOMATIC_ROW_CHEST(InventoryType.CHEST, -1),
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
	@Setter public int size;
}