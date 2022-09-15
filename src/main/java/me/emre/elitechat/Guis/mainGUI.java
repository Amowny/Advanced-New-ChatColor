package me.emre.elitechat.Guis;

import me.emre.elitechat.EliteChat;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.SkullType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class mainGUI {

    private final EliteChat plugin;
    public mainGUI(EliteChat plugin){
        this.plugin = plugin;
    }

    public Inventory mainMenu(Player player) throws SQLException {

        PreparedStatement ps1 = plugin.DB.getConnection().prepareStatement("SELECT color FROM chatcolor WHERE playerUUID=?");
        ps1.setString(1 , player.getUniqueId().toString());
        ResultSet rs1 = ps1.executeQuery();
        String color = null;
        if (rs1.next()){
            color = rs1.getString("color");
        }

        String fillerItem2 = plugin.getConfig().getString("GUI.Settings.Items.Filler");
        String guiTitle = "&fᆟே";

        Inventory MainGUI = Bukkit.createInventory((InventoryHolder)player, 27, org.bukkit.ChatColor.translateAlternateColorCodes('&', guiTitle));

        ItemStack fillerItem = new ItemStack(Material.valueOf(fillerItem2), 1);
        ItemStack colorItem = new ItemStack(Material.PAPER, 1);
        ItemStack specialItem = new ItemStack(Material.PAPER, 1);
        ItemStack staffItem = new ItemStack(Material.BARRIER, 1);
        ItemStack closeItem = new ItemStack(Material.BARRIER, 1);
        ItemStack playerHead = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());

        ItemMeta filleritem = fillerItem.getItemMeta();
        filleritem.setCustomModelData(3162);
        filleritem.setDisplayName(Color("&7"));
        fillerItem.setItemMeta(filleritem);

        ItemMeta coloritem = colorItem.getItemMeta();
        coloritem.setCustomModelData(3162);
        coloritem.setDisplayName(Color(Hex("&6Pick &fA &eColor")));
        ArrayList<String> colorlore = new ArrayList<>();
        colorlore.add(Color(Hex("&eLeft click to go to the color menu.")));
        coloritem.setLore(colorlore);
        colorItem.setItemMeta(coloritem);

        ItemMeta staffmeta = staffItem.getItemMeta();
        staffmeta.setDisplayName(Color(Hex("&cStaff Colors")));
        ArrayList<String> stafflore = new ArrayList<>();
        stafflore.add(Color(Hex("&eLeft click to go to the staff menu.")));
        staffmeta.setLore(stafflore);
        staffItem.setItemMeta(staffmeta);

        ItemMeta specialmeta = specialItem.getItemMeta();
        specialmeta.setCustomModelData(3162);
        specialmeta.setDisplayName(Color(Hex("&3Special &bEffects")));
        ArrayList<String> speciallore = new ArrayList<>();
        speciallore.add(Color(Hex("&eLeft click to go to the special effects menu.")));
        specialmeta.setLore(speciallore);
        specialItem.setItemMeta(specialmeta);

        ItemMeta closemeta = closeItem.getItemMeta();
        closemeta.setCustomModelData(6231);
        closemeta.setDisplayName(Color(Hex("&8Back to menu.")));
        closeItem.setItemMeta(closemeta);

        SkullMeta skullmeta = (SkullMeta)playerHead.getItemMeta();
        skullmeta.setOwningPlayer((OfflinePlayer)player.getPlayer());
        skullmeta.setDisplayName(Color("&7Click here to reset your color."));
        ArrayList<String> skulllore = new ArrayList<>();
        playerHead.setItemMeta((ItemMeta)skullmeta);

        ItemStack[] menuItems = {fillerItem, fillerItem, fillerItem, fillerItem, fillerItem, fillerItem,fillerItem,fillerItem,fillerItem
                ,fillerItem,fillerItem,fillerItem,colorItem,fillerItem,specialItem,fillerItem,fillerItem,
                fillerItem,fillerItem,fillerItem,fillerItem,fillerItem,fillerItem,fillerItem,fillerItem,playerHead};

        MainGUI.setContents(menuItems);

        player.openInventory(MainGUI);

        return MainGUI;
    }

    private String Color(String s){
        s = org.bukkit.ChatColor.translateAlternateColorCodes('&', s);
        return s;
    }

    private static final Pattern HEX_PATTERN = Pattern.compile("&(#\\w{6})");

    public static String Hex(String message) {
        Matcher matcher = HEX_PATTERN.matcher(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', message));
        StringBuffer buffer = new StringBuffer();

        while (matcher.find()) {
            matcher.appendReplacement(buffer, net.md_5.bungee.api.ChatColor.of(matcher.group(1)).toString());
        }

        return matcher.appendTail(buffer).toString();
    }
}
