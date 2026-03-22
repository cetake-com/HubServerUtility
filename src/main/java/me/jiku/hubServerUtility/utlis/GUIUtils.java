package me.jiku.hubServerUtility.utlis;

import me.jiku.hubServerUtility.HubServerUtility;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class GUIUtils{

    public static final String MAINMENU = "Main Menu";
    public static final String OPTIONMENU = "Option Menu";

    private static ArrayList<ItemStack> settingList = new ArrayList<>();

    private final HubServerUtility plugin;

    public GUIUtils(HubServerUtility plugin){
        this.plugin = plugin;
    }

    public static void openMainMenu(Player player){

        int inventory_size = 27;

        Inventory main_menu = Bukkit.createInventory(player, inventory_size, MAINMENU);

        ItemStack init_spawn_pos = new ItemStack(Material.ENDER_EYE);
        ItemMeta init_spawnp_pos_meta = init_spawn_pos.getItemMeta();
        init_spawnp_pos_meta.setDisplayName("Initial Spawn Point");
        init_spawn_pos.setItemMeta(init_spawnp_pos_meta);

        ItemStack edit_sign = new ItemStack(Material.OAK_SIGN);
        ItemMeta edit_sign_meta = edit_sign.getItemMeta();
        edit_sign_meta.setDisplayName("Can Edit Sign");
        edit_sign.setItemMeta(edit_sign_meta);

        ItemStack change_spawn_point = new ItemStack(Material.RED_BED);
        ItemMeta change_spawn_point_meta = change_spawn_point.getItemMeta();
        change_spawn_point_meta.setDisplayName("Can Change Spawn Point with Bed");
        change_spawn_point.setItemMeta(change_spawn_point_meta);

        ItemStack can_edit_item = new ItemStack(Material.ITEM_FRAME);
        ItemMeta can_edit_item_meta = can_edit_item.getItemMeta();
        can_edit_item_meta.setDisplayName("Can Edit Item in Item Flame");
        can_edit_item.setItemMeta(can_edit_item_meta);

        main_menu.setItem(0, init_spawn_pos);
        main_menu.setItem(1, edit_sign);
        main_menu.setItem(2, change_spawn_point);
        main_menu.setItem(3, can_edit_item);

        player.openInventory(main_menu);

    }

    public static void openOptionMenu(Player player, Material option){

        int inventory_size = 9;

        Inventory option_menu = Bukkit.createInventory(player, inventory_size, OPTIONMENU);

        ItemStack option_Item = new ItemStack(option);
        ItemMeta option_meta = option_Item.getItemMeta();
        String setting_name;
        String config_setting_name;

        //if you added setting, add item
        switch(option){
            case ENDER_EYE:
                setting_name = "Initial Spawn Position";
                config_setting_name = "init-spawn-setting";
                getSettingStatus(option_Item, option_meta, setting_name, config_setting_name);
                break;
            case OAK_SIGN:
                setting_name = "Can Edit Sign";
                config_setting_name = "can-edit-sign";
                getSettingStatus(option_Item, option_meta, setting_name, config_setting_name);
                break;
            case RED_BED:
                setting_name = "Can Change Spawn Point with Bed";
                config_setting_name = "can-change-spawn-point";
                getSettingStatus(option_Item, option_meta, setting_name, config_setting_name);
                break;
            case ITEM_FRAME:
                setting_name = "Can Edit Item in Item Flame";
                config_setting_name = "can-edit-item-in-flame";
                getSettingStatus(option_Item, option_meta, setting_name, config_setting_name);
                break;
        }

        //make enable button
        ItemStack enable = new ItemStack(Material.GREEN_CONCRETE);
        ItemMeta enable_meta = enable.getItemMeta();
        enable_meta.setDisplayName(ChatColor.GREEN + "Enable");
        enable.setItemMeta(enable_meta);

        //make disable button
        ItemStack disable = new ItemStack(Material.RED_CONCRETE);
        ItemMeta disable_meta = disable.getItemMeta();
        disable_meta.setDisplayName(ChatColor.RED + "Disable");
        disable.setItemMeta(disable_meta);

        option_menu.setItem(0, enable);
        option_menu.setItem(4, option_Item);
        option_menu.setItem(8, disable);

        player.openInventory(option_menu);
    }

    public static void getSettingStatus(ItemStack option_item, ItemMeta option_meta, String setting_name, String config_setting_name){

        var config = Bukkit.getPluginManager().getPlugin("HubServerUtility").getConfig();
        option_meta.setDisplayName(setting_name);
        List<String> lore = new ArrayList<>();

        if(config.getBoolean(config_setting_name) == true){
            lore.add(ChatColor.GREEN + "Now Enable");
            option_meta.setLore(lore);
        }else{
            lore.add(ChatColor.RED + "Now Disable");
            option_meta.setLore(lore);
        }
        option_item.setItemMeta(option_meta);
    }
}
