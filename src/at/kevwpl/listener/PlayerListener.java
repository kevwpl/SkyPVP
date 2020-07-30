package at.kevwpl.listener;

import at.kevwpl.Main;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class PlayerListener implements Listener {

    public PlayerListener(Main main){
        Bukkit.getPluginManager().registerEvents(this, main);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        e.setJoinMessage(Main.PREFIX + "§f§l" + e.getPlayer().getDisplayName() + " §r§7ist beigetreten");
    }

    @EventHandler
    public void onInventoryDrag(InventoryDragEvent e){
        e.setCancelled(true);
    }



}
