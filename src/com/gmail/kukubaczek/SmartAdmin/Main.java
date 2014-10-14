package com.gmail.kukubaczek.SmartAdmin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.gmail.kukubaczek.SmartAdmin.commands.CmdKick;
import com.gmail.kukubaczek.SmartAdmin.commands.CmdKickAll;
import com.gmail.kukubaczek.SmartAdmin.commands.CmdSmartAdmin;
import com.gmail.kukubaczek.SmartAdmin.events.OnChat;
import com.gmail.kukubaczek.SmartAdmin.events.MainMenuOnInvClick;
import com.gmail.kukubaczek.SmartAdmin.events.OnRightClick;
import com.gmail.kukubaczek.SmartAdmin.events.PlayerMenuOnInvClick;
import com.gmail.kukubaczek.SmartAdmin.events.PlayersListOnInvClick;
import com.gmail.kukubaczek.SmartAdmin.events.antycheat.OnInvOpen;


public class Main extends JavaPlugin{

  private static Main plugin;

  public static String tag_error;
  public static String tag_tag;
  public static String tag_AC;

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
    registerEvents(this, new OnChat(), new MainMenuOnInvClick(), new PlayersListOnInvClick(), new PlayerMenuOnInvClick(), new OnInvOpen(), new OnRightClick());
    
    getCommand("SmartAdmin").setExecutor(new CmdSmartAdmin()); //Czemu nie zrobicie rejestrowania komend bezpośrednio poprzez CommandMap? Nie musicie dodować ich wtedy do plugin.yml a i zarządzanie nimi jest dużo prostsze ;)
    getCommand("Kick").setExecutor(new CmdKick());
    getCommand("KickAll").setExecutor(new CmdKickAll());
    
    

    /*
     *  Rejestracja Configów
     */

    Cfg.registerConfig("config", "config.yml", this);
    Cfg .loadAll();



    tag_tag = Cfg.getConfig("config").getString("TAG"); //Config zrobiłbym inaczej, ale jako ze nie umiem tworzyć nowych plików to Wam nie pokaże :D
    tag_error = Cfg.getConfig("config").getString("TAG_ERROR");
    tag_AC = Cfg.getConfig("config").getString("TAG_ANTYCHEAT");

    tag_tag = ChatColor.translateAlternateColorCodes('&', tag_tag);
    tag_error = ChatColor.translateAlternateColorCodes('&', tag_error);
    tag_AC = ChatColor.translateAlternateColorCodes('&', tag_AC);

  }

  public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
    for (Listener listener : listeners) {
      Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
    }
  }

  public static Main getPlugin() {
    return plugin; //zwraca swój obiekt pluginu, nie interfejs. Masz dostęp wtedy do własnych metod ;>
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
    Cfg.loadAll();
    tag_tag = Cfg.getConfig("config").getString("TAG");
    tag_error = Cfg.getConfig("config").getString("TAG_ERROR");
    tag_AC = Cfg.getConfig("config").getString("TAG_ANTYCHEAT");

    tag_tag = ChatColor.translateAlternateColorCodes('&', tag_tag);
    tag_error = ChatColor.translateAlternateColorCodes('&', tag_error);
    tag_AC = ChatColor.translateAlternateColorCodes('&', tag_AC);
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
