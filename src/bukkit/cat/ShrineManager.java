/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bukkit.cat;

import org.bukkit.block.Block;


/**
 *
 * @author Jesse
 */
public class ShrineManager {
    
    Shrine shrine[];
    BukkitCat plugin;
    
    public ShrineManager(int max, BukkitCat instance){
        
        shrine = new Shrine[max];
        plugin = instance;
        for (int i=0; i<shrine.length; i++) shrine[i] = new Shrine(0, 0, 0, 0, false);
        
    }
    
    public boolean addShrine (Shrine s){
        
        //plugin.getServer().broadcastMessage("s " + s.active);
        for (int i=0; i<shrine.length; i++){
            
            //plugin.getServer().broadcastMessage(i+" " + shrine[i].active);
            if (shrine[i].active==false){
                
                shrine[i] = s;
                plugin.getServer().broadcastMessage(i+" " + shrine[i].active);
                return true;
                
            }
            
        }
        return false;
        
    }
    
    public boolean blickIsPartOfShrine(Block b){
        
        for (int i=0; i<shrine.length; i++){
            
            //plugin.getServer().broadcastMessage(i+" " + shrine[i].active);
            if (shrine[i].active){
                
                if (b.getX() >= shrine[i].x-1 && b.getX() <= shrine[i].x+1 && b.getY() >= shrine[i].y-1 && b.getY() <= shrine[i].y+1 && b.getZ() >= shrine[i].z-1 && b.getZ() <= shrine[i].z+1){
                    
                    shrine[i].active = false;
                    return true;
                   
                }
                
            }
            
        }
        return false;
        
    }
    
    public void deactivateShrine(Shrine s){
        
        for (int i=0; i<shrine.length; i++){
            
            if (shrine[i] == s) shrine[i].active = false;
            
        }
        
    }
    
}
