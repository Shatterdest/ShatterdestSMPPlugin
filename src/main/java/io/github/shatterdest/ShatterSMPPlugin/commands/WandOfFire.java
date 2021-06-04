package io.github.shatterdest.ShatterSMPPlugin.commands;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import io.github.shatterdest.ShatterSMPPlugin.Main;
import io.github.shatterdest.ShatterSMPPlugin.misc.Glow;
import org.bukkit.plugin.java.JavaPlugin;


public class WandOfFire implements CommandExecutor {
    // This method is called, when somebody uses our command
    public boolean onCommand(CommandSender sender, WandOfFire cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            // Create a new ItemStack (type: diamond)
            ItemStack tnt = new ItemStack(Material.TNT);

            // Give the player our items (comma-separated list of all ItemStack)
            player.getInventory().addItem(tnt);
            // Here we need to give items to our player
        }

        // If the player (or console) uses our command correct, we can return true
        return true;
    }

	@Override
	@EventHandler
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		// TODO Auto-generated method stub
	       if (sender instanceof Player) {
	            Player player = (Player) sender;

                ItemStack blaze_rod = new ItemStack(Material.BLAZE_ROD, 1);
	            
	            ItemMeta meta = blaze_rod.getItemMeta();
	            
	            ArrayList<String> lore = new ArrayList();
	            
	            lore.add("A wand of fire");
	            
	            meta.setLore(lore);
	            
	            meta.setDisplayName(ChatColor.RED + "Wand of Fire");
	            
	            blaze_rod.setItemMeta(meta);
	            
	            // Give the player our items (comma-separated list of all ItemStack)
	            player.getInventory().addItem(blaze_rod);
	            
	            sender.sendMessage(ChatColor.GREEN + "You have been given Wand of Fire!");
	            // Here we need to give items to our player
		return true;
	       }
		return false;
	}
}




