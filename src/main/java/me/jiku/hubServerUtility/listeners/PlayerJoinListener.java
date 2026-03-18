package me.jiku.hubServerUtility.listeners;

import me.jiku.hubServerUtility.HubServerUtility;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener{

    private final HubServerUtility plugin;

    public PlayerJoinListener(HubServerUtility plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){

        Player player = e.getPlayer();

        boolean init_spawn_setting = plugin.getConfig().getBoolean("init-spawn-setting");

        if(init_spawn_setting == true){

            tpInitialSpawn(player);

        }
    }

    public void tpInitialSpawn(Player player){

        float posX = (float) plugin.getConfig().getDouble("init-spawn-posX");
        float posY = (float) plugin.getConfig().getDouble("init-spawn-posY");
        float posZ = (float) plugin.getConfig().getDouble("init-spawn-posZ");
        float yaw = (float) plugin.getConfig().getDouble("init-spawn-yaw");
        float pitch = (float) plugin.getConfig().getDouble("init-spawn-pitch");

        Location init_spawn_loc = new Location(player.getWorld(), posX, posY, posZ, yaw, pitch);

        player.teleport(init_spawn_loc);

    }
}