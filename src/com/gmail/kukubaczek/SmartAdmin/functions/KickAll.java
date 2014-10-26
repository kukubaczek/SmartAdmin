package com.gmail.kukubaczek.SmartAdmin.functions;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class KickAll {

  public static void kickall(String admin){
    kickall(admin, "");
  }

  public static void kickall(String admin, String reason){
    String reasonMsg = reason.equals("") ? "" : "\n§ePowód:\n§f" + reason;
    for (Player p : Bukkit.getServer().getOnlinePlayers()) {
      if (!p.isOp() && !p.getName().equals(admin)) {
        p.kickPlayer("§aWszyscy gracze zostali wyrzuceni!" + "\n§ePrzez: §f" + admin + reasonMsg);
      }
    }
  } 
}
