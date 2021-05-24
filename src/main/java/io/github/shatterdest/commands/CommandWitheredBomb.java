package io.github.shatterdest.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import net.md_5.bungee.api.chat.TextComponent;


public class CommandWitheredBomb implements CommandExecutor {

    // This method is called, when somebody uses our command
	public boolean onCommand(Player sender, CommandWitheredBomb command, String commandLabel, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            
            TextComponent message = new TextComponent( "Gave Withered Bomb!" );
            p.spigot().sendMessage(message); 
            if(!(sender instanceof Player)){
                Bukkit.getServer().getLogger().info("Error: This command can only be used by players!");
        }
		return true;
	}
        else;
		return false;



}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		// TODO Auto-generated method stub
		return false;
	}
}
