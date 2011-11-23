/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bukkit.cat;

import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerListener;

/**
 *
 * @author Jesse
 */
public class BukkitCatPlayerListener extends PlayerListener {
    
    public BukkitCat plugin;
    
    public BukkitCatPlayerListener(BukkitCat instance){
        
        plugin = instance;
        
    }
    
    public void onBlockPlace(BlockPlaceEvent event){
    
        if (event.getBlock().getTypeId() != 50) return;
        
        plugin.getServer().broadcastMessage("torch!");
        return;
    
    }
    
}
