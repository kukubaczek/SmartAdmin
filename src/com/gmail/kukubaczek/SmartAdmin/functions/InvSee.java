package com.gmail.kukubaczek.SmartAdmin.functions;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.gmail.kukubaczek.SmartAdmin.Main;

public class InvSee {

	  public static void invSee(Player admin, String enderplayer){
	    	Player gracz = Bukkit.getPlayerExact(enderplayer);
	    	if(gracz != null){
	    		
		    	admin.sendMessage(Main.getTag("tag") + " §fOtworzyłeś ekwipunek gracza §a" + enderplayer + "§f!");
	
		    	admin.openInventory(gracz.getInventory());
		    	
	    	}else{
	    		admin.sendMessage(Main.getTag("error") + " §fWybrany gracz jest offline!");
	    	}
		  } 
	
}
