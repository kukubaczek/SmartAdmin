package com.gmail.kukubaczek.SmartAdmin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gmail.kukubaczek.SmartAdmin.Main;

public class CmdKickAll implements CommandExecutor {

	@SuppressWarnings("deprecation")
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
			if(!sender.hasPermission("SmartAdmin.kickall")){
				sender.sendMessage("Nie masz permisji! c:");
				return true;
			}
			
			//Tutaj ndal możesz robić krótkie ify ;) Kod jest wtedy czytelnijszy i nie przypomina pijanego węza :D
			
			if(args.length == 0){
				for (Player p : Bukkit.getServer().getOnlinePlayers()) {
		        	if (!p.isOp() && !p.isWhitelisted()) {
						String admin = sender.getName();
						p.kickPlayer("§aWszyscy gracze zostali wyrzuceni!" + "\n§ePrzez: §f" + admin);
						return true;
		        	}
		        }	
				return true;
			}else{
				for (Player p : Bukkit.getServer().getOnlinePlayers()) {
		        	if (!p.isOp() && !p.isWhitelisted()) {
						String admin = sender.getName();
						String reasonMsg = "";
						for(int i = 0; i < args.length; i++){
							reasonMsg += args[i] + " ";
						}
						p.kickPlayer("§aWszyscy gracze zostali wyrzuceni!" + "\n§ePrzez: §f" + admin + "\n§ePowód:\n§f" + reasonMsg);
						return true;
		        	}
		        }	
			}
			return false;
	}
}

