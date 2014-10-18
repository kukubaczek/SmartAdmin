package com.gmail.kukubaczek.SmartAdmin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.gmail.kukubaczek.SmartAdmin.Main;

public class CmdHelpOp implements CommandExecutor {
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if(!sender.hasPermission("SmartAdmin.helpop")){
      sender.sendMessage("Nie masz permisji! c:");
      return true;
    }

    if(args.length == 0){
      sender.sendMessage(Main.getTag("error") + " §fWpisz wiadomość! §a/§fhelpop §a<§fwiadomosc§a>§f!");
    }else{

      String msg = "";
      for(int i = 0; i < args.length; i++){
        msg += args[i] + " ";
      }

      Bukkit.broadcast("§4[§cHelpOp§4] §7" + sender.getName() + "§b » §f" + msg, "SmartAdmin.*");
      sender.sendMessage("§4[§cHelpOp§4] §f" + msg);

      return true;
    }
    return false;
  }
}
