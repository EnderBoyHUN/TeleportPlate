package hu.EnderBoyHUN.pl.TeleportPlate;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

/**
 * Code by / Kódot írta:
 * EnderBoyHUN
 * <p>
 * 2016.10.05.
 */

public class CreateTeleporterEvent implements Listener {
	
	Lang lang;
	
	public CreateTeleporterEvent(Lang lang) {
		this.lang = lang;
	}
	
	
	@EventHandler
	public void onSingCreate(SignChangeEvent e){
		String[] lines = e.getLines();
		
		if(lines[0].equalsIgnoreCase("[TP]")){
			if(!(e.getPlayer().hasPermission("tpp.create") || e.getPlayer().isOp())){
				e.setCancelled(true);
				e.getPlayer().sendMessage( lang.noPermission  );   ////
				return;
			}
			else{
				
				String[] coorString = e.getLines()[1].split(" ");
				if(coorString.length != 3){
					e.setCancelled(true);
					e.getPlayer().sendMessage( lang.badLength ); ////
					return;
				}
				try{
					Integer.parseInt(coorString[0]);
					Integer.parseInt(coorString[1]);
					Integer.parseInt(coorString[2]);
				}
				catch(NumberFormatException er) {
					e.setCancelled(true);
					e.getPlayer().sendMessage(lang.noNummer); ////
					return;
				}
				
				if(!lines[2].equalsIgnoreCase("")){
					
					if(Bukkit.getServer().getWorld(lines[2]) == null)
					{
						e.setCancelled(true);
						e.getPlayer().sendMessage(lang.noExistsWorld); ////
						return;
					}
				}
			}
		}
	}
}
