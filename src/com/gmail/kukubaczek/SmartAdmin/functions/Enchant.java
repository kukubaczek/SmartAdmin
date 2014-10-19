package com.gmail.kukubaczek.SmartAdmin.functions;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Enchant {

  public static ItemStack add(ItemStack item, Enchantment enchant, Integer level){
    Integer lvl = item.getEnchantmentLevel(enchant);
    if(lvl == null) lvl = 0;
    item.addUnsafeEnchantment(enchant, lvl + level);

    return item;
  }

  public static ItemStack subtract(ItemStack item, Enchantment enchant, Integer level){
    Integer lvl = item.getEnchantmentLevel(enchant);
    if(lvl == null) lvl = 0;
    if(lvl <= level){
      item.removeEnchantment(enchant);
    }else if(lvl > level){
      item.addUnsafeEnchantment(enchant, lvl - level);
    }

    return item;
  }

  public static ItemStack clear(ItemStack item, Enchantment enchant){
    if(item.hasItemMeta()){
      ItemMeta meta = item.getItemMeta();
      meta.removeEnchant(enchant);
      item.setItemMeta(meta);
    }
    return item;
  }

  public static ItemStack set(ItemStack item, Enchantment enchant, Integer level){
    item.addUnsafeEnchantment(enchant, level);

    return item;
  }
}