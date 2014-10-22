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
	    
	    stack = new ItemStack(Material.DIAMOND_AXE, 1);
	    Meta = stack.getItemMeta();
	    Meta.setDisplayName("§bUnbreaking"); 
	    Meta.addEnchant(Enchantment.DURABILITY, 1, false);
	    Meta.setLore(Arrays.asList("§7Ulepsz na Unbreaking."));
	    stack.setItemMeta(Meta);
	    menu.setItem(11, stack);
	    
	    stack = new ItemStack(Material.DIAMOND_SPADE, 1);
	    Meta = stack.getItemMeta();
	    Meta.setDisplayName("§bFortune"); 
	    Meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 1, false);
	    Meta.setLore(Arrays.asList("§7Ulepsz na Fortune."));
	    stack.setItemMeta(Meta);
	    menu.setItem(12, stack);
	    
	    stack = new ItemStack(Material.DIAMOND_HOE, 1);
	    Meta = stack.getItemMeta();
	    Meta.setDisplayName("§bSilk Touch"); 
	    Meta.addEnchant(Enchantment.SILK_TOUCH, 1, false);
	    Meta.setLore(Arrays.asList("§7Ulepsz na SilkTouch."));
	    stack.setItemMeta(Meta);
	    menu.setItem(13, stack);
	    
	    stack = new ItemStack(Material.FISHING_ROD, 1);
	    Meta = stack.getItemMeta();
	    Meta.setDisplayName("§bLure"); 
	    Meta.addEnchant(Enchantment.LURE, 1, false);
	    Meta.setLore(Arrays.asList("§7Ulepsz na Lure."));
	    stack.setItemMeta(Meta);
	    menu.setItem(15, stack);
	    
	    stack = new ItemStack(Material.FISHING_ROD, 1);
	    Meta = stack.getItemMeta();
	    Meta.setDisplayName("§bLuck Of The Sea"); 
	    Meta.addEnchant(Enchantment.ARROW_DAMAGE, 1, false); //źle bo nie znalazłem!!!! - kuku
	    Meta.setLore(Arrays.asList("§7Ulepsz na LuckOfTheSea."));
	    stack.setItemMeta(Meta);
	    menu.setItem(16, stack);
	    
	    stack = new ItemStack(Material.BOW, 1);
	    Meta = stack.getItemMeta();
	    Meta.setDisplayName("§aPower"); 
	    Meta.addEnchant(Enchantment.ARROW_DAMAGE, 1, false);
	    Meta.setLore(Arrays.asList("§7Ulepsz na Power."));
	    stack.setItemMeta(Meta);
	    menu.setItem(19, stack);
	    
	    stack = new ItemStack(Material.BOW, 1);
	    Meta = stack.getItemMeta();
	    Meta.setDisplayName("§aPunch"); 
	    Meta.addEnchant(Enchantment.ARROW_KNOCKBACK, 1, false);
	    Meta.setLore(Arrays.asList("§7Ulepsz na Punch."));
	    stack.setItemMeta(Meta);
	    menu.setItem(20, stack);
	    
	  }
	  
	  public static void openInv(Player admin){
		  reloadInv(admin);
		  admin.openInventory(menu);
	  }
	  
}
