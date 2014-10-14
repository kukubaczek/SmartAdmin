package com.gmail.kukubaczek.SmartAdmin.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.gmail.kukubaczek.SmartAdmin.Main;

public class OnChat implements Listener {

  @EventHandler
  public void PlayerChat(AsyncPlayerChatEvent e) {
    Player p = e.getPlayer();
    if(Main.getVar("chat") == false){
      if(!(p.hasPermission("SmartAdmin.Chat") || p.hasPermission("SmartAdmin.*"))){
        p.sendMessage(Main.getTag("error") + " §fChat jest aktualnie wyłączony!");
        e.setCancelled(true);
      }
    }
    if(e.getPlayer().isSneaking()){
      Bukkit.broadcast(Main.getTag("AC") + " §fGracz §a" + p.getName() + " §fnapisał wiadomość na §achacie§f, gdy §asię skradał§f!", "SmartAdmin.AntyCheat");
    }
  }
}
