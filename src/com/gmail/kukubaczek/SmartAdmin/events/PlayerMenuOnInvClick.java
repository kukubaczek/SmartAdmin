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
import com.gmail.kukubaczek.SmartAdmin.PlayerMenuCreator;
import com.gmail.kukubaczek.SmartAdmin.PlayersListCreator;

public class PlayerMenuOnInvClick implements Listener{

	  @EventHandler
	  public void onInventoryClick(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		Inventory inventory = event.getInventory();
		ItemStack item = event.getCurrentItem();
		if((inventory.getName().startsWith("§aS§fmart§bAdmin: §e")) && (item != null)){
			event.setCancelled(true);
			String name = inventory.getName().replace("§aS§fmart§bAdmin: §e", "");
			Bukkit.broadcastMessage("Gracz: " + name);
			Player gracz = Bukkit.getPlayerExact(name);
			String itemname = item.getItemMeta().getDisplayName();
			if(itemname == "Kick"){
				gracz.kickPlayer("§aZostałeś wyrzucony z serwera!" + "\n§ePrzez: §f" + player.getName());
				Bukkit.broadcastMessage(Main.getTag("tag") + " §fGracz §a" + name + "§f został wyrzucony z serwera przez §a" + player.getName() + "§f!");
			}
		}
	  }
}