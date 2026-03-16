package me.jiku.hubServerUtility;

import me.jiku.hubServerUtility.commands.HSUCommand;
import me.jiku.hubServerUtility.listeners.InventoryClickListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class HubServerUtility extends JavaPlugin{

    @Override
    public void onEnable(){

        getCommand("hubserverutility").setExecutor(new HSUCommand());

        getServer().getPluginManager().registerEvents(new InventoryClickListener(this), this);

    }
}
