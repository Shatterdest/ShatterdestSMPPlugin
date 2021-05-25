package io.github.shatterdest.enablemsg;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.shatterdest.commands.CommandWitheredBomb;

public final class Class extends JavaPlugin implements Listener {
    FileConfiguration config = getConfig();
    
    @Override
    public void onEnable() {
    	getLogger().info("Shatterdest's Plugin has been Enabled!");
		this.getCommand("WitheredBomb").setExecutor(new CommandWitheredBomb());
        config.addDefault("Welcome msg", true);
        config.options().copyDefaults(true);
        saveConfig();
        
        getServer().getPluginManager().registerEvents(this, this);
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