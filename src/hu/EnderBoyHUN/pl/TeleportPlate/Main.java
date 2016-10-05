package hu.EnderBoyHUN.pl.TeleportPlate;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Code by / Kódot írta:
 * EnderBoyHUN
 * <p>
 * 2016.10.05.
 */

public class Main extends JavaPlugin {
	
	Lang lang;
	
	@Override
	public void onEnable() {
		
		getConfig().options().copyDefaults(true);
		this.saveConfig();
		
		
		
		lang = new Lang(getConfig());
		setupEvent();
		System.out.printf("§bThe Plugin starten");
	}
	
	
	void setupEvent(){
		getServer().getPluginManager().registerEvents(new MoveEvent(lang),this);
		getServer().getPluginManager().registerEvents(new CreateTeleporterEvent(lang),this);
	}
}
