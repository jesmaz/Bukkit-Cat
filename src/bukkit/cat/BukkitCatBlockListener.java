/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bukkit.cat;

import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.BlockListener;

/**
 *
 * @author Jesse
 */
public class BukkitCatBlockListener extends BlockListener {
    
    public BukkitCat plugin;
    
    public BukkitCatBlockListener(BukkitCat instance){
        
        plugin = instance;
        
    }
    
    public void onBlockPlace(BlockPlaceEvent event){
    
        if (event.getBlock().getTypeId() != 50) return;
        
        plugin.getServer().broadcastMessage("torch!");
        return;
    
    }
    
}
