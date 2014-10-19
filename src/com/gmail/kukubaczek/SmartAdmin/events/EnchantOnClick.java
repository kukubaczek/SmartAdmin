package com.gmail.kukubaczek.SmartAdmin.events;

import org.bukkit.Bukkit;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class EnchantOnClick implements Listener {
	
	  @EventHandler
	  public void onInventoryClick(InventoryClickEvent event) {
	    Player player = (Player) event.getWhoClicked();
	    Inventory inventory = event.getInventory();
	    if((inventory.getName().equals("§aS§fmart§bA§fdmin: §eEnchant")) && (event.getCurrentItem() != null)){
	      if(player.hasPermission("SmartAdmin.*")){

	        ItemMeta clicked = event.getCurrentItem().getItemMeta();
	        ItemStack cursor = event.getCursor();
	        if(clicked == null) return;
	        if(clicked.hasDisplayName()){
	        	if(cursor.getType() != null){
		        	if(event.getRawSlot() <= 53){
			      	      event.setCancelled(true);
			        		Bukkit.broadcastMessage("1");
				        		Bukkit.broadcastMessage("3");
				        	 if(clicked.getDisplayName().equals("§bEfficiency")){
				        		 Bukkit.broadcastMessage("4");
				        		 if(event.getCursor() != null){
					        		 int lvl = cursor.getEnchantmentLevel(Enchantment.DIG_SPEED);
					        		 if(event.isShiftClick()){
					        			 ItemMeta met = cursor.getItemMeta();
					       				 met.removeEnchant(Enchantment.DIG_SPEED);
					        			 cursor.setItemMeta(met);
					        			 event.setCursor(cursor);
					        			 Bukkit.broadcastMessage("7");
					        		 }else{
						        		 if(event.isLeftClick()){
						        			 ItemMeta met = cursor.getItemMeta();
						        			 met.addEnchant(Enchantment.DIG_SPEED, lvl + 1, true);
						        			 cursor.setItemMeta(met);
						        			 event.setCursor(cursor);
						        			 Bukkit.broadcastMessage("5");
						        		 }else if(event.isRightClick()){
						        			 ItemMeta met = cursor.getItemMeta();
						        			 if(lvl == 1){
						        				 met.removeEnchant(Enchantment.DIG_SPEED);
						        			 }else{
							        			 met.addEnchant(Enchantment.DIG_SPEED, lvl - 1, false); 
						        			 }
						        			 cursor.setItemMeta(met);
						        			 event.setCursor(cursor);
						        			 Bukkit.broadcastMessage("6");
						        		 }
					        		 }
				        	 	}
				        	}
			        	}
	        	}

	        }
	      }
	    }
	  }
}
