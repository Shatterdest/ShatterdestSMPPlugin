package io.github.shatterdest.enablemsg;

import org.bukkit.plugin.java.JavaPlugin;

import io.github.shatterdest.commands.CommandWitheredBomb;

public final class Class extends JavaPlugin {
    @Override
    public void onEnable() {
    	getLogger().info("Shatterdest's Plugin has been Enabled!");
		this.getCommand("WitheredBomb").setExecutor(new CommandWitheredBomb());
    }
    
    @Override
    public void onDisable() {
    	getLogger().info("Shatterdest's Plugin has been Disabled!");
    }
}