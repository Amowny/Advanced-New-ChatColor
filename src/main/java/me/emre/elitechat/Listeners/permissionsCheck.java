package me.emre.elitechat.Listeners;

import me.emre.elitechat.EliteChat;
import org.bukkit.entity.Player;

public class permissionsCheck {

    private final EliteChat plugin;
    public permissionsCheck(EliteChat plugin){
        this.plugin = plugin;
    }


    public String permChecker(Player player){

        String resetColor = null;

        if (player.hasPermission("elitechat.defaults.white")){
            resetColor = "&f";
        }else if (player.hasPermission("elitechat.defaults.darkgreen")){
            resetColor = "&2";
        }else if (player.hasPermission("elitechat.defaults.cyan")){
            resetColor = "&3";
        }else if (player.hasPermission("elitechat.defaults.darkred")){
            resetColor = "&4";
        }else if (player.hasPermission("elitechat.defaults.purple")){
            resetColor = "&5";
        }else if (player.hasPermission("elitechat.defaults.gold")){
            resetColor = "&6";
        }else if (player.hasPermission("elitechat.defaults.gray")){
            resetColor = "&7";
        }else if (player.hasPermission("elitechat.defaults.darkgray")){
            resetColor = "&8";
        }else if (player.hasPermission("elitechat.defaults.blue")){
            resetColor = "&9";
        }else if (player.hasPermission("elitechat.defaults.black")){
            resetColor = "&0";
        }else if (player.hasPermission("elitechat.defaults.lime")){
            resetColor = "&a";
        }else if (player.hasPermission("elitechat.defaults.aqua")){
            resetColor = "&b";
        }else if (player.hasPermission("elitechat.defaults.darkblue")){
            resetColor = "&1";
        }else if (player.hasPermission("elitechat.defaults.pink")){
            resetColor = "&d";
        }else if (player.hasPermission("elitechat.defaults.yellow")){
            resetColor = "&e";
        }else if (player.hasPermission("elitechat.defaults.red")){
            resetColor = "&c";
        }else{
            resetColor = plugin.getConfig().getString("Plugin.DefaultColor");
        }

        return resetColor;

    }

}
