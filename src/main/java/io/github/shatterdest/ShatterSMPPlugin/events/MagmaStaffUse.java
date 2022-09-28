package io.github.shatterdest.ShatterSMPPlugin.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;
import io.github.shatterdest.ShatterSMPPlugin.Main;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MagmaStaffUse implements Listener {

	public Map<UUID, Double> cooldowns = new HashMap<>();

	@EventHandler
	public void MagmaStaffUse(PlayerInteractEvent e) {

		Player player = e.getPlayer();
		final UUID uuid = e.getPlayer().getUniqueId();

		if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (e.getItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Magma Staff")) {
				if (player.getItemInHand().getType().equals(Material.BLAZE_ROD)) {
					if (cooldowns.containsKey(uuid)) {
						if (cooldowns.get(uuid) > 0) {
							int timeLeft = (int) (cooldowns.get(uuid) / 20);
							player.sendMessage(ChatColor.RED + "Ability is on cooldown for another " + timeLeft + ((timeLeft == 1) ? " second" : " seconds"));
						} else {
							Fireball f = player.launchProjectile(Fireball.class);
							f.setIsIncendiary(false);
							player.sendMessage(
									ChatColor.GREEN + "Used " + ChatColor.RED + "Fireball" + ChatColor.GREEN + "!");
							cooldowns.put(uuid, 2 * 20L);
						}
					} else {
						Fireball f = player.launchProjectile(Fireball.class);
						f.setIsIncendiary(false);
						player.sendMessage(
								ChatColor.GREEN + "Used " + ChatColor.RED + "Fireball" + ChatColor.GREEN + "!");
						cooldowns.put(uuid, 2 * 20L);
					}		new BukkitRunnable() {
						@Override
						public void run() {
							for (UUID uuid : cooldowns.keySet()) {
								if (cooldowns.get(uuid) > 0) {
									cooldowns.replace(uuid, cooldowns.get(uuid) - 1);
								}else {
									cooldowns.remove(uuid);
								}
							}
						}
					}.runTaskTimer(Main.getPlugin(Main.class), 0L, 1L);
					return;
				}
			}
		}
	}
}