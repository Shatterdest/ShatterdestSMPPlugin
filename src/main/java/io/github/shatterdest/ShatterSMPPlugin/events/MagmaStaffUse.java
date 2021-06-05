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
import org.bukkit.ChatColor;

public class MagmaStaffUse implements Listener {
@EventHandler
public void MagmaStaffUse(PlayerInteractEvent event) {
    Player player = (Player) event.getPlayer();


    final ItemStack item = event.getItem();{
    if (item == null) return;
    final ItemMeta meta = item.getItemMeta();
    if (meta == null) return;

        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (event.getItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "Magma Staff")) {
            	if (player.getItemInHand().getType().equals(Material.BLAZE_ROD)) {
            		Fireball f = player.launchProjectile(Fireball.class);
            		f.setIsIncendiary(false);
            		player.sendRawMessage(ChatColor.GREEN + "Used Magma Staff!");
            	
        	
            	}
        }

        }
}
    
}
}