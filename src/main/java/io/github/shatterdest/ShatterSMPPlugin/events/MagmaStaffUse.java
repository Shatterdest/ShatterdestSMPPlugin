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

import java.util.HashMap;
import java.util.Map;

import org.bukkit.ChatColor;

public class MagmaStaffUse implements Listener {

	private Map<String, Long> cooldowns = new HashMap<String, Long>();

	@EventHandler
	public void MagmaStaffUse(PlayerInteractEvent event) {
		Player player = (Player) event.getPlayer();

		final ItemStack item = event.getItem();
		{
			if (item == null)
				return;
			final ItemMeta meta = item.getItemMeta();
			if (meta == null)
				return;
			if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
				if (event.getItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Magma Staff")) {
					if (player.getItemInHand().getType().equals(Material.BLAZE_ROD)) {
						if(cooldowns.containsKey(player.getName())) {
			                long sgs = ((cooldowns.get(player.getName()) / 1000) + 2) - (System.currentTimeMillis() / 1000);
			                if(sgs > 0) {
			                    player.sendMessage("&cYou must wait &7"+sgs+" &csecond(s).");
			                    return;
			                }
			}

							return;
						} else {
							cooldowns.remove(player.getName());
						}
					} else {
						cooldowns.put(player.getName(), System.currentTimeMillis() / 100 + 2);
						Fireball f = player.launchProjectile(Fireball.class);
						f.setIsIncendiary(false);
						player.sendMessage(
								ChatColor.GREEN + "Used " + ChatColor.RED + "Fireball" + ChatColor.GREEN + "!");
						
					}
				}

			}

		}

	}


