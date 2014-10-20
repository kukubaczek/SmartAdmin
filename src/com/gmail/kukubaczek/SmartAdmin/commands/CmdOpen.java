package com.gmail.kukubaczek.SmartAdmin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gmail.kukubaczek.SmartAdmin.Main;

public class CmdOpen implements CommandExecutor {
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if(sender instanceof Player){
      Player p = (Player) sender;
      if(cmd.getName().equalsIgnoreCase("workbench")){
        Bukkit.broadcast(Main.getTag("tag") + " §a" + p.getName() + " §fotworzył sobie crafting table!", "SmartAdmin.*");
        p.openWorkbench(null, true);
      } else if(cmd.getName().equalsIgnoreCase("enchanttable")){
        Bukkit.broadcast(Main.getTag("tag") + " §a" + p.getName() + " §fotworzył sobie enchanting table!", "SmartAdmin.*");
        p.openEnchanting(null, true);
      }
    } return true;
  }
}