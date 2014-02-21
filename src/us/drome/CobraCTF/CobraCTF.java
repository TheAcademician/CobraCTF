package us.drome.CobraCTF;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

public class CobraCTF extends JavaPlugin {
	public void onEnable() {
		getLogger().info(" version:" + getDescription().getVersion() + " is loading...");
	}
	
	public void onDisable() {
		getLogger().info(" version:" + getDescription().getVersion() + " has unloaded.");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		return false;
	}
}
