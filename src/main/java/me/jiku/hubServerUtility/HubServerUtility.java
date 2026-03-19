package me.jiku.hubServerUtility;

import me.jiku.hubServerUtility.commands.HSUCommand;
import me.jiku.hubServerUtility.listeners.InventoryClickListener;
import me.jiku.hubServerUtility.listeners.PlayerJoinListener;
import me.jiku.hubServerUtility.listeners.SignEditListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class HubServerUtility extends JavaPlugin{

    @Override
    public void onEnable(){

        getCommand("hubserverutility").setExecutor(new HSUCommand(this));

        getServer().getPluginManager().registerEvents(new InventoryClickListener(this), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(this), this);
        getServer().getPluginManager().registerEvents(new SignEditListener(this), this);

        saveDefaultConfig();

    }

}
