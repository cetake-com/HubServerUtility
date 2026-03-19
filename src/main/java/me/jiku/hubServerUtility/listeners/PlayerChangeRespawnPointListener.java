package me.jiku.hubServerUtility.listeners;

import me.jiku.hubServerUtility.HubServerUtility;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSpawnChangeEvent;

public class PlayerChangeRespawnPointListener implements Listener{

    private final HubServerUtility plugin;

    public PlayerChangeRespawnPointListener(HubServerUtility plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerChangeRespawnPoint(PlayerSpawnChangeEvent e){

        Player player = e.getPlayer();
        var config = plugin.getConfig();

        if(config.getBoolean("can-change-spawn-point") == false){
            player.sendMessage("You can't change spawn point!");
            e.setCancelled(true);
        }

    }

}
