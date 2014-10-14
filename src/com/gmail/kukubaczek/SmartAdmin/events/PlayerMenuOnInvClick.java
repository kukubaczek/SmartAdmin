package com.gmail.kukubaczek.SmartAdmin.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.meta.ItemMeta;

import com.gmail.kukubaczek.SmartAdmin.Main;
import com.gmail.kukubaczek.SmartAdmin.PlayerMenuCreator;
import com.gmail.kukubaczek.SmartAdmin.PlayersListCreator;

public class PlayerMenuOnInvClick implements Listener{

	  @EventHandler
	  public void onInventoryClick(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		Inventory inventory = event.getInventory();
		if((inventory.getName().startsWith("§aS§fmart§bAdmin: §e")) && (event.getCurrentItem() != null)){
			String name = inventory.getName().replace("§aS§fmart§bAdmin: §e", "");
			Bukkit.broadcastMessage("Gracz: " + name);
			Bukkit.broadcastMessage("Item: " + event.getCurrentItem().toString());
		}
	  }
}