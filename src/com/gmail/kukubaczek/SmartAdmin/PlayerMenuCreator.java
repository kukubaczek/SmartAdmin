package com.gmail.kukubaczek.SmartAdmin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerMenuCreator {
	
	 public static void reloadInv(Player admin, String player) {
		 Inventory menu = Bukkit.createInventory(null, 54, "§aS§fmart§bAdmin: §e" + player);
		 
		 //kick
		 ItemStack stack = new ItemStack (Material.APPLE, 1);
		 ItemMeta meta = stack.getItemMeta();
		 meta.setDisplayName("§cKick");
		 stack.setItemMeta(meta);
		 menu.setItem(9, stack);
		 
		 //heal
		 ItemStack stack1 = new ItemStack (Material.APPLE, 1);
		 ItemMeta meta1 = stack1.getItemMeta();
		 meta1.setDisplayName("§aHeal");
		 stack1.setItemMeta(meta1);
		 menu.setItem(1, stack1);
		 
		 admin.openInventory(menu);
	 }
}
