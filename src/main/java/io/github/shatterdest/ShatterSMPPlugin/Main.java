package io.github.shatterdest.ShatterSMPPlugin;

import java.lang.reflect.Field;

import org.bukkit.NamespacedKey;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.shatterdest.ShatterSMPPlugin.commands.WandOfFire;
import io.github.shatterdest.ShatterSMPPlugin.misc.Glow;

public class Main extends JavaPlugin implements Listener {
    FileConfiguration config = getConfig();
    
    @Override
    public void onEnable() {
    	getLogger().info("Shatterdest's Plugin has been Enabled!");
		this.getCommand("WandOfFire").setExecutor(new WandOfFire());
        config.addDefault("Welcome msg", true);
        config.options().copyDefaults(true);
        saveConfig();
        registerGlow();
        
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
    public void registerGlow() {
        try {
            Field f = Enchantment.class.getDeclaredField("acceptingNew");
            f.setAccessible(true);
            f.set(null, true);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        try {
         NamespacedKey key = new NamespacedKey(this, getDescription().getName());
           
            Glow glow = new Glow(key);
            Enchantment.registerEnchantment(glow);
        }
        catch (IllegalArgumentException e){
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}