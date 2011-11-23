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
    
    public boolean isValidBlockType (int id){
        
        if (id == 5) return true;
        return false;
        
    }
    
    public void onBlockPlace(BlockPlaceEvent event){
    
        if (event.getBlock().getTypeId() != 50) return;
        
        int x = event.getBlock().getX(), y = event.getBlock().getY(), z = event.getBlock().getZ();
        int bID[][][] = new int[3][3][3];
        
        for (int ix=0; ix<3; ix++){
            
            for (int iy=0; iy<3; iy++){
                
                for (int iz=0; iz<3; iz++){
                    
                    bID[ix][iy][iz] = event.getBlock().getWorld().getBlockAt(x + (ix - 1), y + (iy - 1), z + (iz - 1)).getTypeId();
                    
                }
                
            }
        
        }
        
        if (isValidBlockType(bID[1][0][1])==false) return;
        
        
        plugin.getServer().broadcastMessage("torch!");
        return;
    
    }
    
}
