package com.gmail.kukubaczek.SmartAdmin.events;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.gmail.kukubaczek.SmartAdmin.functions.Enchant;


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
              //player.sendMessage("1");
              //player.sendMessage("3");
              //String name = clicked.getDisplayName();
              if(clicked.getDisplayName().startsWith("§b")){
                //player.sendMessage("4");
                Enchantment ench = clicked.getEnchants().keySet().iterator().next();
                if(event.getCursor() != null){
                  if(event.isShiftClick()){
                    event.setCursor(Enchant.clear(cursor, ench));
                    //player.sendMessage("0");
                  } else if(event.isLeftClick()){
                    event.setCursor(Enchant.add(cursor, ench, 1));
                    //player.sendMessage("+");
                  } else if(event.isRightClick()){
                    event.setCursor(Enchant.subtract(cursor, ench, 1));
                    //player.sendMessage("-");
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