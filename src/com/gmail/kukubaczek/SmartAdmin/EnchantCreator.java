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
	    Meta.setDisplayName("§aEfficiency"); 
	    Meta.addEnchant(Enchantment.DIG_SPEED, 1, false);
	    Meta.setLore(Arrays.asList("§7Ulepsz na Efficiency."));
	    stack.setItemMeta(Meta);
	    menu.setItem(0, stack);
	    
	    stack = new ItemStack(Material.DIAMOND_AXE, 1);
	    Meta = stack.getItemMeta();
	    Meta.setDisplayName("§aUnbreaking"); 
	    Meta.addEnchant(Enchantment.DURABILITY, 1, false);
	    Meta.setLore(Arrays.asList("§7Ulepsz na Unbreaking."));
	    stack.setItemMeta(Meta);
	    menu.setItem(1, stack);
	    
	    stack = new ItemStack(Material.DIAMOND_SPADE, 1);
	    Meta = stack.getItemMeta();
	    Meta.setDisplayName("§aFortune"); 
	    Meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 1, false);
	    Meta.setLore(Arrays.asList("§7Ulepsz na Fortune."));
	    stack.setItemMeta(Meta);
	    menu.setItem(2, stack);
	    
	    stack = new ItemStack(Material.DIAMOND_HOE, 1);
	    Meta = stack.getItemMeta();
	    Meta.setDisplayName("§aSilk Touch"); 
	    Meta.addEnchant(Enchantment.SILK_TOUCH, 1, false);
	    Meta.setLore(Arrays.asList("§7Ulepsz na SilkTouch."));
	    stack.setItemMeta(Meta);
	    menu.setItem(3, stack);
	    
	    stack = new ItemStack(Material.FISHING_ROD, 1);
	    Meta = stack.getItemMeta();
	    Meta.setDisplayName("§aLure"); 
	    Meta.addEnchant(Enchantment.LURE, 1, false);
	    Meta.setLore(Arrays.asList("§7Ulepsz na Lure."));
	    stack.setItemMeta(Meta);
	    menu.setItem(4, stack);
	    
	    stack = new ItemStack(Material.FISHING_ROD, 1);
	    Meta = stack.getItemMeta();
	    Meta.setDisplayName("§aLuck of the Sea"); 
	    Meta.addEnchant(Enchantment.LUCK, 1, false); //źle bo nie znalazłem!!!! - kuku
	    Meta.setLore(Arrays.asList("§7Ulepsz na Luck of the Sea."));
	    stack.setItemMeta(Meta);
	    menu.setItem(5, stack);
	    
	    stack = new ItemStack(Material.BOW, 1);
	    Meta = stack.getItemMeta();
	    Meta.setDisplayName("§aPower"); 
	    Meta.addEnchant(Enchantment.ARROW_DAMAGE, 1, false);
	    Meta.setLore(Arrays.asList("§7Ulepsz na Power."));
	    stack.setItemMeta(Meta);
	    menu.setItem(6, stack);
	    
	    stack = new ItemStack(Material.BOW, 1);
	    Meta = stack.getItemMeta();
	    Meta.setDisplayName("§aPunch"); 
	    Meta.addEnchant(Enchantment.ARROW_KNOCKBACK, 1, false);
	    Meta.setLore(Arrays.asList("§7Ulepsz na Punch."));
	    stack.setItemMeta(Meta);
	    menu.setItem(7, stack);
	    
	    stack = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
      Meta = stack.getItemMeta();
      Meta.setDisplayName("§aProtection"); 
      Meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, false);
      Meta.setLore(Arrays.asList("§7Ulepsz na Protection."));
      stack.setItemMeta(Meta);
      menu.setItem(8, stack);
      
      stack = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
      Meta = stack.getItemMeta();
      Meta.setDisplayName("§aFire Protection"); 
      Meta.addEnchant(Enchantment.PROTECTION_FIRE, 1, false);
      Meta.setLore(Arrays.asList("§7Ulepsz na Fire Protection."));
      stack.setItemMeta(Meta);
      menu.setItem(9, stack);
      
      stack = new ItemStack(Material.FEATHER, 1);
      Meta = stack.getItemMeta();
      Meta.setDisplayName("§aFeather Falling"); 
      Meta.addEnchant(Enchantment.PROTECTION_FALL, 1, false);
      Meta.setLore(Arrays.asList("§7Ulepsz na Feather Falling."));
      stack.setItemMeta(Meta);
      menu.setItem(10, stack);
      
      stack = new ItemStack(Material.TNT, 1);
      Meta = stack.getItemMeta();
      Meta.setDisplayName("§aBlast Protection"); 
      Meta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 1, false);
      Meta.setLore(Arrays.asList("§7Ulepsz na Blast Protection."));
      stack.setItemMeta(Meta);
      menu.setItem(11, stack);
      
      stack = new ItemStack(Material.ARROW, 1);
      Meta = stack.getItemMeta();
      Meta.setDisplayName("§aProjectile Protection"); 
      Meta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 1, false);
      Meta.setLore(Arrays.asList("§7Ulepsz na Projectile Protection."));
      stack.setItemMeta(Meta);
      menu.setItem(12, stack);
      
      stack = new ItemStack(Material.GLASS, 1);
      Meta = stack.getItemMeta();
      Meta.setDisplayName("§aRespiration"); 
      Meta.addEnchant(Enchantment.OXYGEN, 1, false);
      Meta.setLore(Arrays.asList("§7Ulepsz na Respiration."));
      stack.setItemMeta(Meta);
      menu.setItem(13, stack);
      
      stack = new ItemStack(Material.WATER_LILY, 1);
      Meta = stack.getItemMeta();
      Meta.setDisplayName("§aAqua Affinity"); 
      Meta.addEnchant(Enchantment.WATER_WORKER, 1, false);
      Meta.setLore(Arrays.asList("§7Ulepsz na Aqua Affinity."));
      stack.setItemMeta(Meta);
      menu.setItem(14, stack);
      
      stack = new ItemStack(Material.STONE, 1);
      Meta = stack.getItemMeta();
      Meta.setDisplayName("§aThorns"); 
      Meta.addEnchant(Enchantment.THORNS, 1, false);
      Meta.setLore(Arrays.asList("§7Ulepsz na Thorns."));
      stack.setItemMeta(Meta);
      menu.setItem(15, stack);
      
      stack = new ItemStack(Material.DIAMOND_SWORD, 1);
      Meta = stack.getItemMeta();
      Meta.setDisplayName("§aSharpness"); 
      Meta.addEnchant(Enchantment.DAMAGE_ALL, 1, false);
      Meta.setLore(Arrays.asList("§7Ulepsz na Sharpness."));
      stack.setItemMeta(Meta);
      menu.setItem(16, stack);
      
      stack = new ItemStack(Material.SKULL_ITEM, 1, (short) 2);
      Meta = stack.getItemMeta();
      Meta.setDisplayName("§aSmite"); 
      Meta.addEnchant(Enchantment.DAMAGE_UNDEAD, 1, false);
      Meta.setLore(Arrays.asList("§7Ulepsz na Smite."));
      stack.setItemMeta(Meta);
      menu.setItem(17, stack);
      
      stack = new ItemStack(Material.SPIDER_EYE, 1);
      Meta = stack.getItemMeta();
      Meta.setDisplayName("§aBane of Arthropods"); 
      Meta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, 1, false);
      Meta.setLore(Arrays.asList("§7Ulepsz na Bane of Arthropods."));
      stack.setItemMeta(Meta);
      menu.setItem(18, stack);
      
      stack = new ItemStack(Material.STONE, 1);
      Meta = stack.getItemMeta();
      Meta.setDisplayName("§aKnockback"); 
      Meta.addEnchant(Enchantment.KNOCKBACK, 1, false);
      Meta.setLore(Arrays.asList("§7Ulepsz na Knockback."));
      stack.setItemMeta(Meta);
      menu.setItem(19, stack);
      
      stack = new ItemStack(Material.FIRE, 1);
      Meta = stack.getItemMeta();
      Meta.setDisplayName("§aFire Aspect"); 
      Meta.addEnchant(Enchantment.FIRE_ASPECT, 1, false);
      Meta.setLore(Arrays.asList("§7Ulepsz na Fire Aspect."));
      stack.setItemMeta(Meta);
      menu.setItem(20, stack);
      
      stack = new ItemStack(Material.BONE, 8);
      Meta = stack.getItemMeta();
      Meta.setDisplayName("§aLooting"); 
      Meta.addEnchant(Enchantment.LOOT_BONUS_MOBS, 1, false);
      Meta.setLore(Arrays.asList("§7Ulepsz na Looting."));
      stack.setItemMeta(Meta);
      menu.setItem(21, stack);
      
      stack = new ItemStack(Material.ARROW, 64);
      Meta = stack.getItemMeta();
      Meta.setDisplayName("§aInfinity"); 
      Meta.addEnchant(Enchantment.ARROW_INFINITE, 1, false);
      Meta.setLore(Arrays.asList("§7Ulepsz na Infinity."));
      stack.setItemMeta(Meta);
      menu.setItem(22, stack);
      
      stack = new ItemStack(Material.FIREWORK, 1);
      Meta = stack.getItemMeta();
      Meta.setDisplayName("§aFlame"); 
      Meta.addEnchant(Enchantment.ARROW_FIRE, 1, false);
      Meta.setLore(Arrays.asList("§7Ulepsz na Flame."));
      stack.setItemMeta(Meta);
      menu.setItem(23, stack);
	  }
	  
	  public static void openInv(Player admin){
		  reloadInv(admin);
		  admin.openInventory(menu);
	  }
	  
}
