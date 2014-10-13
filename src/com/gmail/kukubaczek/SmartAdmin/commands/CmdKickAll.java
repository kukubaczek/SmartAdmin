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
			
			String reason = "";
			for(int i = 0; i < args.length; i++){
        reason += args[i] + " ";
      }
			
			KickAll.kickall(sender.getName(), reason);
			
			/*if(args.length == 0){
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
			}*/
			return true;
	}
}

