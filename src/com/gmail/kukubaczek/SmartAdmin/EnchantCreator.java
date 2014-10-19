package com.gmail.kukubaczek.SmartAdmin;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class EnchantCreator {

	  static Inventory menu = Bukkit.createInventory(null, 54, "§aS§fmart§bA§fdmin: §eEnchant");

	  public static void reloadInv(Player player) {

		menu.clear();  
		  
	    ItemStack stack = new ItemStack(Material.DIAMOND_PICKAXE, 1);
	    ItemMeta Meta = stack.getItemMeta();
	    Meta.setDisplayName("§bEfficiency"); 
	    Meta.addEnchant(Enchantment.DIG_SPEED, 1, false);
	    Meta.setLore(Arrays.asList("§7Ulepsz na Efficiency."));
	    stack.setItemMeta(Meta);
	    menu.setItem(10, stack);
	    
	  }
	  
	  public static void openInv(Player admin){
		  reloadInv(admin);
		  admin.openInventory(menu);
	  }
	  
}
