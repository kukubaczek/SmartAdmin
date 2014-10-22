package com.gmail.kukubaczek.SmartAdmin.commands;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gmail.kukubaczek.SmartAdmin.Main;

public class CmdGamemode implements CommandExecutor{
  
  private static final Map<String, GameMode> gamemodes = new HashMap<String, GameMode>(){
    private static final long serialVersionUID = -1932765058040624335L;{
    put("0", GameMode.SURVIVAL);
    put("s", GameMode.SURVIVAL);
    put("survival", GameMode.SURVIVAL);
    put("1", GameMode.CREATIVE);
    put("c", GameMode.CREATIVE);
    put("creative", GameMode.CREATIVE);
    put("2", GameMode.ADVENTURE);
    put("a", GameMode.ADVENTURE);
    put("adventure", GameMode.ADVENTURE);
  }};
  
  @SuppressWarnings("deprecation")
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if(sender instanceof Player){
      Player p = (Player) sender;
      switch(args.length){
      case 0:
        GameMode gm = (!p.getGameMode().equals(GameMode.CREATIVE))?GameMode.CREATIVE:GameMode.SURVIVAL;
        Bukkit.broadcast(Main.getTag("tag") + " §a" + p.getName() + " §fwłączył sobie tryb gry §a" + gm.toString() + "§f!", "SmartAdmin.*");
        p.setGameMode(gm);
        return true;
      case 1:
        if(gamemodes.containsKey(args[0])){
          gm = gamemodes.get(args[0]);
          Bukkit.broadcast(Main.getTag("tag") + " §a" + p.getName() + " §fwłączył sobie tryb gry §a" + gm.toString() + "§f!", "SmartAdmin.*");
          p.setGameMode(gm);
        } else {
          p.sendMessage(Main.getTag("error") + " §fBłędny argument §a" + args[0]);
        }
        return true;
      case 2:
        if(gamemodes.containsKey(args[0])){
          gm = gamemodes.get(args[0]);
          Player gracz = Bukkit.getPlayerExact(args[1]);
          if(gracz != null){
            Bukkit.broadcast(Main.getTag("tag") + " §a" + p.getName() + " §fwłączył graczowi §a" + args[1] + "§f tryb gry §a" + gm.toString() + "§f!", "SmartAdmin.*");
            gracz.setGameMode(gm);
          } else {
            p.sendMessage(Main.getTag("error") + " §fWybrany gracz jest offline!");
          }
        } else {
          p.sendMessage(Main.getTag("error") + " §fBłędny argument §a" + args[0]);
        }
        return true;
      default:
        p.sendMessage(Main.getTag("tag") + " §fNieprawidłowa ilość argumentów");
      }
    }
    return false;
  }
}