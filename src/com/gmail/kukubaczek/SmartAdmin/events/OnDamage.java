package com.gmail.kukubaczek.SmartAdmin.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.entity.Player;

import com.gmail.kukubaczek.SmartAdmin.Main;

public class OnDamage implements Listener{

  @EventHandler
  public void onDamage(EntityDamageEvent event) {
    if(event.getEntity() instanceof Player) {
      Player p = (Player) event.getEntity();
      if(Main.godmode.contains(p.getName())){
        event.setCancelled(true);
      }
    }
  }
}
