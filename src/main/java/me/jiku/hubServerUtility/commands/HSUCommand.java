package me.jiku.hubServerUtility.commands;

import me.jiku.hubServerUtility.HubServerUtility;
import me.jiku.hubServerUtility.utlis.GUIUtils;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jspecify.annotations.NonNull;

public class HSUCommand implements CommandExecutor{

    private final HubServerUtility plugin;

    public HSUCommand(HubServerUtility plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NonNull CommandSender sender, @NonNull Command command, @NonNull String label, @NonNull String[] args){

        var config = plugin.getConfig();

        if(sender instanceof Player player){

            if(args.length == 0){
                GUIUtils.openMainMenu(player);
            }

            if(args.length == 1){
                if(args[0].equalsIgnoreCase("initialspawn") || args[0].equalsIgnoreCase("is")){

                    Location loc = player.getLocation();

                    double getX = loc.getX();
                    double getY = loc.getY();
                    double getZ = loc.getZ();
                    double getYaw = loc.getYaw();
                    double getPitch = loc.getPitch();

                    double transX = Math.round(getX * 10) / 10.0;
                    double transY = Math.round(getY * 10) / 10.0;
                    double transZ = Math.round(getZ * 10) / 10.0;
                    double transYaw = Math.round(getYaw * 10) / 10.0;
                    double transPitch = Math.round(getPitch * 10) / 10.0;

                    config.set("init-spawn-posX", transX);
                    config.set("init-spawn-posY", transY);
                    config.set("init-spawn-posZ", transZ);
                    config.set("init-spawn-yaw", transYaw);
                    config.set("init-spawn-pitch", transPitch);

                    player.sendMessage("Coordinates saved successfully");

                    plugin.saveConfig();
                }
            }
        }
        return true;
    }
}
