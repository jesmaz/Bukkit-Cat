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
    
    public void addShrine (Shrine s){
        
        for (int i=0; i<shrine.length; i++){
            
            if (!shrine[i].active){
                
                shrine[i] = s;
                return;
                
            }
            
        }
        
        Shrine temp[] = new Shrine[shrine.length + 1];
        for (int i=0; i<shrine.length; i++) temp[i] = shrine[i];
        temp[shrine.length] = s;
        shrine = temp;
        
    }
    
    public boolean blickIsPartOfShrine(Block b){
        
        for (int i=0; i<shrine.length; i++){
            
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
