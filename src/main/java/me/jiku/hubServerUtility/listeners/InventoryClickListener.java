package me.jiku.hubServerUtility.listeners;

import me.jiku.hubServerUtility.HubServerUtility;
import me.jiku.hubServerUtility.utlis.GUIUtils;
import org.bukkit.ChatColor;
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
        var config = plugin.getConfig();

        e.getCurrentItem();

        if(e.getCurrentItem() == null) return;

        if(e.getView().getTitle().equalsIgnoreCase(MAINMENU)){

            e.setCancelled(true);

            //if you want to add setting, you add option item here
            switch(e.getCurrentItem().getType()){
                case ENDER_EYE:
                    GUIUtils.openOptionMenu(player, Material.ENDER_EYE);
                    break;

            }

        }else if(e.getView().getTitle().equalsIgnoreCase(OPTIONMENU)){

            e.setCancelled(true);

            //if you added option item set behavior
            if(e.getClickedInventory().contains(Material.ENDER_EYE)){
                switch(e.getCurrentItem().getType()){
                    case GREEN_CONCRETE:
                        player.sendMessage(ChatColor.GREEN + "Option was Enabled!");
                        config.set("init-spawn-setting", true);
                        plugin.saveConfig();
                        GUIUtils.openMainMenu(player);
                        break;
                    case RED_CONCRETE:
                        player.sendMessage(ChatColor.RED + "Option was Disabled!");
                        config.set("init-spawn-setting", false);
                        plugin.saveConfig();
                        GUIUtils.openMainMenu(player);
                        break;
                }
            }
        }
    }
}
