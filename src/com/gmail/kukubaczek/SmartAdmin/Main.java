package com.gmail.kukubaczek.SmartAdmin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.gmail.kukubaczek.SmartAdmin.commands.CmdClearInv;
import com.gmail.kukubaczek.SmartAdmin.commands.CmdEnderSee;
import com.gmail.kukubaczek.SmartAdmin.commands.CmdHelpOp;
import com.gmail.kukubaczek.SmartAdmin.commands.CmdInvSee;
import com.gmail.kukubaczek.SmartAdmin.commands.CmdKick;
import com.gmail.kukubaczek.SmartAdmin.commands.CmdKickAll;
import com.gmail.kukubaczek.SmartAdmin.commands.CmdSmartAdmin;
import com.gmail.kukubaczek.SmartAdmin.events.OnChat;
import com.gmail.kukubaczek.SmartAdmin.events.MainMenuOnInvClick;
import com.gmail.kukubaczek.SmartAdmin.events.OnDamage;
import com.gmail.kukubaczek.SmartAdmin.events.OnRightClick;
import com.gmail.kukubaczek.SmartAdmin.events.PlayerMenuOnInvClick;
import com.gmail.kukubaczek.SmartAdmin.events.PlayersListOnInvClick;
import com.gmail.kukubaczek.SmartAdmin.events.antycheat.OnInvOpen;
import com.gmail.kukubaczek.SmartAdmin.events.JoinLeaveMsg;


public class Main extends JavaPlugin{

  private static Plugin plugin;

  public static String tag_error;
  public static String tag_tag;
  public static String tag_AC;
  public static String join_msg;
  public static String leave_msg;

  public static boolean chat = true;

  /*
   * 
   * Autor: Kukubaczek & JuniorJPDJ
   * Obowiązuje zakaz używania kodu bez wiedzy i zgody autorów.
   * Plugin jest cały czas w trakcie tworzenia! Zmiany następują co kilka minut!
   * 
   */

  @Override
  public void onEnable() {
    plugin = this;
    
    registerEvents(this, new OnChat(), new MainMenuOnInvClick(), new PlayersListOnInvClick(), new PlayerMenuOnInvClick(), new OnInvOpen(), new OnRightClick(), new OnDamage(), new JoinLeaveMsg());
    
    getCommand("SmartAdmin").setExecutor(new CmdSmartAdmin());
    getCommand("Kick").setExecutor(new CmdKick());
    getCommand("KickAll").setExecutor(new CmdKickAll());
    getCommand("HelpOp").setExecutor(new CmdHelpOp());
    getCommand("EnderSee").setExecutor(new CmdEnderSee());
    getCommand("InvSee").setExecutor(new CmdInvSee());
    getCommand("ClearInv").setExecutor(new CmdClearInv());
    
    saveDefaultConfig();
    reloadCfg();
    
  }

  public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
    for (Listener listener : listeners) {
      Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
    }
  }

  public static Plugin getPlugin() {
    return plugin;
  }

  public static void setVar(String var, boolean set){
    if(var.equalsIgnoreCase("chat")){
      chat = set;
    }else{
      return;
    }
  }

  public static boolean getVar(String var){
    if(var.equalsIgnoreCase("chat")){
      return chat;
    }else{
      return false;
    }
  }
  
  public static void reloadCfg(){
    plugin.reloadConfig();
    tag_tag = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("TAG"));
    tag_error = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("TAG_ERROR"));
    tag_AC = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("TAG_ANTYCHEAT"));
    join_msg = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("JOIN_MESSAGE"));
    leave_msg = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("LEAVE_MESSAGE"));
  }

  public static String getTag(String tag){
    if(tag.equalsIgnoreCase("tag")){
      return tag_tag;
    } else if (tag.equalsIgnoreCase("error")){
      return tag_error;
    } else if (tag.equalsIgnoreCase("AC")){
      return tag_AC;
    } else {
      String err = ChatColor.DARK_RED + "ERROR!";
      return err;
    }
  }

}
