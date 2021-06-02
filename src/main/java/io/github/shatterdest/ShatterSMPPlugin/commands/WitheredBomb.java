package io.github.shatterdest.ShatterSMPPlugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import io.github.shatterdest.ShatterSMPPlugin.Main;


public class WitheredBomb implements CommandExecutor {
    // This method is called, when somebody uses our command
    public boolean onCommand(CommandSender sender, WitheredBomb cmd, String label, String[] args) {
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
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		// TODO Auto-generated method stub
	       if (sender instanceof Player) {
	            Player player = (Player) sender;

	            // Create a new ItemStack (type: brick)
	            ItemStack tnt = new ItemStack(Material.TNT);

	            // Set the amount of the ItemStack
	            tnt.setAmount(1);

	            // Give the player our items (comma-separated list of all ItemStack)
	            player.getInventory().addItem(tnt);
	            // Here we need to give items to our player
		return true;
	       }
		return false;
	}
}




