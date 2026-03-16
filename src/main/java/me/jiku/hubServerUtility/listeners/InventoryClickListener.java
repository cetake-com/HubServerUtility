package me.jiku.hubServerUtility.listeners;

import me.jiku.hubServerUtility.HubServerUtility;
import me.jiku.hubServerUtility.utlis.GUIUtils;
import org.bukkit.Material;
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
        var currentItemType = e.getCurrentItem().getType();
        var viewInventoryTitle = e.getView().getTitle();

        if(e.getCurrentItem() != null){

            if(viewInventoryTitle.equalsIgnoreCase(MAINMENU)){

                switch(currentItemType){
                    case ENDER_EYE:
                        GUIUtils.openMainMenu(player);
                        if(currentItemType == Material.GREEN_CONCRETE){

                        }else{

                        }
                        break;
                }

            }

        }
    }


}
