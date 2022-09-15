package me.emre.elitechat.Guis;

import me.emre.elitechat.EliteChat;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class colorsGUI {

    private final EliteChat plugin;
    public colorsGUI(EliteChat plugin){
        this.plugin = plugin;
    }

    public Inventory colorGUI(Player player){

        String fillerItem2 = plugin.getConfig().getString("GUI.Settings.Items.Filler");
        String guiTitle = "&fᆟெ";
        String guiType = plugin.getConfig().getString("GUI.Settings.Items.Colors.Type");

        Inventory colorsGUI = Bukkit.createInventory((InventoryHolder)player, 54, org.bukkit.ChatColor.translateAlternateColorCodes('&', guiTitle));

        ItemStack fillerItem = new ItemStack(Material.valueOf(fillerItem2), 1);
        ItemStack backButton = new ItemStack(Material.PAPER, 1);
        ItemStack verydarkblue = null;
        ItemStack darkblue = null;
        ItemStack darkgreen = null;
        ItemStack darkgray = null;
        ItemStack darkred = null;
        ItemStack limeblack = null;
        ItemStack cyan = null;
        ItemStack purple = null;
        ItemStack gold = null;
        ItemStack gray = null;
        ItemStack blue = null;
        ItemStack black = null;
        ItemStack lime = null;
        ItemStack aqua = null;
        ItemStack pink = null;
        ItemStack yellow = null;
        ItemStack red = null;
        ItemStack white = null;

        if (guiType.equalsIgnoreCase("Dye")){
            darkblue = new ItemStack(Material.LAPIS_LAZULI, 1);
            darkgreen = new ItemStack(Material.GREEN_DYE, 1);
            cyan = new ItemStack(Material.CYAN_DYE, 1);
            purple = new ItemStack(Material.PURPLE_DYE, 1);
            gold = new ItemStack(Material.ORANGE_DYE, 1);
            gray = new ItemStack(Material.LIGHT_GRAY_DYE, 1);
            darkgray = new ItemStack(Material.GRAY_DYE, 1);
            blue = new ItemStack(Material.BLUE_DYE, 1);
            black = new ItemStack(Material.BLACK_DYE, 1);
            lime = new ItemStack(Material.LIME_DYE, 1);
            aqua = new ItemStack(Material.LIGHT_BLUE_DYE);
            pink = new ItemStack(Material.MAGENTA_DYE, 1);
            yellow = new ItemStack(Material.YELLOW_DYE, 1);
            white = new ItemStack(Material.WHITE_DYE, 1);

        }else if (guiType.equalsIgnoreCase("Concrete")){

            darkblue = new ItemStack(Material.BLUE_CONCRETE_POWDER, 1);
            darkgreen = new ItemStack(Material.GREEN_CONCRETE, 1);
            cyan = new ItemStack(Material.CYAN_CONCRETE, 1);
            purple = new ItemStack(Material.PURPLE_CONCRETE, 1);
            gold = new ItemStack(Material.ORANGE_CONCRETE, 1);
            gray = new ItemStack(Material.LIGHT_GRAY_CONCRETE, 1);
            darkgray = new ItemStack(Material.GRAY_CONCRETE, 1);
            blue = new ItemStack(Material.BLUE_CONCRETE, 1);
            black = new ItemStack(Material.BLACK_CONCRETE, 1);
            lime = new ItemStack(Material.LIME_CONCRETE, 1);
            aqua = new ItemStack(Material.LIGHT_BLUE_CONCRETE);
            pink = new ItemStack(Material.MAGENTA_CONCRETE, 1);
            yellow = new ItemStack(Material.YELLOW_CONCRETE, 1);
            white = new ItemStack(Material.WHITE_CONCRETE, 1);
            red = new ItemStack(Material.RED_CONCRETE, 1);
            darkred = new ItemStack(Material.RED_CONCRETE, 1);
            limeblack = new ItemStack(Material.BLACK_CONCRETE, 1);
            verydarkblue = new ItemStack(Material.BLUE_CONCRETE, 1);
        }else if (guiType.equalsIgnoreCase("Wool")){

            darkblue = new ItemStack(Material.BLUE_BED, 1);
            darkgreen = new ItemStack(Material.GREEN_WOOL, 1);
            cyan = new ItemStack(Material.CYAN_WOOL, 1);
            purple = new ItemStack(Material.PURPLE_WOOL, 1);
            gold = new ItemStack(Material.ORANGE_WOOL, 1);
            gray = new ItemStack(Material.LIGHT_GRAY_WOOL, 1);
            darkgray = new ItemStack(Material.GRAY_WOOL, 1);
            blue = new ItemStack(Material.BLUE_WOOL, 1);
            black = new ItemStack(Material.BLACK_WOOL, 1);
            lime = new ItemStack(Material.LIME_WOOL, 1);
            aqua = new ItemStack(Material.LIGHT_BLUE_WOOL);
            pink = new ItemStack(Material.MAGENTA_WOOL, 1);
            yellow = new ItemStack(Material.YELLOW_WOOL, 1);
            white = new ItemStack(Material.WHITE_WOOL, 1);
        }else if (guiType.equalsIgnoreCase("Texture")){

            darkblue = new ItemStack(Material.PAPER, 1);
            darkgreen = new ItemStack(Material.PAPER, 1);
            cyan = new ItemStack(Material.PAPER, 1);
            purple = new ItemStack(Material.PAPER, 1);
            gold = new ItemStack(Material.PAPER, 1);
            gray = new ItemStack(Material.PAPER, 1);
            darkgray = new ItemStack(Material.PAPER, 1);
            blue = new ItemStack(Material.PAPER, 1);
            black = new ItemStack(Material.PAPER, 1);
            lime = new ItemStack(Material.PAPER, 1);
            aqua = new ItemStack(Material.PAPER, 1);
            pink = new ItemStack(Material.PAPER, 1);
            yellow = new ItemStack(Material.PAPER, 1);
            white = new ItemStack(Material.PAPER, 1);
            red = new ItemStack(Material.PAPER, 1);
            darkred = new ItemStack(Material.PAPER, 1);
            limeblack = new ItemStack(Material.PAPER, 1);
            verydarkblue = new ItemStack(Material.PAPER, 1);
        }



        ItemMeta filleritem = fillerItem.getItemMeta();
        filleritem.setCustomModelData(3162);
        filleritem.setDisplayName(Color("&7"));
        filleritem.setUnbreakable(true);
        fillerItem.setItemMeta(filleritem);

        ItemMeta backmeta = backButton.getItemMeta();
        backmeta.setCustomModelData(6231);
        backmeta.setDisplayName(Color(Hex("&8Back to menu.")));
        backButton.setItemMeta(backmeta);


        ItemMeta dbm = darkblue.getItemMeta();
        dbm.setCustomModelData(3162);
        dbm.setDisplayName(Color(Hex("&1Dark Blue. &7(1)")));
        ArrayList<String> dbl = new ArrayList<>();
        dbl.add(Color(Hex("&eset your color to &1this.")));
        dbm.setLore(dbl);
        darkblue.setItemMeta(dbm);

        ItemMeta dgm = darkgreen.getItemMeta();
        dgm.setCustomModelData(3162);
        dgm.setDisplayName(Color(Hex("&2Dark Green. &7(2)")));
        ArrayList<String> dgl = new ArrayList<>();
        dgl.add(Color(Hex("&eset your color to &2this.")));
        dgm.setLore(dgl);
        darkgreen.setItemMeta(dgm);

        ItemMeta cm = cyan.getItemMeta();
        cm.setCustomModelData(3162);
        cm.setDisplayName(Color(Hex("&3Cyan. &7(3)")));
        ArrayList<String> cl = new ArrayList<>();
        cl.add(Hex(Color("&eset your color to &3this.")));
        cm.setLore(cl);
        cyan.setItemMeta(cm);

        ItemMeta pm = purple.getItemMeta();
        pm.setCustomModelData(3162);
        pm.setDisplayName(Color(Hex("&5Purple. &7(5)")));
        ArrayList<String> pl = new ArrayList<>();
        pl.add(Color(Hex("&eset your color to &5this.")));
        pm.setLore(pl);
        purple.setItemMeta(pm);

        ItemMeta gm = gold.getItemMeta();
        gm.setCustomModelData(3162);
        gm.setDisplayName(Color(Hex("&6Gold. &7(6)")));
        ArrayList<String> gl = new ArrayList<>();
        gl.add(Color(Hex("&eset your color to &6this.")));
        gm.setLore(gl);
        gold.setItemMeta(gm);

        ItemMeta lgm = gray.getItemMeta();
        lgm.setCustomModelData(3162);
        lgm.setDisplayName(Color(Hex("&7Gray. &7(7)")));
        ArrayList<String> lgl = new ArrayList<>();
        lgl.add(Color(Hex("&eset your color to &7this.")));
        lgm.setLore(lgl);
        gray.setItemMeta(lgm);

        ItemMeta ddgm = darkgray.getItemMeta();
        ddgm.setCustomModelData(3162);
        ddgm.setDisplayName(Color(Hex("&8Dark Gray. &7(8)")));
        ArrayList<String> dggl = new ArrayList<>();
        dggl.add(Color(Hex("&eset your color to &7this.")));
        ddgm.setLore(dggl);
        darkgray.setItemMeta(ddgm);

        ItemMeta bm = blue.getItemMeta();
        bm.setCustomModelData(3162);
        bm.setDisplayName(Color(Hex("&9Blue. &7(9)")));
        ArrayList<String> bl = new ArrayList<>();
        bl.add(Color(Hex("&eset your color to &9this.")));
        bm.setLore(bl);
        blue.setItemMeta(bm);

        ItemMeta blackm = black.getItemMeta();
        blackm.setCustomModelData(3162);
        blackm.setDisplayName(Color(Hex("&0Black. &7(0)")));
        ArrayList<String> blackl = new ArrayList<>();
        blackl.add(Color(Hex("&eset your color to &0this.")));
        blackm.setLore(blackl);
        black.setItemMeta(blackm);

        ItemMeta lm = lime.getItemMeta();
        lm.setCustomModelData(3162);
        lm.setDisplayName(Color(Hex("&aLime. &7(a)")));
        ArrayList<String> ll = new ArrayList<>();
        ll.add(Hex(Color("&eset your color to &athis.")));
        lm.setLore(ll);
        lime.setItemMeta(lm);

        ItemMeta am = aqua.getItemMeta();
        am.setCustomModelData(3162);
        am.setDisplayName(Color(Hex("&bAqua. &7(b)")));
        ArrayList<String> al = new ArrayList<>();
        al.add(Hex(Color("&eset your color to &bthis.")));
        am.setLore(al);
        aqua.setItemMeta(am);

        ItemMeta lpm = pink.getItemMeta();
        lpm.setCustomModelData(3162);
        lpm.setDisplayName(Color(Hex("&dPink. &7(d)")));
        ArrayList<String> pll = new ArrayList<>();
        pll.add(Color(Hex("&eset your color to &dthis.")));
        lpm.setLore(pll);
        pink.setItemMeta(lpm);

        ItemMeta ym = yellow.getItemMeta();
        ym.setCustomModelData(3162);
        ym.setDisplayName(Color(Hex("&eYellow. &7(e)")));
        ArrayList<String> yl = new ArrayList<>();
        yl.add(Color(Hex("&eset your color to this.")));
        ym.setLore(yl);
        yellow.setItemMeta(ym);

        ItemMeta wm = white.getItemMeta();
        wm.setCustomModelData(3162);
        wm.setDisplayName(Color(Hex("&fWhite. &7(f)")));
        ArrayList<String> wl = new ArrayList<>();
        wl.add(Color(Hex("&eset your color to &fthis.")));
        wm.setLore(wl);
        white.setItemMeta(wm);

        ItemMeta rd = red.getItemMeta();
        rd.setCustomModelData(3162);
        rd.setDisplayName(Color(Hex("&cRed. &7(c)")));
        ArrayList<String> rl = new ArrayList<>();
        rl.add(Hex(Color("&eset your color to &cthis.")));
        rd.setLore(rl);
        red.setItemMeta(rd);

        ItemMeta darkrd = darkred.getItemMeta();
        darkrd.setCustomModelData(3162);
        darkrd.setDisplayName(Color(Hex("&4Dark Red. &7(4)")));
        ArrayList<String> darkrl = new ArrayList<>();
        darkrl.add(Hex(Color("&eset your color to &4this.")));
        darkrd.setLore(darkrl);
        darkred.setItemMeta(darkrd);

        ItemMeta limebk = limeblack.getItemMeta();
        limebk.setCustomModelData(3162);
        limebk.setDisplayName(Color(Hex("&0Black. &7(0)")));
        ArrayList<String> limebl = new ArrayList<>();
        limebl.add(Hex(Color("&eset your color to &0this.")));
        limebk.setLore(limebl);
        limeblack.setItemMeta(limebk);

        ItemMeta verydb = verydarkblue.getItemMeta();
        verydb.setCustomModelData(3162);
        verydb.setDisplayName(Color(Hex("&1Navy Blue. &7(1)")));
        ArrayList<String> verydl = new ArrayList<>();
        verydl.add(Hex(Color("&eset your color to &1this.")));
        verydb.setLore(al);
        verydarkblue.setItemMeta(verydb);

        ItemStack[] menuItems = {fillerItem,fillerItem,fillerItem,fillerItem,fillerItem,fillerItem,fillerItem,fillerItem,fillerItem,fillerItem,red,gold,yellow,darkgreen,
                                aqua,darkblue,purple,fillerItem,fillerItem,white,lime,pink,verydarkblue,cyan,darkgray,gray,fillerItem,fillerItem,darkred,fillerItem,
                                fillerItem,fillerItem,fillerItem,fillerItem,limeblack,fillerItem,fillerItem,backButton};

        colorsGUI.setContents(menuItems);

        player.openInventory(colorsGUI);


        return colorsGUI;

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
