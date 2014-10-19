package com.gmail.kukubaczek.SmartAdmin.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.GameMode;

import com.gmail.kukubaczek.SmartAdmin.Main;
import com.gmail.kukubaczek.SmartAdmin.PlayerMenuCreator;
import com.gmail.kukubaczek.SmartAdmin.functions.ClearInv;
import com.gmail.kukubaczek.SmartAdmin.functions.EnderSee;
import com.gmail.kukubaczek.SmartAdmin.functions.InvSee;

public class PlayerMenuOnInvClick implements Listener{

  @SuppressWarnings("deprecation")
  @EventHandler
  public void onInventoryClick(InventoryClickEvent event) {
    Player admin = (Player) event.getWhoClicked();
    Inventory inventory = event.getInventory();
    ItemStack item = event.getCurrentItem();
    if((inventory.getName().startsWith("§aS§fmart§bAdmin: §e")) && (item != null)){
      if(item.getItemMeta() != null){
        event.setCancelled(true);
        String name = inventory.getName().substring(20);
        Player gracz = Bukkit.getPlayerExact(name);
        String itemname = item.getItemMeta().getDisplayName();
        if(itemname.equals("§cWyrzuć z serwera")){
          gracz.kickPlayer("§aZostałeś wyrzucony z serwera!" + "\n§ePrzez: §f" + admin.getName());
          Bukkit.broadcastMessage(Main.getTag("tag") + " §fGracz §a" + name + "§f został wyrzucony z serwera przez §a" + admin.getName() + "§f!");
          admin.closeInventory();
        } else if(itemname.equals("§aUlecz")){
          gracz.setHealth(20);
          gracz.setFoodLevel(20);
          Bukkit.broadcastMessage(Main.getTag("tag") + " §fGracz §a" + name + "§f został uleczony przez §a" + admin.getName() + "§f!");
        } else if(itemname.equals("§aFly")){
          gracz.setAllowFlight(false);
          Bukkit.broadcast(Main.getTag("tag") + " §a" + admin.getName() + " §fwyłączył latanie dla gracza§a " + name + "§f!", "SmartAdmin.*");
          PlayerMenuCreator.openInv(admin, gracz.getName());
        } else if(itemname.equals("§cFly")){
          gracz.setAllowFlight(true);
          Bukkit.broadcast(Main.getTag("tag") + " §a" + admin.getName() + " §fwłączył latanie dla gracza§a " + name + "§f!", "SmartAdmin.*");
          PlayerMenuCreator.openInv(admin, gracz.getName());
        } else if(itemname.equals("§bEnderChest")){
          Bukkit.broadcast(Main.getTag("tag") + " §a" + admin.getName() + " §fotworzył enderchest gracza§a " + name + "§f!", "SmartAdmin.*");
          EnderSee.enderSee(admin, gracz.getName());
        } else if(itemname.equals("§6Ekwipunek")){
          Bukkit.broadcast(Main.getTag("tag") + " §a" + admin.getName() + " §fotworzył ekwipunek gracza§a " + name + "§f!", "SmartAdmin.*");
          InvSee.invSee(admin, gracz.getName());
        } else if(itemname.equals("§eWyczyść ekwipunek")){
          Bukkit.broadcast(Main.getTag("tag") + " §a" + admin.getName() + " §fwyczyścił ekwipunek gracza§a " + name + "§f!", "SmartAdmin.*");
          ClearInv.clearInv(admin, gracz.getName());
        } else if(itemname.equals("§eZmień tryb gry na Survival")){
          gracz.setGameMode(GameMode.SURVIVAL);
          Bukkit.broadcast(Main.getTag("tag") + " §a" + admin.getName() + " §fwłączył §aSURVIVAL§f dla gracza§a " + name + "§f!", "SmartAdmin.*");
          PlayerMenuCreator.openInv(admin, gracz.getName());
        } else if(itemname.equals("§eZmień tryb gry na Creative")){
          Bukkit.broadcast(Main.getTag("tag") + " §a" + admin.getName() + " §fwłączył §aCREATIVE§f dla gracza§a " + name + "§f!", "SmartAdmin.*");
          gracz.setGameMode(GameMode.CREATIVE);
          PlayerMenuCreator.openInv(admin, gracz.getName());
        } else if(itemname.equals("§eZmień tryb gry na Adventure")){
          Bukkit.broadcast(Main.getTag("tag") + " §a" + admin.getName() + " §fwłączył §aADVENTURE§f dla gracza§a " + name + "§f!", "SmartAdmin.*");
          gracz.setGameMode(GameMode.ADVENTURE);
          PlayerMenuCreator.openInv(admin, gracz.getName());
        } else if(itemname.equals("§cZabij gracza")){
          Bukkit.broadcast(Main.getTag("tag") + " §a" + admin.getName() + " §fzabił gracza§a " + name + "§f!", "SmartAdmin.*");
          gracz.setHealth(0);
        } else if(itemname.equals("§aPrzeteleportuj się")){
          Bukkit.broadcast(Main.getTag("tag") + " §a" + admin.getName() + " §fprzeteleportował się do gracza§a " + name + "§f!", "SmartAdmin.*");
          admin.teleport(gracz.getLocation());
        } else if(itemname.equals("§aPrzeteleportuj go")){
          Bukkit.broadcast(Main.getTag("tag") + " §a" + admin.getName() + " §fprzeteleportował §a" + name + " §fdo siebie!", "SmartAdmin.*");
          gracz.teleport(admin.getLocation());
        } else if(itemname.equals("§eWłącz godmode")){
          Main.godmode.add(gracz.getName());
          PlayerMenuCreator.openInv(admin, gracz.getName());
        } else if(itemname.equals("§eWyłącz godmode")){
          Main.godmode.remove(gracz.getName());
          PlayerMenuCreator.openInv(admin, gracz.getName());
        }
      }
    }
  }
}