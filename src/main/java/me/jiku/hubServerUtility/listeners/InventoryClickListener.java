package me.jiku.hubServerUtility.listeners;

import me.jiku.hubServerUtility.HubServerUtility;
import me.jiku.hubServerUtility.utlis.GUIUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.awt.print.Book;


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
                case OAK_SIGN:
                    GUIUtils.openOptionMenu(player, Material.OAK_SIGN);
                    break;
                case RED_BED:
                    GUIUtils.openOptionMenu(player, Material.RED_BED);
                    break;
                case ITEM_FRAME:
                    GUIUtils.openOptionMenu(player, Material.ITEM_FRAME);
            }

        }else if(e.getView().getTitle().equalsIgnoreCase(OPTIONMENU)){

            e.setCancelled(true);

            //if you added option, set item
            if(e.getClickedInventory().contains(Material.ENDER_EYE)){
                String config_name = "init-spawn-setting";
                switch(e.getCurrentItem().getType()){
                    case GREEN_CONCRETE:
                        configChange(config_name, player, true);
                        break;
                    case RED_CONCRETE:
                        configChange(config_name, player, false);
                        break;
                }
            }else if(e.getClickedInventory().contains(Material.OAK_SIGN)){
                String config_name = "can-edit-sign";
                switch(e.getCurrentItem().getType()){
                    case GREEN_CONCRETE:
                        configChange(config_name, player, true);
                        break;
                    case RED_CONCRETE:
                        configChange(config_name, player, false);
                        break;
                }
            }else if(e.getClickedInventory().contains(Material.RED_BED)){
                String config_name = "can-change-spawn-point";
                switch(e.getCurrentItem().getType()){
                    case GREEN_CONCRETE:
                        configChange(config_name, player, true);
                        break;
                    case RED_CONCRETE:
                        configChange(config_name, player, false);
                        break;
                }
            }else if(e.getClickedInventory().contains(Material.ITEM_FRAME)){
                String config_name = "can-edit-item-in-flame";
                switch (e.getCurrentItem().getType()){
                    case GREEN_CONCRETE:
                        configChange(config_name, player, true);
                        break;
                    case RED_CONCRETE:
                        configChange(config_name, player, false);
                        break;
                }
            }
        }
    }

        public void configChange(String config_name, Player player, Boolean status){

        var config = plugin.getConfig();

            if(status == true){
                player.sendMessage(ChatColor.GREEN + "Option was Enabled!");
                config.set(config_name, true);
                plugin.saveConfig();
                GUIUtils.openMainMenu(player);
            }else if(status == false){
                player.sendMessage(ChatColor.RED + "Option was Disabled!");
                config.set(config_name, false);
                plugin.saveConfig();
                GUIUtils.openMainMenu(player);
            }
        }
}
