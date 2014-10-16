package com.gmail.kukubaczek.SmartAdmin.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.gmail.kukubaczek.SmartAdmin.Main;
import com.gmail.kukubaczek.SmartAdmin.PlayerMenuCreator;
import com.gmail.kukubaczek.SmartAdmin.functions.ClearInv;
import com.gmail.kukubaczek.SmartAdmin.functions.EnderSee;
import com.gmail.kukubaczek.SmartAdmin.functions.InvSee;

public class PlayerMenuOnInvClick implements Listener{

	  @SuppressWarnings("deprecation")
    @EventHandler
	  public void onInventoryClick(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		Inventory inventory = event.getInventory();
		ItemStack item = event.getCurrentItem();
		if((inventory.getName().startsWith("§aS§fmart§bAdmin: §e")) && (item != null)){
			event.setCancelled(true);
			String name = inventory.getName().substring(20);
			Player gracz = Bukkit.getPlayerExact(name);
			String itemname = item.getItemMeta().getDisplayName();
			if(itemname.equals("§cWyrzuć z serwera")){
				gracz.kickPlayer("§aZostałeś wyrzucony z serwera!" + "\n§ePrzez: §f" + player.getName());
				Bukkit.broadcastMessage(Main.getTag("tag") + " §fGracz §a" + name + "§f został wyrzucony z serwera przez §a" + player.getName() + "§f!");
			}else if(itemname.equals("§aUlecz")){
				gracz.setHealth(20);
				gracz.setFoodLevel(20);
				Bukkit.broadcastMessage(Main.getTag("tag") + " §fGracz §a" + name + "§f został uleczony przez §a" + player.getName() + "§f!");
			}else if(itemname.equals("§aFly")){
				gracz.setAllowFlight(false);
				Bukkit.broadcast(Main.getTag("tag") + " §a" + player.getName() + " §fwyłączył latanie dla gracza§a " + name + "§f!", "SmartAdmin.*");
				PlayerMenuCreator.reloadInv(player, gracz.getName());
			}else if(itemname.equals("§cFly")){
				gracz.setAllowFlight(true);
				Bukkit.broadcast(Main.getTag("tag") + " §a" + player.getName() + " §fwłączył latanie dla gracza§a " + name + "§f!", "SmartAdmin.*");
				PlayerMenuCreator.reloadInv(player, gracz.getName());
			}else if(itemname.equals("§bEnderChest")){
				EnderSee.enderSee(player, gracz.getName());
			}else if(itemname.equals("§6Ekwipunek")){
				InvSee.invSee(player, gracz.getName());
			}else if(itemname.equals("§eWyczyść ekwipunek")){
				ClearInv.clearInv(player, gracz.getName());
			}
		}
	  }
}