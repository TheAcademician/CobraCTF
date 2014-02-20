package us.drome.CobraCTF;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.plugin.java.JavaPlugin;

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
