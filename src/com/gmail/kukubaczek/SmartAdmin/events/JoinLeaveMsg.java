package com.gmail.kukubaczek.SmartAdmin.events;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import com.gmail.kukubaczek.SmartAdmin.Main;

public class JoinLeaveMsg implements Listener{
  @EventHandler
  public void onLeave(PlayerQuitEvent event) {
	if(Main.leave_msg.equalsIgnoreCase("false")){
		event.setQuitMessage(null);
	}else{
		event.setQuitMessage(Main.leave_msg.replace("{player}", event.getPlayer().getName()));
	}
  }
  
  @EventHandler
  public void onJoin(PlayerJoinEvent event) {
	if(Main.join_msg.equalsIgnoreCase("false")){
		event.setJoinMessage(null);
	}else{
		event.setJoinMessage(Main.join_msg.replace("{player}", event.getPlayer().getName()));
	}
  }
}