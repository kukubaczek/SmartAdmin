package com.gmail.kukubaczek.SmartAdmin.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import com.gmail.kukubaczek.SmartAdmin.Main;

public class OnPing implements Listener{

  @EventHandler
  public void onPing(ServerListPingEvent event) {
    event.setMotd(ChatColor.translateAlternateColorCodes('&', Bukkit.getMotd()));
    //z configa
    try {
      Integer max_players = Integer.parseInt(Main.max_players);
      event.setMaxPlayers(max_players);
    } catch (NumberFormatException e) {
      //nieskonczonosc!
      if(Main.max_players.equalsIgnoreCase("false")){
        event.setMaxPlayers(event.getNumPlayers() + 1);
      }
      //w innym przypadku oryginalna ilosc z bukkita ;3
    }
  }
}
