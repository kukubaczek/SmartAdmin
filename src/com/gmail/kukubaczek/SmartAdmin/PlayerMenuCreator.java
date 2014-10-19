package com.gmail.kukubaczek.SmartAdmin;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerMenuCreator {

  @SuppressWarnings("deprecation")
  public static void openInv(Player admin, String player) {
    Inventory menu = Bukkit.createInventory(null, 54, "§aS§fmart§bAdmin: §e" + player);

    Player gracz = Bukkit.getPlayerExact(player);

    //kick
    ItemStack stack = new ItemStack (Material.TRIPWIRE_HOOK, 1);
    ItemMeta meta = stack.getItemMeta();
    meta.setDisplayName("§cWyrzuć z serwera");
    stack.setItemMeta(meta);
    menu.setItem(16, stack);

    stack = new ItemStack (Material.FEATHER, 1);
    if(gracz.getAllowFlight() == true){
      meta.setDisplayName("§aFly");
      meta.addEnchant(Enchantment.WATER_WORKER, 1, true);
    }else{
      meta.setDisplayName("§cFly");
    }
    stack.setItemMeta(meta);
    menu.setItem(19, stack);

    //heal
    stack = new ItemStack (Material.APPLE, 1);
    meta = stack.getItemMeta();
    meta.setDisplayName("§aUlecz");
    meta.setLore(Arrays.asList("§7Aktualnie: §a" + gracz.getHealth() + "§f/§c" + gracz.getMaxHealth()));
    stack.setItemMeta(meta);
    menu.setItem(10, stack);

    //enderchest
    stack = new ItemStack (Material.ENDER_CHEST, 1);
    meta = stack.getItemMeta();
    meta.setDisplayName("§bEnderChest");
    meta.setLore(Arrays.asList("§7Edytuj enderchest gracza."));
    stack.setItemMeta(meta);
    menu.setItem(14, stack);

    //eq
    stack = new ItemStack (Material.CHEST, 1);
    meta = stack.getItemMeta();
    meta.setDisplayName("§6Ekwipunek");
    meta.setLore(Arrays.asList("§7Edytuj ekwipunek gracza."));
    stack.setItemMeta(meta);
    menu.setItem(23, stack);

    //cleareq
    stack = new ItemStack (Material.SUGAR, 1);
    meta = stack.getItemMeta();
    meta.setDisplayName("§eWyczyść ekwipunek");
    meta.setLore(Arrays.asList("§7Wyczyść ekwipunek gracza."));
    stack.setItemMeta(meta);
    menu.setItem(28, stack);

    //kill
    stack = new ItemStack (Material.ANVIL, 1);
    meta = stack.getItemMeta();
    meta.setDisplayName("§cZabij gracza");
    meta.setLore(Arrays.asList("§7Ukatrup gracza."));
    stack.setItemMeta(meta);
    menu.setItem(37, stack);

    //tp
    stack = new ItemStack (Material.COOKIE, 1);
    meta = stack.getItemMeta();
    meta.setDisplayName("§aPrzeteleportuj się");
    meta.setLore(Arrays.asList("§7Przeteleportuj się", "§7do gracza §a" + gracz.getName()));
    stack.setItemMeta(meta);
    menu.setItem(32, stack);

    //tp 2
    stack = new ItemStack (Material.CAKE, 1);
    meta = stack.getItemMeta();
    meta.setDisplayName("§aPrzeteleportuj go");
    meta.setLore(Arrays.asList("§7Przeteleportuj gracza", "§a" + gracz.getName() + " §7do siebie!"));
    stack.setItemMeta(meta);
    menu.setItem(41, stack);


    //gamemody
    stack = new ItemStack (Material.GOLD_PICKAXE, 1);
    meta = stack.getItemMeta();
    meta.setDisplayName("§eZmień tryb gry na Survival");
    meta.setLore(Arrays.asList("§7Zmień tryb gracza na przetrwanie."));
    if(gracz.getGameMode() == GameMode.SURVIVAL){
      meta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
    }
    stack.setItemMeta(meta);
    menu.setItem(25, stack);

    stack = new ItemStack (Material.GOLD_SPADE, 1);
    meta = stack.getItemMeta();
    meta.setDisplayName("§eZmień tryb gry na Creative");
    meta.setLore(Arrays.asList("§7Zmień tryb gracza na kreatywny."));
    if(gracz.getGameMode() == GameMode.CREATIVE){
      meta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
    }
    stack.setItemMeta(meta);
    menu.setItem(34, stack);

    stack = new ItemStack (Material.GOLD_SWORD, 1);
    meta = stack.getItemMeta();
    meta.setDisplayName("§eZmień tryb gry na Adventure");
    meta.setLore(Arrays.asList("§7Zmień tryb gracza na przygodowy."));
    if(gracz.getGameMode() == GameMode.ADVENTURE){
      meta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
    }
    stack.setItemMeta(meta);
    menu.setItem(43, stack);

    stack = new ItemStack (Material.GOLDEN_APPLE, 1);
    meta = stack.getItemMeta();
    if(!Main.godmode.contains(gracz.getName())){
      meta.setDisplayName("§eWłącz godmode");
      meta.setLore(Arrays.asList("§7Gracz stanie się nieśmiertelny."));
    } else {
      meta.setDisplayName("§eWyłącz godmode");
      meta.setLore(Arrays.asList("§7Gracz przestanie być nieśmiertelny."));
      stack.setDurability((short) 1);
    }
    stack.setItemMeta(meta);
    menu.setItem(12, stack);

    admin.openInventory(menu);
  }
}