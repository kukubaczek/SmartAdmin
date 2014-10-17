package com.gmail.kukubaczek.SmartAdmin.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;


public class OnRightClickPlayer implements Listener{
	  @EventHandler
	  public void onPlayerInteract(PlayerInteractEntityEvent event) {
	    Player player = (Player) event.getPlayer();
	    Bukkit.broadcastMessage("1 - KLIKNĄŁEŚ!");
	    if(event.getRightClicked() instanceof Player){
	    	Bukkit.broadcastMessage("2 - KLIKNĄŁEŚ GRACZA!");
	    	if(player.getItemInHand().getType() == Material.STICK){
	    		Bukkit.broadcastMessage("3 - TAK KLIKNĄŁEŚ PATYKIEM!");	
	    		if(player.getItemInHand().hasItemMeta()){
	    			Bukkit.broadcastMessage("4 - PATYK MA ITEMMETA!!");
	    			if(player.getItemInHand().getItemMeta().getDisplayName().equals("PATYK")){
	    				Bukkit.broadcastMessage("5 - SIĘ ON NAZYWA PATYK!!");
	    			}
	    		}
	    	}
	    }
	  }
	}
