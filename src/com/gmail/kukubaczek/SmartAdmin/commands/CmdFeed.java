package com.gmail.kukubaczek.SmartAdmin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gmail.kukubaczek.SmartAdmin.Main;


public class CmdFeed implements CommandExecutor {
		  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		    if(!sender.hasPermission("SmartAdmin.Feed")){
		      sender.sendMessage("Nie masz permisji! c:");
		      return true;
		    }

		    if(!(sender instanceof Player)){
		      sender.sendMessage(Main.getTag("error") + " §fTylko gracz może wykonać tą komendę!");
		    }
		    Player player = (Player) sender;
		    if(args.length == 0){
		    	Bukkit.broadcast(Main.getTag("tag") + " §a" + sender.getName() + " §fnakarmił siebie§a§f!", "SmartAdmin.*");
		    	player.setFoodLevel(20);
		    	player.setSaturation(10);
		    }else{
		    	Player gracz = Bukkit.getPlayerExact(args[0]);
		      Bukkit.broadcast(Main.getTag("tag") + " §a" + sender.getName() + " §fnakarmił gracza§a " + args[0] + "§f!", "SmartAdmin.*");
		      gracz.setFoodLevel(20);
		      gracz.setSaturation(10);
		    }
		    return false;
		  }
}
