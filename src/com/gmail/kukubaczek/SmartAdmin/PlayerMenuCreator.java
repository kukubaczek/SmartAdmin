package com.gmail.kukubaczek.SmartAdmin;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class PlayerMenuCreator {
	
	 public static void reloadInv(Player player) {
		 
	 }
	 
	 public static void openInv(Player admin, Player player){
		 if(!(admin.hasPermission("SmartAdmin.*"))){
			 admin.sendMessage(Main.getTag("error") + " §fNie posiadasz wystarczających uprawnień!");
		 }else{
			 
		 }
	 }
}
