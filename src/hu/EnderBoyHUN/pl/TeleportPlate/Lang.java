package hu.EnderBoyHUN.pl.TeleportPlate;

import org.bukkit.configuration.Configuration;

/**
 * Code by / Kódot írta:
 * EnderBoyHUN
 * <p>
 * 2016.10.05.
 */

public class Lang {
	
	public String successfulTeleport, noPermission, badLength, noNummer, noExistsWorld;
	
	public Lang(Configuration conf) {
		switch (conf.getString("lang"))
		{
			case "hu":
				successfulTeleport = "§aTeleportálás...";
				noPermission = "§cNincs jogod létrehozni a TeleportPlate-t";
				badLength = "§cKevés vagy sok szám van a második sorban. (3)";
				noNummer = "§cEz nem szám.";
				noExistsWorld = "§cEz a világ nem létezik.";
				break;
			case "en":
				successfulTeleport = "§aTeleporting...";
				noPermission = "§cNo permission for create TeleportPlate";
				badLength = "§cFew or many Number in second line (3)";
				noNummer = "§cThis no Number.";
				noExistsWorld = "§cThis world does not exist.";
				break;
			case "de":
				successfulTeleport = "§aTeleportiere...";
				noPermission = "§cDir ist nicht Befugnis, dass du TeleportPlate erzeugst.";
				badLength = "§cWenig or viel Zahlen sien in zweite Verflog (3)";
				noNummer = "§cEs nicht Zahl(en)";
				noExistsWorld = "§cDiese Welt nicht existieren.";
				break;
			case "custom":
				successfulTeleport = conf.getString("customLang.successfulTeleport");
				noPermission = conf.getString("customLang.noPermission");
				badLength = conf.getString("customLang.badLength");
				noNummer = conf.getString("customLang.noNummer");
				noExistsWorld = conf.getString("customLang.noExistsWorld");
				break;
		}
	}
}
