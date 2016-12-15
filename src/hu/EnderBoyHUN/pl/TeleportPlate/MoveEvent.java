package hu.EnderBoyHUN.pl.TeleportPlate;

import org.bukkit.*;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

/**
 * Code by / Kódot írta:
 * EnderBoyHUN
 * <p>
 * 2016.10.05.
 */

public class MoveEvent implements Listener {
	
	Lang lang;
	
	public MoveEvent(Lang lang) {
		this.lang = lang;
	}
	
	@EventHandler
	public void onPlate(PlayerMoveEvent e)
	{
		if(e.getTo().getBlock().getType() == Material.IRON_PLATE)
		{
			if(e.getTo().getBlock().getRelative(BlockFace.DOWN, 2).getType() == Material.WALL_SIGN)
			{
				Sign sign = (Sign)e.getTo().getBlock().getRelative(BlockFace.DOWN, 2).getState();
				
				if(sign.getLines()[0].equalsIgnoreCase("[TP]"))
				{
					String[] tpinfo = sign.getLines()[1].split(" ");
					String tpWorldInfo = sign.getLines()[2];
					
					int tp_x, tp_y, tp_z, tp_Yaw, tp_Pitch;
					
					try {
						tp_x = Integer.parseInt(tpinfo[0]);
						tp_y = Integer.parseInt(tpinfo[1]);
						tp_z = Integer.parseInt(tpinfo[2]);
						
						tp_Yaw = (int)e.getPlayer().getLocation().getYaw();
						tp_Pitch = (int) e.getPlayer().getLocation().getPitch();
						
						World w;
						
						if(!tpWorldInfo.equalsIgnoreCase("")) {
							
							if (Bukkit.getServer().getWorld(tpWorldInfo) != null) {
								w = Bukkit.getServer().getWorld(tpWorldInfo);
							}
							else w = e.getPlayer().getWorld();
						}
						else{
							w = e.getPlayer().getWorld();
						}
						
						Location l = new Location(
								w,
								tp_x,tp_y,tp_z,
								tp_Yaw,
								tp_Pitch
						);
						
						
						
						e.getPlayer().teleport(l);
						e.getPlayer().playSound(l,Sound.ENTITY_ENDERMEN_TELEPORT,1,1);
						e.getPlayer().sendMessage( lang.successfulTeleport );
						
						
					} catch (Exception e2) {
						if(e.getPlayer().hasPermission("tpp.debug"))
						{
							e.getPlayer().sendMessage(ChatColor.RED + e2.getMessage());
						}
					}
				}
			}
		}
	}
	
	
}
