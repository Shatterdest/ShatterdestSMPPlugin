package io.github.shatterdest.ShatterSMPPlugin.commands;

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

import java.util.Arrays;

public class MagmaStaffCommand implements CommandExecutor {

	@Override
	@EventHandler
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Error: You are not a Player!");
			return true;
		}
		if (sender instanceof Player) {
			Player player = (Player) sender;
			ItemStack blaze_rod = new ItemStack(Material.BLAZE_ROD, 1);
			ItemMeta meta = blaze_rod.getItemMeta();
			meta.setLore(Arrays.asList("",ChatColor.DARK_RED + "A shattered staff infused with hot magma.","",ChatColor.GOLD.toString() + ChatColor.BOLD.toString() + "Ability: " + ChatColor.GOLD + "Fireball " + ChatColor.YELLOW + "[Right Click]",ChatColor.GRAY + "Shoot a fireball at the direction you are looking, dealing up to " + ChatColor.RED + "12.5 " + ChatColor.GRAY + "damage.",ChatColor.GRAY + "Cooldown: " + ChatColor.GREEN + "2s"));
			meta.setDisplayName(ChatColor.GOLD + "Magma Staff");
			meta.addEnchant(Enchantment.FIRE_ASPECT, 5, false);
			meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			blaze_rod.setItemMeta(meta);
			player.getInventory().addItem(blaze_rod);
			sender.sendMessage(ChatColor.GREEN + "You have been given the " + ChatColor.GOLD.toString() + ChatColor.BOLD.toString() + "Magma Staff" + ChatColor.GREEN + "!");
			return true;
		}
		return false;
	}
}