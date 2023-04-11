package survivalutils.survivalutils;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import survivalutils.survivalutils.events.endermanBreak;
import survivalutils.survivalutils.events.endermanPlace;
import survivalutils.survivalutils.events.creeperGrief;
import survivalutils.survivalutils.events.creeperDamage;
import survivalutils.survivalutils.events.tntGrief;
import survivalutils.survivalutils.events.tntDamage;
import survivalutils.survivalutils.events.blockTrampling;


import java.io.File;
import java.util.Objects;

public final class SurvivalUtils extends JavaPlugin {

    public static FileConfiguration config;

    public static File cfile;
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new endermanPlace(), this);
        getServer().getPluginManager().registerEvents(new endermanBreak(), this);
        getServer().getPluginManager().registerEvents(new creeperGrief(), this);
        getServer().getPluginManager().registerEvents(new creeperDamage(), this);
        getServer().getPluginManager().registerEvents(new tntGrief(), this);
        getServer().getPluginManager().registerEvents(new tntDamage(), this);
        getServer().getPluginManager().registerEvents(new blockTrampling(), this);
        config = getConfig();
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        cfile = new File(getDataFolder(), "config.yml");

    }

    public static String Prefix = ChatColor.DARK_AQUA + "SurvivalUtils » " + ChatColor.RESET;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String lable, String[] args) {

        if(command.getName().equals("survivalutils")){
            if(args.length != 0) {
                Player player = (Player) sender;

                if (Objects.equals(args[0], "reload")) {
                    config = YamlConfiguration.loadConfiguration(cfile);
                    player.sendMessage(Prefix + ChatColor.GOLD + "Config Reloaded.");

                }
                //else if (Objects.equals(args[0], "food")) {
                //    String food = config.getString("Food");
                //    player.sendMessage(Prefix + ChatColor.BLUE + "The food in the config is " + ChatColor.RED + food);
                //
                //}
            }
        }

        return true;
    }
}
