package us.drome.CobraCTF;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class Configuration {
	private final CobraCTF plugin;
	
	//Settings Section
	public int MATCH_TIME;
	public int CAPTURE_WIN;
	public int MIN_PLAYERS;
	public int MAX_PLAYERS;
	public int RESPAWN_DELAY;
	public int FLAG_RESPAWN_DELAY;
	public int FLAG_AUTO_RETURN;
	
	//Announcements Section
	public String PRESTART;
	public String COUNTDOWN;
	public String MATCH_START;
	public String MATCH_HALF;
	public String MATCH_MIN;
	public String MATCH_END;
	public String MATCH_END_DRAW;
	public String FLAG_PICKUP;
	public String FLAG_DROP;
	public String FLAG_CAPTURE;
	public String FLAG_RETURN;
	public String FLAG_RETURN_AUTO;
	public String FLAG_RESPAWN;
	public String PLAYER_JOIN;
	public String PLAYER_LEAVE;
	
	//Teams Section
	public String TEAM_1;
	public ItemStack[] TEAM_1_ARMOR;
	public ItemStack[] TEAM_1_INVENTORY;
	public String TEAM_2;
	public ItemStack[] TEAM_2_ARMOR;
	public ItemStack[] TEAM_2_INVENTORY;
	
	public Configuration(CobraCTF instance) {
		plugin = instance;
	}
	
	public void save() {
		plugin.saveConfig();
	}
	
	public void load() {
		plugin.reloadConfig();
		
		MATCH_TIME = plugin.getConfig().getInt("settings.match-time",30);
		CAPTURE_WIN = plugin.getConfig().getInt("settings.capture-win",3);
		MIN_PLAYERS = plugin.getConfig().getInt("settings.min-players",6);
		MAX_PLAYERS = plugin.getConfig().getInt("settings.max-players",12);
		RESPAWN_DELAY = plugin.getConfig().getInt("settings.respawn-delay",10);
		FLAG_RESPAWN_DELAY = plugin.getConfig().getInt("settings.flag-respawn-delay",5);
		FLAG_AUTO_RETURN = plugin.getConfig().getInt("settings.flag-auto-return",30);
		
		PRESTART = plugin.getConfig().getString("announcements.prestart","A match of CTF is ready to begin. To get to the arena, use /ctf-tp");
		COUNTDOWN = plugin.getConfig().getString("announcements.countdown", "This match of CTF begins in 30 seconds! Use /ctf-tp to get to the arena!");
		MATCH_START = plugin.getConfig().getString("announcements.match-start", "$TEAM versus $TEAM begins NOW!");
		MATCH_HALF = plugin.getConfig().getString("announcements.match-half", "The match is half over! $TIME minutes to go!");
		MATCH_MIN = plugin.getConfig().getString("annoincements.match-min", "This match of CTF will end in one minute!");
		MATCH_END = plugin.getConfig().getString("announcements.match-end", "$TEAM has won this match of CTF! Score: $WIN to $LOSE");
		MATCH_END_DRAW = plugin.getConfig().getString("announcements.match-end-draw", "This match of CTF is a draw! Congrats to both teams!");
		FLAG_PICKUP = plugin.getConfig().getString("announcements.flag-pickup", "$PLAYER has taken $TEAM's flag!");
		FLAG_DROP = plugin.getConfig().getString("announcements.flag-drop", "The $TEAM's flag has been dropped!");
		FLAG_CAPTURE = plugin.getConfig().getString("announcements.flag-capture", "$TEAM's flag has been captured by $PLAYER!");
		FLAG_RETURN = plugin.getConfig().getString("announcements.flag-return", "$TEAM's flag has been returned by $PLAYER!");
		FLAG_RETURN_AUTO = plugin.getConfig().getString("announcements.flag-return-auto", "$TEAMS's flag has been returned!");
		FLAG_RESPAWN = plugin.getConfig().getString("announcements.flag-respawn", "The flags have respawned!");
		PLAYER_JOIN = plugin.getConfig().getString("announcements.player-join", "$PLAYER has joined the match on $TEAM!");
		PLAYER_LEAVE = plugin.getConfig().getString("announcements.player-leave", "$PLAYER of $TEAM has left the match!");
		
		TEAM_1 = plugin.getConfig().getString("teams.team-1", "Blue Team");
		TEAM_1_ARMOR = getArmor("teams.team-1");
	}
	
	public ItemStack[] getArmor(String team) {
		ItemStack[] armor = new ItemStack[4];
		
		for (ItemStack piece : armor) {
			piece = new ItemStack(Material.matchMaterial(plugin.getConfig().getString(team + ".armor.chest").split(":")[0]));
			LeatherArmorMeta armorMeta = (LeatherArmorMeta) piece.getItemMeta();
			//armorMeta.setColor(plugin.getConfig().getString(team + ".armor.chest").split(":")[1]);
		}
		
		return armor;
	}
}
