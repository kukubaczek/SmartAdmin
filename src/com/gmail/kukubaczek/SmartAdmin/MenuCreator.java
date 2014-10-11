package com.gmail.kukubaczek.SmartAdmin;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MenuCreator {
	
	static Inventory menu1 = Bukkit.createInventory(null, 54, "§aS§fmart§bA§fdmin");

	public static void reloadInv() {
		menu1.clear();
		
        if(Main.getVar("chat") == true){
        	ItemStack stack = new ItemStack(Material.INK_SACK, 1, (short) 10);
            ItemMeta Meta = stack.getItemMeta();
            Meta.setDisplayName("§cWyłącz chat");
        	Meta.setLore(Arrays.asList("§7Wyłącza chat.", "§7Aktualnie: §aWłączony!"));
            stack.setItemMeta(Meta);
            menu1.setItem(10, stack);
        }else{
        	ItemStack stack = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta Meta = stack.getItemMeta();
            Meta.setDisplayName("§aWłącz chat"); 
        	Meta.setLore(Arrays.asList("§7Włącza chat.", "§7Aktualnie: §cWyłączony!"));
            stack.setItemMeta(Meta);
            menu1.setItem(10, stack);
        }
    	ItemStack stack = new ItemStack(Material.INK_SACK, 1, (short) 3);
        ItemMeta Meta = stack.getItemMeta();
        Meta.setDisplayName("§bWyczyść chat"); 
    	Meta.setLore(Arrays.asList("§7Czyści chat."));
        stack.setItemMeta(Meta);
        menu1.setItem(19, stack);
        
    	stack = new ItemStack(Material.DOUBLE_PLANT, 1);
        Meta.setDisplayName("§eUstaw dzień"); 
    	Meta.setLore(Arrays.asList("§7Ustawia czas na 1000 ticków."));
        stack.setItemMeta(Meta);
        menu1.setItem(14, stack);
    	stack = new ItemStack(Material.ENDER_PEARL, 1);
        Meta.setDisplayName("§7Ustaw noc"); 
    	Meta.setLore(Arrays.asList("§7Ustawia czas na 14000 ticków."));
        stack.setItemMeta(Meta);
        menu1.setItem(23, stack);
	}
	
	public static void openInv(Player player){
		reloadInv();
        player.openInventory(menu1);
	}
	
}
