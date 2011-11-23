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
    
    public int CheckEnds(int[][][] ids, int m){
        
        if (ids[0][0][1] == m && ids[2][0][1] == m && ids[0][2][1] == m && ids[2][2][1] == m && ids[1][2][1] == m){
            
            if (ids[0][0][0] == 50 && ids[2][0][0] == 50 && ids[0][2][0] == 50 && ids[2][2][0] == 50) return 1;
            if (ids[0][0][2] == 50 && ids[2][0][2] == 50 && ids[0][2][2] == 50 && ids[2][2][2] == 50) return 2;
            
        }
        if (ids[1][0][0] == m && ids[1][0][2] == m && ids[1][2][0] == m && ids[1][2][2] == m && ids[1][2][1] == m){
        
            if (ids[0][0][0] == 50 && ids[0][0][2] == 50 && ids[0][2][0] == 50 && ids[0][2][2] == 50) return 3;
            if (ids[2][0][0] == 50 && ids[2][0][2] == 50 && ids[2][2][0] == 50 && ids[2][2][2] == 50) return 4;
        
        }
        return 0;
    
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
        
        int m = bID[1][0][1];
        if (isValidBlockType(m)==false) return;
        int c = CheckEnds(bID, m);
        if (c==0) return;
        
        if (c<=2) {
            
            if (bID[0][1][1] == m && bID[2][1][1] == m){
                
                plugin.getServer().broadcastMessage("Shrine created");
                return;
                 
            }
            
        }
        
        if (c>=3) {
            
            if (bID[1][1][0] == m && bID[1][1][2] == m){
                
                plugin.getServer().broadcastMessage("Shrine created");
                return;
                 
            }
            
        }
        
        
        plugin.getServer().broadcastMessage("torch!");
        return;
    
    }
    
}
