package com.gmail.kukubaczek.SmartAdmin.commands;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.gmail.kukubaczek.SmartAdmin.Main;
import com.gmail.kukubaczek.SmartAdmin.MainMenuCreator;

public class CmdSmartAdmin implements CommandExecutor {
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("smartadmin")){
			if(sender instanceof Player){
				if(args.length == 0){
					sender.sendMessage(Main.getTag("tag") + " §fWersja pluginu: §a" + Main.getPlugin().getDescription().getVersion() + "§f! Autorzy: §aKukubaczek§f i §aJuniorJPDJ!");
					if(sender.hasPermission("SmartAdmin.*")){
						sender.sendMessage(Main.getTag("error") + " §fUzycie: /§aSmartAdmin §f(§aopen§f|§aget§f|§areload§f)");
					}
					return true;
				}else{
					if(sender.hasPermission("SmartAdmin.*") || sender.hasPermission("SmartAdmin.Commands")){
						if(args[0].equalsIgnoreCase("open")){
							sender.sendMessage(Main.getTag("tag") + " §fMenu zostalo otworzone!");
							MainMenuCreator.openInv((Player) sender);
						}else if(args[0].equalsIgnoreCase("reload")){
							sender.sendMessage(Main.getTag("tag") + " §fReloaduje config...");
							Main.reloadCfg();
							sender.sendMessage(Main.getTag("tag") + " §fZreloadowalem config!");
						}else if(args[0].equalsIgnoreCase("get")){
							sender.sendMessage(Main.getTag("tag") + " §fDodaje do ekwipunku §aSmartAdmin§f!");
					    	ItemStack stack = new ItemStack(Material.DIAMOND, 1);
					        ItemMeta Meta = stack.getItemMeta();
					        Meta.setDisplayName("§bSmartAdmin"); 
					    	Meta.setLore(Arrays.asList("§7Kliknij PPM,", "§7aby otworzyć", "§7menu SmartAdmin"));
					        stack.setItemMeta(Meta);
					        ((Player) sender).getInventory().addItem(stack);
						}else{
							sender.sendMessage(Main.getTag("error") + " §fUzycie: /§aSmartAdmin §f(§aopen§f|§aget§f|§areload§f)");
						}
					}else{
						sender.sendMessage(Main.getTag("error") + " §fNie posiadasz wystarczających uprawnień, aby korzystać z pluginu §aSmartAdmin §fby §aKukubaczek§f!");
					}
					return true;
				}
			}else{
				sender.sendMessage(Main.getTag("tag") + " §fWersja pluginu: §a" + Main.getPlugin().getDescription().getVersion() + "§f! Autor: §aKukubaczek§f!");
			}
		}
		return false;
	}


}
