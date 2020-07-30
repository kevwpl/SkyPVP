package at.kevwpl.commands;

import at.kevwpl.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Kits implements CommandExecutor {

    public Kits(Main main){
        main.getCommand("kits").setExecutor(this);
        main.getCommand("kit").setExecutor(this);
    }


    HashMap<Player, Integer> spielerTime = new HashMap<Player, Integer>();
    HashMap<Player, Integer> vipTime = new HashMap<Player, Integer>();
    HashMap<Player, Integer> premiumTime = new HashMap<Player, Integer>();
    HashMap<Player, Integer> ultraTime = new HashMap<Player, Integer>();
    HashMap<Player, Integer> legendeTime = new HashMap<Player, Integer>();
    HashMap<Player, Integer> skykingTime = new HashMap<Player, Integer>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        Player p = (Player)sender;
        if(!spielerTime.containsKey(p)){
            spielerTime.put(p, -1);
        }
        if(!vipTime.containsKey(p)){
            vipTime.put(p, -1);
        }
        if(!premiumTime.containsKey(p)){
            premiumTime.put(p, -1);
        }
        if(!ultraTime.containsKey(p)){
            ultraTime.put(p, -1);
        }
        if(!legendeTime.containsKey(p)){
            legendeTime.put(p, -1);
        }
        if(!skykingTime.containsKey(p)){
            skykingTime.put(p, -1);
        }

        if(args.length != 0){
            p.sendMessage(Main.PREFIX + "§cBitte verwende nur /kits");
        }

        Inventory inv = Bukkit.createInventory(null, 9, "§aKits");

        ItemStack spielerKit = createKit("§7Spieler", Material.COAL, spielerTime, p);
        ItemStack vipKit = createKit("§eVIP", Material.GOLD_NUGGET, vipTime, p);
        ItemStack premiumKit = createKit("§6Premium", Material.GOLD_INGOT, premiumTime, p);
        ItemStack ultraKit = createKit("§bUltra", Material.IRON_INGOT, ultraTime, p);
        ItemStack legendeKit = createKit("§9Legende", Material.DIAMOND, legendeTime, p);
        ItemStack skykingKit = createKit("§dSkyking", Material.EMERALD, skykingTime, p);


        inv.addItem(spielerKit, vipKit, premiumKit, ultraKit, legendeKit, skykingKit);

        p.openInventory(inv);

        return true;
    }

    private ItemStack createKit(String name, Material mat, HashMap<Player, Integer> kitTime, Player p){
        int timeStarted = kitTime.get(p);
        int timeNow = (int) System.currentTimeMillis();


        List<String> kitLore = Arrays.asList("", "§a§lRechtsclick §r§8>> §a§lKit View", "§c§lLinksclick §r§8>> §c§lKit benutzen", "", "");

        ItemStack kit = new ItemStack(mat);
        ItemMeta kitMeta = kit.getItemMeta();
        kitMeta.setDisplayName("   §8>> §7Kit§8: " + name + " §8<<");
        kitMeta.setLore(kitLore);
        kit.setItemMeta(kitMeta);
        return kit;
    }
}
