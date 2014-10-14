package com.gmail.kukubaczek.SmartAdmin;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class PlayersListCreator {

  static Inventory menu = Bukkit.createInventory(null, 54, "§aS§fmart§bAdmin: §3Gracze");

  public static void reloadInv(Integer strona) {
    menu.clear();

    Integer strnext;
    Integer strback;
    if(strona == 1) strback = 1; else strback = strona - 1;
    Integer strnum = 48*(strona-1);
    Integer strmax;
    ItemStack stack;
    SkullMeta skullMeta;
    ItemMeta meta;
    Integer i = 0;
    Player[] lel = Bukkit.getServer().getOnlinePlayers();

    strmax = (lel.length/48)+1;
    if(strona == 9) strnext = 9; else if(strona == strmax) strnext = strmax; else strnext = strona + 1;

    for (Player p : lel) {
      i++;
      if(i > strnum){
        if((i - strnum) == 37) i++;
        if((i - strnum) == 45) i+=3;
        if((i - strnum) == 53) break;
        stack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        skullMeta = (SkullMeta)stack.getItemMeta();
        skullMeta.setDisplayName("§a"+p.getName());
        skullMeta.setOwner(p.getName());
        skullMeta.setLore(Arrays.asList("Zarządzaj graczem o powyższym nicku"));
        stack.setItemMeta(skullMeta);
        menu.setItem((i - strnum) - 1, stack);
      }
    }

    //strony
    stack = new ItemStack(Material.ARROW, 1);
    meta = stack.getItemMeta();
    meta.setDisplayName("§bStrona §a" + strback);
    meta.setLore(Arrays.asList("§3Jesteś teraz na stronie §a" + strona,"§bKlikając przejdziesz na stronę §a" + strback));
    stack.setItemMeta(meta);
    menu.setItem(45, stack);

    meta.setDisplayName("§bStrona §a" + strnext);
    meta.setLore(Arrays.asList("§3Jesteś teraz na stronie §a" + strona,"§bKlikając przejdziesz na stronę §a" + strnext));
    stack.setItemMeta(meta);
    menu.setItem(53, stack);
  }

  public static void openInv(Player player, Integer strona){
    reloadInv(strona);
    player.openInventory(menu);
  }
}
