package com.gmail.kukubaczek.SmartAdmin.functions;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Enchant {

  public static ItemStack add(ItemStack item, Enchantment enchant, Integer level){
    ItemMeta meta = item.getItemMeta();
    Integer lvl = item.getEnchantmentLevel(enchant);
    meta.addEnchant(enchant, lvl + level, true);
    item.setItemMeta(meta);

    return item;
  }

  public static ItemStack subtract(ItemStack item, Enchantment enchant, Integer level){
    ItemMeta meta = item.getItemMeta();
    Integer lvl = item.getEnchantmentLevel(enchant);
    if(lvl <= level){
      meta.removeEnchant(enchant);
    }else if(lvl > level){
      meta.addEnchant(enchant, lvl - level, true);
    }
    item.setItemMeta(meta);

    return item;
  }

  public static ItemStack clear(ItemStack item, Enchantment enchant){
    ItemMeta meta = item.getItemMeta();
    meta.removeEnchant(enchant);
    item.setItemMeta(meta);

    return item;
  }

  public static ItemStack set(ItemStack item, Enchantment enchant, Integer level){
    ItemMeta meta = item.getItemMeta();
    meta.addEnchant(enchant, level, true);
    item.setItemMeta(meta);

    return item;
  }
}