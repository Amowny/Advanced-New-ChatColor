package me.emre.elitechat.Guis.guiCommands;

import me.emre.elitechat.EliteChat;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.sql.SQLException;

public class colorGUICommands implements Listener {

    private final EliteChat plugin;

    public colorGUICommands(EliteChat plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void onClickEvent(InventoryClickEvent e) throws SQLException {

        String ColorsGuiTitle = "&fᆟெ";
        String MainGuiTitle = "&fᆟே";
        String StaffGuiTitle = "&dStaff Color Menu";
        String SpecialGuiTitle = "&fᆟை";

        Player player = (Player) e.getWhoClicked();

        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', ColorsGuiTitle))) {
            e.setCancelled(true);

            int slot = e.getRawSlot();
            if (slot == 37) {
                player.openInventory(plugin.mGUI.mainMenu(player));
            } else if (slot == 10) {
                player.performCommand("color set c");
            } else if (slot == 11) {
                player.performCommand("color set 6");
            } else if (slot == 12) {
                player.performCommand("color set e");
            } else if (slot == 13) {
                player.performCommand("color set 2");
            } else if (slot == 14) {
                player.performCommand("color set b");
            } else if (slot == 15) {
                player.performCommand("color set 9");
            } else if (slot == 16) {
                player.performCommand("color set 5");
            } else if (slot == 19) {
                player.performCommand("color set f");
            } else if (slot == 20) {
                player.performCommand("color set a");
            } else if (slot == 21) {
                player.performCommand("color set d");
            } else if (slot == 22) {
                player.performCommand("color set 1");
            } else if (slot == 23) {
                player.performCommand("color set 3");
            } else if (slot == 24) {
                player.performCommand("color set 8");
            } else if (slot == 25) {
                player.performCommand("color set 7");
            }else if (slot == 28) {
                player.performCommand("color set 4");
            }else if (slot == 31) {
                player.performCommand("color set rainbow");
            }else if (slot == 34) {
                player.performCommand("color set 0");
            }
        } else if (e.getView().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', StaffGuiTitle))) {
            e.setCancelled(true);
            int slot = e.getRawSlot();
            if (slot == 0) {
                player.openInventory(plugin.mGUI.mainMenu(player));
            } else if (slot == 11) {
                player.performCommand("color set c");
            } else if (slot == 13) {
                player.performCommand("color set 4");
            } else if (slot == 15) {
                player.performCommand("color reset");
            }
        } else if (e.getView().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', MainGuiTitle))) {
            e.setCancelled(true);

            int slot = e.getRawSlot();
            if (slot == 25) {
                player.performCommand("color reset");
            } else if (slot == 12) {
                player.openInventory(plugin.cGUI.colorGUI(player));
            } else if (slot == 14) {
                player.openInventory(plugin.specgui.specialGUI(player));
            } else if (slot == 16) {
                player.openInventory(plugin.sGUI.mainMenu(player));
            } else if (slot == 19) {
                player.closeInventory();
            }
        }else if (e.getView().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', SpecialGuiTitle))){
            e.setCancelled(true);

            int slot = e.getRawSlot();
            if (slot == 37) {
                player.openInventory(plugin.mGUI.mainMenu(player));
            } else if (slot == 24) {
                player.performCommand("color set bold");
            } else if (slot == 22) {
                player.performCommand("color set italic");
            } else if (slot == 21) {
                player.performCommand("color set underline");
            }else if (slot == 23){
                player.performCommand("color set strikethrough");
            }else if (slot == 20){
                player.performCommand("color set magic");
            }
        }

    }

    private String Color(String s) {
        s = ChatColor.translateAlternateColorCodes('&',s);
        return s;
    }
}
