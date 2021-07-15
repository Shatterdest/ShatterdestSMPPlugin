package io.github.shatterdest.ShatterSMPPlugin.events;

import org.bukkit.Material;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.UUID;
import org.bukkit.ChatColor;

public class MagmaStaffUse implements Listener {


	@EventHandler
	public void MagmaStaffUse(PlayerInteractEvent e) {
		Player player = (Player) e.getPlayer();
		  final UUID u = e.getPlayer().getUniqueId();
			if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				if (e.getItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Magma Staff")) {
					if (player.getItemInHand().getType().equals(Material.BLAZE_ROD)) {
							}  
								Fireball f = player.launchProjectile(Fireball.class);
								f.setIsIncendiary(false);
								player.sendMessage(
										ChatColor.GREEN + "Used " + ChatColor.RED + "Fireball" + ChatColor.GREEN + "!");

							
						}	
					}				
				}
			



}
    



