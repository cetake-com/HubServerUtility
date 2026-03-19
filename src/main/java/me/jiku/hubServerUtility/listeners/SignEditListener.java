package me.jiku.hubServerUtility.listeners;

import me.jiku.hubServerUtility.HubServerUtility;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSignOpenEvent;

public class SignEditListener implements Listener{

    private final HubServerUtility plugin;

    public SignEditListener(HubServerUtility plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onSignOpen(PlayerSignOpenEvent e){

        Player player = e.getPlayer();

        if(plugin.getConfig().getBoolean("can-edit-sign") == false){

            if(!player.hasPermission("hubserverutility.op")){

                e.setCancelled(true);
                player.sendMessage("You don't have permission!");

            }

        }

    }
}
