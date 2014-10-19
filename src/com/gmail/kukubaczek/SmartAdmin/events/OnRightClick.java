package com.gmail.kukubaczek.SmartAdmin.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.gmail.kukubaczek.SmartAdmin.MainMenuCreator;

public class OnRightClick implements Listener{
  @EventHandler
  public void onPlayerInteract(PlayerInteractEvent event) {
    Player player = (Player) event.getPlayer();
    if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK){
      if(event.getItem() != null && player.hasPermission("smartadmin.open")){
        if(event.getItem().hasItemMeta() && event.getItem().getItemMeta().hasDisplayName() && event.getItem().getItemMeta().getDisplayName().equals("§bSmartAdmin")){
          MainMenuCreator.openInv(player);
        }
      } else player.getInventory().remove(event.getItem());
    }
  }
}