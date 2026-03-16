package me.jiku.hubServerUtility.commands;

import me.jiku.hubServerUtility.utlis.GUIUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jspecify.annotations.NonNull;

public class HSUCommand implements CommandExecutor{
    @Override
    public boolean onCommand(@NonNull CommandSender sender, @NonNull Command command, @NonNull String label, @NonNull String[] args){

        if(sender instanceof Player player){

            if(args.length == 0){
                GUIUtils.openMainMenu(player);
            }

        }

        return true;
    }
}
