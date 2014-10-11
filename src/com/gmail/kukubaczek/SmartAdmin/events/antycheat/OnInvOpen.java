package com.gmail.kukubaczek.SmartAdmin.events.antycheat;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;

import com.gmail.kukubaczek.SmartAdmin.Main;

public class OnInvOpen implements Listener {

	@EventHandler
    public void onInventoryClick(InventoryOpenEvent event) {
		final Player p = (Player) event.getPlayer();
		if(p.isSneaking()){
			final String type = event.getInventory().getType().toString();
			Bukkit.getScheduler().runTaskLater(Main.getPlugin(), new Runnable(){
				public void run() {
					if(p.isSneaking()){
						Bukkit.broadcast(Main.getTag("AC") + " §fGracz §a" + p.getName() + " §fotworzył §a" + type + "§f, gdy §asię skradał§f!", "SmartAdmin.AntyCheat");
					}
				} 				       
			}, 10L);
		}
	}
	
}
