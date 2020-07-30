package at.kevwpl;

import at.kevwpl.commands.Kits;
import at.kevwpl.listener.PlayerListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class Main extends JavaPlugin {

    public static String PREFIX = "§6§lS§e§lky§6§lM§e§laus §r§8>> §r";

    @Override
    public void onEnable() {
        super.onEnable();

        new Kits(this);
        new PlayerListener(this);

    }
}
