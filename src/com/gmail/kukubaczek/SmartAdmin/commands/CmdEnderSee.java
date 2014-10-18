package com.gmail.kukubaczek.SmartAdmin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gmail.kukubaczek.SmartAdmin.Main;
import com.gmail.kukubaczek.SmartAdmin.functions.EnderSee;

public class CmdEnderSee implements CommandExecutor {
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if(!sender.hasPermission("SmartAdmin.EnderSee")){
      sender.sendMessage("Nie masz permisji! c:");
      return true;
    }

    if(!(sender instanceof Player)){
      sender.sendMessage(Main.getTag("error") + " §fTylko gracz może wykonać tą komendę!");
    }
    if(args.length == 0){
      sender.sendMessage(Main.getTag("error") + " §fPodaj gracza, którego enderchest chcesz zobaczyć! §a/§fEnderSee §a<§fgracz§a>§f!");
    }else{
      Bukkit.broadcast(Main.getTag("tag") + " §a" + sender.getName() + " §fotworzył enderchest gracza§a " + args[0] + "§f!", "SmartAdmin.*");
      EnderSee.enderSee((Player) sender, args[0]);
    }
    return false;
  }
}
