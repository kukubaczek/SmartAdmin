package com.gmail.kukubaczek.SmartAdmin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gmail.kukubaczek.SmartAdmin.Main;
import com.gmail.kukubaczek.SmartAdmin.functions.ClearInv;

public class CmdClearInv implements CommandExecutor {
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if(!(sender instanceof Player)){
      sender.sendMessage(Main.getTag("error") + " §fTylko gracz może wykonać tą komendę!");
    }
    if(args.length == 0){
      if(sender.hasPermission("SmartAdmin.ClearInv.self")){
        Bukkit.broadcast(Main.getTag("tag") + " §a" + sender.getName() + " §fwyczyścił ekwipunek gracza§a " + sender.getName() + "§f!", "SmartAdmin.*");
        ClearInv.clearInv((Player) sender, sender.getName());
      }else{
        sender.sendMessage(Main.getTag("error") + " §fNie masz wystarczających uprawnień!");
      }
    }else{
      if(sender.hasPermission("SmartAdmin.ClearInv.other")){
        Bukkit.broadcast(Main.getTag("tag") + " §a" + sender.getName() + " §fwyczyścił ekwipunek gracza§a " + args[0] + "§f!", "SmartAdmin.*");
        ClearInv.clearInv((Player) sender, args[0]);
      }else{
        sender.sendMessage(Main.getTag("error") + " §fNie masz wystarczających uprawnień!");
      }
    }
    return false;
  }
}