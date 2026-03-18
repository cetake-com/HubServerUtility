package me.jiku.hubServerUtility.commands;

import me.jiku.hubServerUtility.HubServerUtility;
import me.jiku.hubServerUtility.utlis.GUIUtils;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jspecify.annotations.NonNull;

import java.util.ArrayList;

public class HSUCommand implements CommandExecutor{

    private final HubServerUtility plugin;

    public HSUCommand(HubServerUtility plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NonNull CommandSender sender, @NonNull Command command, @NonNull String label, @NonNull String[] args){

        int custom_Spawn_Args_Size = 6;
        var config = plugin.getConfig();

        if(sender instanceof Player player){

            if(args.length == 0){
                GUIUtils.openMainMenu(player);
            }

            if(args.length == 1){
                if(args[0].equalsIgnoreCase("initialspawn") || args[0].equalsIgnoreCase("is")){
                    initialSpawn(player);
                }
            }else if(args[0].equalsIgnoreCase("initialspawn") || args[0].equalsIgnoreCase("is")){

                if(args.length == custom_Spawn_Args_Size){

                    ArrayList<Double> coordinateList = new ArrayList<>();

                    for(int i = 1; i < custom_Spawn_Args_Size; i++){
                        if(canConvertDouble(args[i]) == true){
                            double value = Double.parseDouble(args[i]);
                            coordinateList.add(value);
                        }else if(canConvertDouble(args[i]) == false){
                            player.sendMessage("Please enter the command correctly. Ex) /hsu is x y z yaw pitch");
                            break;
                        }
                    }

                    double getX = coordinateList.get(0);
                    double getY = coordinateList.get(1);
                    double getZ = coordinateList.get(2);
                    double yaw = coordinateList.get(3);
                    double pitch = coordinateList.get(4);

                    double transX = Math.round(getX * 10 ) / 10.0;
                    double transY = Math.round(getY * 10 ) / 10.0;
                    double transZ = Math.round(getZ * 10 ) / 10.0;
                    double transYaw = Math.round(yaw * 10 ) / 10.0;
                    double transPitch = Math.round(pitch * 10 ) / 10.0;

                    setConfigInitialSpawn(player, transX, transY, transZ, transYaw, transPitch);

                }else{
                    player.sendMessage("Please enter the command correctly. Ex) /hsu is x y z yaw pitch");
                }

                if(args.length == 2){
                    switch(args[1]){
                        case "true":
                            player.sendMessage(ChatColor.GREEN + "Option was Enabled!");
                            config.set("init-spawn-setting", true);
                            plugin.saveConfig();
                            break;
                        case "false":
                            player.sendMessage(ChatColor.RED + "Option was Disabled!");
                            config.set("init-spawn-setting", false);
                            plugin.saveConfig();
                            break;
                        default:
                            player.sendMessage("You can select option, true of false");
                            break;

                    }
                }
            }
        }
        return true;
    }

    public void initialSpawn(Player player){

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

        setConfigInitialSpawn(player, transX, transY, transZ, transYaw, transPitch);
    }

    public void setConfigInitialSpawn(Player player, double x, double y, double z, double yaw, double pitch){

        var config = plugin.getConfig();

        config.set("init-spawn-posX", x);
        config.set("init-spawn-posY", y);
        config.set("init-spawn-posZ", z);
        config.set("init-spawn-yaw", yaw);
        config.set("init-spawn-pitch", pitch);

        player.sendMessage("Coordinates saved successfully");

        plugin.saveConfig();
    }

    public static boolean canConvertDouble(String string){

        if (string == null) return false;
        try{
            Double.parseDouble(string);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
}