package com.gmail.kukubaczek.SmartAdmin.events;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.meta.ItemMeta;

import com.gmail.kukubaczek.SmartAdmin.Main;
import com.gmail.kukubaczek.SmartAdmin.MainMenuCreator;
import com.gmail.kukubaczek.SmartAdmin.PlayersListCreator;
import com.gmail.kukubaczek.SmartAdmin.functions.KickAll;

public class MainMenuOnInvClick implements Listener{

  @EventHandler
  public void onInventoryClick(InventoryClickEvent event) {
    Player player = (Player) event.getWhoClicked();
    Inventory inventory = event.getInventory();
    if((inventory.getName() == "§aS§fmart§bA§fdmin") && (event.getCurrentItem() != null)){
      event.setCancelled(true);
      if(player.hasPermission("SmartAdmin.*")){

        ItemMeta clicked = event.getCurrentItem().getItemMeta();
        if(clicked == null) return;
        if(clicked.hasDisplayName()){
          World wrl = player.getWorld();
          
          //czat
          if(clicked.getDisplayName() == "§cWyłącz chat"){
            Main.setVar("chat", false);
            Bukkit.broadcastMessage(Main.getTag("tag") + " §cChat został wyłączony!");
            Bukkit.broadcast(Main.getTag("tag") + " §a" + player.getName() + " §fwyłączył chat!", "SmartAdmin.*");
            MainMenuCreator.reloadInv();
            
          } else if(clicked.getDisplayName() == "§aWłącz chat"){
            Main.setVar("chat", true);
            Bukkit.broadcastMessage(Main.getTag("tag") + " §aChat został włączony!");
            Bukkit.broadcast(Main.getTag("tag") + " §a" + player.getName() + " §fwłączył chat!", "SmartAdmin.*");
            MainMenuCreator.reloadInv();
            
          } else if(clicked.getDisplayName() == "§bWyczyść chat"){
            for (int i = 0; i < 50; i++){
              Bukkit.broadcastMessage(" ");
            }
            Bukkit.broadcastMessage(Main.getTag("tag") + " §bChat został wyczyszczony!");
            Bukkit.broadcast(Main.getTag("tag") + " §a" + player.getName() + " §fwyczyścił chat!", "SmartAdmin.*");
            
            //czas
          } else if(clicked.getDisplayName() == "§eUstaw dzień"){
            wrl.setTime(1000L);
            Bukkit.broadcast(Main.getTag("tag") + " §a" + player.getName() + " §fustawił czas na §adzień§f w świecie §a" + wrl.getName() + "§f!", "SmartAdmin.*");
            
          } else if(clicked.getDisplayName() == "§7Ustaw noc"){
            wrl.setTime(14000L);
            Bukkit.broadcast(Main.getTag("tag") + " §a" + player.getName() + " §fustawił czas na §anoc§f w świecie §a" + wrl.getName() + "§f!", "SmartAdmin.*");
            
            //deszcz
          } else if(clicked.getDisplayName() == "§bWyłącz deszcz"){
            wrl.setStorm(false);
            wrl.setThundering(false);
            Bukkit.broadcast(Main.getTag("tag") + " §fDeszcz został §awyłączony §fprzez §a" + player.getName() + " §fw świecie §a" + wrl.getName() + "§f!", "SmartAdmin.*");
            
          } else if(clicked.getDisplayName() == "§4Włącz deszcz"){
            wrl.setStorm(true);
            wrl.setThundering(true);
            Bukkit.broadcast(Main.getTag("tag") + " §fDeszcz został §awłączony §fprzez §a" + player.getName() + " §fw świecie §a" + wrl.getName() + "§f!", "SmartAdmin.*");
            
            //kickall
          } else if(clicked.getDisplayName() == "§bWyrzuć wszystkich graczy"){
            KickAll.kickall(player.getName());
            Bukkit.broadcast(Main.getTag("tag") + " §fWszyscy gracze zostali wyrzuceni przez §a " + player.getName() + "§f!", "SmartAdmin.*");
            
            //gracze
          } else if(clicked.getDisplayName() == "§bZarządzaj graczami"){
            //player.sendMessage("o kurwa dziala");
            player.closeInventory();
            PlayersListCreator.openInv(player, 1);
          }
        }

      } else {
        player.sendMessage(Main.getTag("error") + " §fNie posiadasz wystarczających uprawnień!");
        player.closeInventory();
      }
    }
  }
}