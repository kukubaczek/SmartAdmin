package com.gmail.kukubaczek.SmartAdmin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import com.gmail.kukubaczek.SmartAdmin.functions.KickAll;

public class CmdKickAll implements CommandExecutor {

  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if(!sender.hasPermission("SmartAdmin.kickall")){
      sender.sendMessage("Nie masz permisji! c:");
      return true;
    }

    StringBuilder reason = new StringBuilder("");
    
    for(int i = 0; i < args.length; i++){
      reason.append(args[i]);
    }

    KickAll.kickall(sender.getName(), reason.toString());

    return true;
  }
}
