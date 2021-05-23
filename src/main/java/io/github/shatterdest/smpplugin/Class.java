package io.github.shatterdest.smpplugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class Class extends JavaPlugin {
    @Override
    public void onEnable() {
    	getLogger().info("Shatterdest's Plugin has been Enabled!");
    }
    
    @Override
    public void onDisable() {
    	getLogger().info("Shatterdest's Plugin has been Disabled!");
    }
}