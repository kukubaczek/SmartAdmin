package com.gmail.kukubaczek.SmartAdmin.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.gmail.kukubaczek.SmartAdmin.Main;
import com.gmail.kukubaczek.SmartAdmin.MenuCreator;

public class OnInvClick implements Listener{
	
   @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
    	Player player = (Player) event.getWhoClicked(); // The player that clicked the item
    	Inventory inventory = event.getInventory(); // The inventory that was clicked in
    	if(inventory.getName().equals("§aS§fmart§bA§fdmin")){
    		event.setCancelled(true);
    		if(player.hasPermission("SmartAdmin.*")){
    			try{
    		    	ItemMeta clicked = event.getCurrentItem().getItemMeta();
	    			if(clicked.hasDisplayName()){
	    				if(clicked.getDisplayName().equals("§cWyłącz chat")){
	    					Main.setVar("chat", false);
	    					Bukkit.broadcastMessage(Main.getTag("tag") + " §cChat został wyłączony!");
	    					Bukkit.broadcast(Main.getTag("tag") + " §a" + player.getName() + " §fwyłączył chat!", "SmartAdmin.*");
	    					MenuCreator.reloadInv();
	    				}else if(clicked.getDisplayName().equals("§aWłącz chat")){
	    					Main.setVar("chat", true);
	    					Bukkit.broadcastMessage(Main.getTag("tag") + " §aChat został włączony!");
	    					Bukkit.broadcast(Main.getTag("tag") + " §a" + player.getName() + " §fwłączył chat!", "SmartAdmin.*");
	    					MenuCreator.reloadInv();
	    				}else if(clicked.getDisplayName().equals("§bWyczyść chat")){
	    					for (int i = 0; i < 100; i++)
		    				{
		    					Bukkit.broadcastMessage(" ");
		    				}
	    					Bukkit.broadcastMessage(Main.getTag("tag") + " §bChat został wyczyszczony!");
	    					Bukkit.broadcast(Main.getTag("tag") + " §a" + player.getName() + " §fwyczyścił chat!", "SmartAdmin.*");
	    				}else if(clicked.getDisplayName().equals("§eUstaw dzień")){
	    					player.getWorld().setTime(1000L);
	    					Bukkit.broadcast(Main.getTag("tag") + " §a" + player.getName() + " §fustawił czas na §adzień§f w świecie §a" + player.getWorld().getName() + "§f!", "SmartAdmin.*");
	    				}else if(clicked.getDisplayName().equals("§7Ustaw noc")){
	    					player.getWorld().setTime(14000L);
	    					Bukkit.broadcast(Main.getTag("tag") + " §a" + player.getName() + " §fustawił czas na §anoc§f w świecie §a" + player.getWorld().getName() + "§f!", "SmartAdmin.*");
	    				}else if(clicked.getDisplayName().equals("§bWyłącz deszcz")){
	    					player.getWorld().setTime(14000L);
	    					Bukkit.broadcast(Main.getTag("tag") + " §fDeszcz został §awyłączony §fprzez §a" + player.getName() + " §fw świecie §a" + player.getWorld().getName() + "§f!", "SmartAdmin.*");
	    				}
	    			}
    			}catch (NullPointerException ex) {}
    		}else{
    			player.sendMessage(Main.getTag("error") + " §fNie posiadasz wystarczających uprawnień!");
    			player.closeInventory();
    		}
    	}
   }
}
