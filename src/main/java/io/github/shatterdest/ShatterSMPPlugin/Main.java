  
package io.github.shatterdest.ShatterSMPPlugin;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.shatterdest.ShatterSMPPlugin.commands.MagmaStaff;
import io.github.shatterdest.ShatterSMPPlugin.events.MagmaStaffUse;

public class Main extends JavaPlugin implements Listener {
    FileConfiguration config = getConfig();
    
    @Override
    public void onEnable() {
    	getLogger().info("Shatterdest's Plugin has been Enabled!");
		this.getCommand("MagmaStaff").setExecutor(new MagmaStaff());
        config.addDefault("Welcome msg", true);
        config.options().copyDefaults(true);
        saveConfig();
        getServer().getPluginManager().registerEvents(new MagmaStaffUse(), this);
    }
    
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (config.getBoolean("Welcome msg")) {
            player.sendMessage("Welcome to ShroomSMP!");
        } else {
            player.sendMessage("");
        }
    }
    
    @Override
    public void onDisable() {
    	getLogger().info("Shatterdest's Plugin has been Disabled!");
    }

}