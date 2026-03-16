package me.jiku.hubServerUtility.listeners;

import me.jiku.hubServerUtility.HubServerUtility;
import me.jiku.hubServerUtility.utlis.GUIUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener{

    public static final String MAINMENU = "Main Menu";
    public static final String OPTIONMENU = "Option Menu";

    private final HubServerUtility plugin;

    public InventoryClickListener(HubServerUtility plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        Player player = (Player) e.getWhoClicked();

        e.setCancelled(true);

        e.getCurrentItem();

        if(e.getCurrentItem() != null) return;

        if(e.getView().getTitle().equalsIgnoreCase(MAINMENU)){

            switch(e.getCurrentItem().getType()){
                case ENDER_EYE:
                    GUIUtils.openOptionMenu(player);
                    break;
            }

        }else if(e.getView().getTitle().equalsIgnoreCase(OPTIONMENU)){
                switch(e.getCurrentItem().getType()){
                    case GREEN_CONCRETE:
                        GUIUtils.openMainMenu(player);
                        player.sendMessage("Enable");
                        break;
                    case RED_CONCRETE:

                        GUIUtils.openMainMenu(player);
                        player.sendMessage("Disable");
                        break;

                }
            }
    }
}
