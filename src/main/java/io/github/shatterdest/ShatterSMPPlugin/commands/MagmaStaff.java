package io.github.shatterdest.ShatterSMPPlugin.commands;

import java.util.ArrayList;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MagmaStaff implements CommandExecutor {
	// This method is called, when somebody uses our command
	public boolean onCommand(CommandSender sender, MagmaStaff cmd, String label, String[] args) {
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

			lore.add(ChatColor.DARK_RED + "A staff infused with the power of magma.");
			lore.add(ChatColor.DARK_RED,ChatColor.BOLD + "Warning: Can cause mass destruction.");

			meta.setLore(lore);

			meta.setDisplayName(ChatColor.RED + "Magma Staff");

			meta.addEnchant(Enchantment.LURE, 1, false);

			meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

			blaze_rod.setItemMeta(meta);

			// Give the player our items (comma-separated list of all ItemStack)
			player.getInventory().addItem(blaze_rod);

			sender.sendMessage(ChatColor.GREEN + "You have been given the " + ChatColor.RED + "Magma Staff" + ChatColor.GREEN + "!");
			// Here we need to give items to our player
			return true;
		}
		return false;
	}
}
