package com.gmail.kukubaczek.SmartAdmin.events;

import org.bukkit.Bukkit;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class EnchantOnClick implements Listener {

  @SuppressWarnings("deprecation")
  @EventHandler
  public void onInventoryClick(InventoryClickEvent event) {
    Player player = (Player) event.getWhoClicked();
    Inventory inventory = event.getInventory();
    if((inventory.getName().equals("§aS§fmart§bA§fdmin: §eEnchant")) && (event.getCurrentItem() != null)){
      if(player.hasPermission("SmartAdmin.*")){

        ItemMeta clicked = event.getCurrentItem().getItemMeta();
        ItemStack cursor = event.getCursor();
        if(clicked == null) return;
        if(clicked.hasDisplayName()){
          if(cursor.getType() != null){
            if(event.getRawSlot() <= 53){
              event.setCancelled(true);
              Bukkit.broadcastMessage("1");
              Bukkit.broadcastMessage("3");
              if(clicked.getDisplayName().equals("§bEfficiency")){
                Bukkit.broadcastMessage("4");
                if(event.getCursor() != null){
                  ItemMeta meta = cursor.getItemMeta();
                  int lvl = cursor.getEnchantmentLevel(Enchantment.DIG_SPEED);
                  if(event.isShiftClick()){
                    meta.removeEnchant(Enchantment.DIG_SPEED);
                    cursor.setItemMeta(meta);
                    event.setCursor(cursor);
                    Bukkit.broadcastMessage("7");
                  }else if(event.isLeftClick()){
                    meta.addEnchant(Enchantment.DIG_SPEED, lvl + 1, true);
                    cursor.setItemMeta(meta);
                    event.setCursor(cursor);
                    Bukkit.broadcastMessage("5");
                  }else if(event.isRightClick()){
                    if(lvl == 1){
                      meta.removeEnchant(Enchantment.DIG_SPEED);
                    }else{
                      meta.addEnchant(Enchantment.DIG_SPEED, lvl - 1, false); 
                    }
                    cursor.setItemMeta(meta);
                    event.setCursor(cursor);
                    Bukkit.broadcastMessage("6");
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}