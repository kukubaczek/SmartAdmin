package com.gmail.kukubaczek.SmartAdmin;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class MainMenuCreator {

  static Inventory menu = Bukkit.createInventory(null, 54, "§aS§fmart§bA§fdmin");

  public static void reloadInv(Player player) {
    menu.clear();

    //czat
    ItemStack stack = new ItemStack(Material.INK_SACK, 1);
    ItemMeta Meta = stack.getItemMeta();
    short dur;
    if(Main.getVar("chat")){
      dur = (short) 10;
      Meta.setDisplayName("§cWyłącz chat");
      Meta.setLore(Arrays.asList("§7Wyłącza chat.", "§7Aktualnie: §aWłączony!"));
    } else {
      dur = (short) 8;
      Meta.setDisplayName("§aWłącz chat"); 
      Meta.setLore(Arrays.asList("§7Włącza chat.", "§7Aktualnie: §cWyłączony!"));
    }
    stack.setItemMeta(Meta);
    stack.setDurability(dur);
    menu.setItem(10, stack);

    stack = new ItemStack(Material.INK_SACK, 1, (short) 3);
    Meta = stack.getItemMeta();
    Meta.setDisplayName("§bWyczyść chat"); 
    Meta.setLore(Arrays.asList("§7Czyści chat."));
    stack.setItemMeta(Meta);
    menu.setItem(19, stack);

    //czas
    stack = new ItemStack(Material.DOUBLE_PLANT, 1);
    Meta = stack.getItemMeta();
    Meta.setDisplayName("§eUstaw dzień"); 
    Meta.setLore(Arrays.asList("§7Ustawia czas na 1000 ticków."));
    stack.setItemMeta(Meta);
    menu.setItem(16, stack);

    stack = new ItemStack(Material.ENDER_PEARL, 1);
    Meta = stack.getItemMeta();
    Meta.setDisplayName("§7Ustaw noc"); 
    Meta.setLore(Arrays.asList("§7Ustawia czas na 14000 ticków."));
    stack.setItemMeta(Meta);
    menu.setItem(25, stack);

    //deszcz
    stack = new ItemStack(Material.BUCKET, 1);
    Meta = stack.getItemMeta();
    Meta.setDisplayName("§bWyłącz deszcz"); 
    Meta.setLore(Arrays.asList("§7Wyłącza deszcz w świecie,", "§7w którym się znajdujesz!"));
    stack.setItemMeta(Meta);
    menu.setItem(34, stack);

    stack = new ItemStack(Material.WATER_BUCKET, 1);
    Meta = stack.getItemMeta();
    Meta.setDisplayName("§4Włącz deszcz"); 
    Meta.setLore(Arrays.asList("§7Włącza deszcz w świecie,", "§7w którym się znajdujesz!"));
    stack.setItemMeta(Meta);
    menu.setItem(43, stack);

    //kickall
    stack = new ItemStack(Material.DISPENSER, 1, (short) 3);
    Meta = stack.getItemMeta();
    Meta.setDisplayName("§bWyrzuć wszystkich graczy"); 
    Meta.setLore(Arrays.asList("§7Wyrzuca z serwera wszystkich graczy,", "§7oprócz ciebie i administratorów"));
    stack.setItemMeta(Meta);
    menu.setItem(28, stack);

    //gracze
    stack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
    SkullMeta skullMeta = (SkullMeta) stack.getItemMeta();
    skullMeta.setDisplayName("§bZarządzaj graczami");
    skullMeta.setOwner("Steve");
    skullMeta.setLore(Arrays.asList("§7Wyświetla menu z graczami do zarządzania nimi.","§7np. kick, gm, fly"));
    stack.setItemMeta(skullMeta);
    menu.setItem(12, stack);

    //ty
    stack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
    skullMeta = (SkullMeta) stack.getItemMeta();
    skullMeta.setDisplayName("§bZarządzaj sobą");
    skullMeta.setOwner(player.getName());
    skullMeta.setLore(Arrays.asList("§7Wyświetla menu zarządzania ", "§7graczem §a" + player.getName()));
    stack.setItemMeta(skullMeta);
    menu.setItem(21, stack);
    
    stack = new ItemStack(Material.ENCHANTED_BOOK, 1, (short) 3);
    Meta = stack.getItemMeta();
    Meta.setDisplayName("§bEnchantuj"); 
    Meta.setLore(Arrays.asList("§7Enchantuj itemki."));
    stack.setItemMeta(Meta);
    menu.setItem(37, stack);
  }

  public static void openInv(Player player){
    reloadInv(player);
    player.openInventory(menu);
  }
}
