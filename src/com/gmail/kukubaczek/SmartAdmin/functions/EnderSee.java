package com.gmail.kukubaczek.SmartAdmin.functions;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.gmail.kukubaczek.SmartAdmin.Main;

public class EnderSee {

	  @SuppressWarnings("deprecation")
    public static void enderSee(Player admin, String enderplayer){
	    	Player gracz = Bukkit.getPlayerExact(enderplayer);
	    	if(gracz != null){
	    		
		    	admin.sendMessage(Main.getTag("tag") + " §fOtworzyłeś enderchest gracza §a" + enderplayer + "§f!");
	
		    	admin.openInventory(gracz.getEnderChest());
		    	
	    	}else{
	    		admin.sendMessage(Main.getTag("error") + " §fWybrany gracz jest offline!");
	    	}
		  } 
	
}
