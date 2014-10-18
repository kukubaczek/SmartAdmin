package com.gmail.kukubaczek.SmartAdmin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gmail.kukubaczek.SmartAdmin.Main;
import com.gmail.kukubaczek.SmartAdmin.functions.InvSee;

public class CmdInvSee implements CommandExecutor {
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if(!sender.hasPermission("SmartAdmin.InvSee")){
      sender.sendMessage("Nie masz permisji! c:");
      return true;
    }

    if(!(sender instanceof Player)){
      sender.sendMessage(Main.getTag("error") + " §fTylko gracz może wykonać tą komendę!");
    }
    if(args.length == 0){
      sender.sendMessage(Main.getTag("error") + " §fPodaj gracza, którego ekwipunek chcesz zobaczyć! §a/§fInvSee §a<§fgracz§a>§f!");
    }else{
      Bukkit.broadcast(Main.getTag("tag") + " §a" + sender.getName() + " §fotworzył ekwipunek gracza§a " + args[0] + "§f!", "SmartAdmin.*");
      InvSee.invSee((Player) sender, args[0]);
    }
    return false;
  }
}
