package me.emre.elitechat;

import me.emre.elitechat.Commands.adminCommands;
import me.emre.elitechat.Commands.playerCommands;
import me.emre.elitechat.Guis.colorsGUI;
import me.emre.elitechat.Guis.guiCommands.colorGUICommands;
import me.emre.elitechat.Guis.mainGUI;
import me.emre.elitechat.Guis.specialGUI;
import me.emre.elitechat.Guis.staffGUI;
import me.emre.elitechat.Listeners.chatlistener;
import me.emre.elitechat.Listeners.permissionsCheck;
import me.emre.elitechat.database.databaseConnection;
import me.emre.elitechat.database.databaseQueries;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class EliteChat extends JavaPlugin implements Listener {

    public databaseConnection DB;
    public databaseQueries DBQ;
    public mainGUI mGUI;
    public permissionsCheck pmc;
    public colorsGUI cGUI;
    public staffGUI sGUI;
    public specialGUI specgui;




    @Override
    public void onEnable() {
        config();
        commands();
        listeners();
        this.DB = new databaseConnection();
        this.DBQ = new databaseQueries(this);
        this.mGUI = new mainGUI(this);
        this.cGUI = new colorsGUI(this);
        this.pmc = new permissionsCheck(this);
        this.sGUI = new staffGUI(this);
        this.specgui = new specialGUI(this);
        startup();
        try {
            DB.connect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (DB.isConnected()) {
            try {
                DBQ.createTable();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void commands(){
        getCommand("chatcolor").setExecutor(new playerCommands(this));
        getCommand("achatcolor").setExecutor(new adminCommands(this));
    }

    public void listeners(){
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new chatlistener(this), this);
        getServer().getPluginManager().registerEvents(new colorGUICommands(this), this);
    }

    public void startup(){
        getLogger().info(Color("[EliteChat] Plugin started up."));
    }

    public void config(){
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        reloadConfig();
    }

    @Override
    public void onDisable() {
        DB.disconnect();
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) throws SQLException{
        Player player = e.getPlayer();
        DBQ.createPlayer(player);
        PreparedStatement colorcheck = DB.getConnection().prepareStatement("SELECT color FROM chatcolor WHERE playerUUID=?");
        colorcheck.setString(1, player.getUniqueId().toString());
        ResultSet colorcheckrs = colorcheck.executeQuery();
        String color = null;
        if (colorcheckrs.next()){
            color = colorcheckrs.getString("color");
        }
        String message = Color(Hex(getConfig().getString("Plugin.Prefix") + " " + "&7Your current chatcolor is %color%this&7."));
        message = message.replace("%color%", color);
        player.sendMessage(Hex(Color(message)));
    }

    private String Color(String s){
        s = ChatColor.translateAlternateColorCodes('&', s);
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

