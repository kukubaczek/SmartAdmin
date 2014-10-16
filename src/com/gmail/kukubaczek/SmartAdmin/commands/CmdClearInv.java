package com.gmail.kukubaczek.SmartAdmin.commands;

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
		    Player pl = (Player) sender;
		    if(args.length == 0){
		    	if(pl.hasPermission("SmartAdmin.ClearInv.self")){
		    		ClearInv.clearInv(pl, pl.getName());
		    	}else{
		    		sender.sendMessage(Main.getTag("error") + " §fNie masz wystarczających uprawnień!");
		    	}
		    }else{
		    	if(pl.hasPermission("SmartAdmin.ClearInv.other")){
		    		ClearInv.clearInv(pl, args[0]);
		    	}else{
		    		sender.sendMessage(Main.getTag("error") + " §fNie masz wystarczających uprawnień!");
		    	}
		    }
			return false;
	  }
	}