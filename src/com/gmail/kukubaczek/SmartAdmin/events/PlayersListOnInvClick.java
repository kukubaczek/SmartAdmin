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


public class PlayersListOnInvClick implements Listener{

  @EventHandler
  public void onInventoryClick(InventoryClickEvent event) {
    Player player = (Player) event.getWhoClicked();
    Inventory inventory = event.getInventory();
    if((inventory.getName() == "§aS§fmart§bAdmin: §3Gracze") && (event.getCurrentItem() != null)){
      event.setCancelled(true);
      if(player.hasPermission("SmartAdmin.*")){

        ItemMeta clicked = event.getCurrentItem().getItemMeta();
        if(clicked == null) return;
        if(clicked.hasDisplayName()){
          String name = clicked.getDisplayName();
          if(name.startsWith("§bStrona §a")){
            player.closeInventory();
            PlayersListCreator.openInv(player, Integer.parseInt(name.substring(11)));
          } else {
            player.sendMessage("Wybrales gracza o nicku " + name.substring(2)); //debug
            PlayerMenuCreator.reloadInv(player, name.substring(2));
          }
        }
      } else {
        player.sendMessage(Main.getTag("error") + " §fNie posiadasz wystarczających uprawnień!");
        player.closeInventory();
      }
    }
  }
}
