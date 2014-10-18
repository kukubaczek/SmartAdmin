package com.gmail.kukubaczek.SmartAdmin.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import com.gmail.kukubaczek.SmartAdmin.PlayerMenuCreator;

public class OnRightClickPlayer implements Listener{
  @EventHandler
  public void onPlayerInteract(PlayerInteractEntityEvent event) {
    Player player = event.getPlayer();
    if(event.getRightClicked() instanceof Player){
      if(player.getItemInHand().getType() == Material.STICK && player.hasPermission("SmartAdmin.*")){	
        if(player.getItemInHand().hasItemMeta()){
          if(player.getItemInHand().getItemMeta().getDisplayName().equals("GraczoBadyl")){
            Player rclicked = (Player) event.getRightClicked();
            PlayerMenuCreator.openInv(player, rclicked.getName());
          }
        }
      }
    }
  }
}