package com.gmail.kukubaczek.SmartAdmin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PlayerMenuCreator {
	
	 public static void reloadInv(Player admin, Player player) {
		 String name = player.getName();
		 Inventory menu = Bukkit.createInventory(null, 54, "§aS§fmart§bAdmin: §e" + name);
		 ItemStack stack = new ItemStack (Material.APPLE, 1);
		 menu.setItem(1, stack);
		 
		 admin.openInventory(menu);
	 }
}
