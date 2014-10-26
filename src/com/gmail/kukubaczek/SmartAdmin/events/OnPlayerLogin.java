package com.gmail.kukubaczek.SmartAdmin.events;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

import com.gmail.kukubaczek.SmartAdmin.Main;

public class OnPlayerLogin implements Listener {
  @EventHandler
  public void onPlayerLogin(PlayerLoginEvent event) {
    if(event.getResult().equals(Result.KICK_FULL)) {
        if(Main.max_players > Bukkit.getOnlinePlayers().length){
          event.allow();
        } else {
          event.disallow(Result.KICK_FULL, "");
        }
    } else {
        if(!(Main.max_players > Bukkit.getOnlinePlayers().length))
          event.disallow(Result.KICK_FULL, "");
    }
    if(event.getResult().equals(Result.KICK_FULL)) event.disallow(Result.KICK_FULL, Main.full_server_msg);
  }
}
