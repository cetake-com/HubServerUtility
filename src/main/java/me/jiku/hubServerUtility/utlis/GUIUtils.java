package me.jiku.hubServerUtility.utlis;

import me.jiku.hubServerUtility.HubServerUtility;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class GUIUtils{

    private final HubServerUtility plugin;

    public static final String MAINMENU = "Main Menu";
    public static final String OPTIONMENU = "Option Menu";

    public GUIUtils(HubServerUtility plugin){
        this.plugin = plugin;
    }

    public static void openMainMenu(Player player){

        int inventory_size = 27;

        Inventory main_menu = Bukkit.createInventory(player, inventory_size, MAINMENU);

        ItemStack init_spawn_pos = new ItemStack(Material.ENDER_EYE);
        ItemMeta init_spawnp_pos_meta = init_spawn_pos.getItemMeta();
        init_spawnp_pos_meta.setDisplayName("Initial spawn point");
        init_spawn_pos.setItemMeta(init_spawnp_pos_meta);

        main_menu.setItem(0, init_spawn_pos);

        player.openInventory(main_menu);

    }

    public static void openOptionMenu(Player player, Material option){

        int inventory_size = 9;

        Inventory option_menu = Bukkit.createInventory(player, inventory_size, OPTIONMENU);

        ItemStack option_Item = new ItemStack(option);
        ItemMeta option_meta = option_Item.getItemMeta();

        //if you wanted option, make itemstack.

        //if you added setting, add item
        if(option == Material.ENDER_EYE){
            option_meta.setDisplayName("Initial spawn position");

            List<String> lore =new ArrayList<>();
            if(Bukkit.getPluginManager().getPlugin("HubServerUtility").getConfig().getBoolean("init-spawn-setting") == true){
                lore.add(ChatColor.GREEN + "Now Enable");
                option_meta.setLore(lore);
            }else{
                lore.add(ChatColor.RED + "Now Disable");
                option_meta.setLore(lore);
            }
            option_Item.setItemMeta(option_meta);

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
}
