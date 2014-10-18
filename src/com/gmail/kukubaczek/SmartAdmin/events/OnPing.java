package com.gmail.kukubaczek.SmartAdmin.events;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import com.gmail.kukubaczek.SmartAdmin.Main;

public class OnPing implements Listener{
	
	@EventHandler
	  public void onDamage(ServerListPingEvent event) {
		event.setMotd(ChatColor.translateAlternateColorCodes('&', Main.motd));
		if(Main.FakeSlots != 0){
			event.setMaxPlayers(Main.FakeSlots);
		}
	  }
	
}
