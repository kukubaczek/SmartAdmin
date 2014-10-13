package com.gmail.kukubaczek.SmartAdmin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gmail.kukubaczek.SmartAdmin.Main;

public class CmdKick implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
			if(!sender.hasPermission("SmartAdmin.kick")){
				sender.sendMessage("Nie masz permisji! c:");
				return true;
			}
			
			//Tutaj ndal możesz robić krótkie ify ;) Kod jest wtedy czytelnijszy i nie przypomina pijanego węza :D
			
			if(args.length == 0){
				sender.sendMessage(Main.getTag("error") + " §fPoprawne użycie§a: §f/§akick §f<§agracz§f> <§apowód§f>");
				return true;
				
			}else if (args.length == 1){
				if(Bukkit.getPlayerExact(args[0]) != null){
					String admin = sender.getName();
					Bukkit.getPlayerExact(args[0]).kickPlayer("§aZostałeś wyrzucony z serwera!" + "\n§ePrzez: §f" + admin);
					return true;
				}else{
					sender.sendMessage(Main.getTag("error") + " §fWybrany gracz jest §coffline§f!");
					return true;
				}
			}else{
				if(Bukkit.getPlayerExact(args[0]) != null){
					String admin = sender.getName();
					String reasonMsg = "";
					for(int i = 1; i < args.length; i++){
						reasonMsg += args[i] + " ";
					}
					Bukkit.getPlayerExact(args[0]).kickPlayer("§aZostałeś wyrzucony z serwera!" + "\n§ePrzez: §f" + admin + "\n§ePowód:\n§f" + reasonMsg);
					return true;
				}else{
					sender.sendMessage(Main.getTag("error") + " §fWybrany gracz jest §coffline§f!");
					return true;
				}
			}
			
		
	}
}

