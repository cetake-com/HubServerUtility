package me.jiku.hubServerUtility.listeners;

import me.jiku.hubServerUtility.HubServerUtility;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class RightClickEntityListener implements Listener {

    private final HubServerUtility plugin;

    public RightClickEntityListener(HubServerUtility plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerRightClick(PlayerInteractEntityEvent e){

        Player player = e.getPlayer();
        var config = plugin.getConfig();
        var clickedEntityType = e.getRightClicked().getType();

        if (!config.getBoolean("can-edit-item-in-flame")) {

            if(!player.hasPermission("hubserverutility.op")){
                switch (clickedEntityType){
                    case ITEM_FRAME:
                        player.sendMessage("You can't edit item in Item Flame!");
                        e.setCancelled(true);
                        break;
                    case GLOW_ITEM_FRAME:
                        player.sendMessage("You can't edit item in Item Flame!");
                        e.setCancelled(true);
                        break;
                }
            }
        }
    }
}
