package com.gmail.kukubaczek.SmartAdmin.functions;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.gmail.kukubaczek.SmartAdmin.Main;

public class ClearInv {

	  @SuppressWarnings("deprecation")
    public static void clearInv(Player admin, String enderplayer){
	    	Player gracz = Bukkit.getPlayerExact(enderplayer);
	    	if(gracz != null){
	    		
		    	admin.sendMessage(Main.getTag("tag") + " §fWyczyściłeś ekwipunek gracza §a" + enderplayer + "§f!");
	
		      gracz.getInventory().clear();
		      gracz.getInventory().setHelmet(null);
		      gracz.getInventory().setChestplate(null);
		      gracz.getInventory().setLeggings(null);
		      gracz.getInventory().setBoots(null);
		      gracz.getInventory().setHeldItemSlot(0);
		    	
	    	}else{
	    		admin.sendMessage(Main.getTag("error") + " §fWybrany gracz jest offline!");
	    	}
		  } 
	
}
