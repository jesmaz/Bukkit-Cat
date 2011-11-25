/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bukkit.cat;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.block.Block;


/**
 *
 * @author Jesse
 */
public class ShrineManager {
    
    Shrine shrine[];
    BukkitCat plugin;
    
    public ShrineManager(int max, BukkitCat instance) throws FileNotFoundException, IOException{
        
        shrine = new Shrine[max];
        plugin = instance;
        for (int i=0; i<shrine.length; i++) shrine[i] = new Shrine(0, 0, 0, 0);
        shrine = plugin.settings.LoadShrines();
        
    }
    
    public boolean addShrine (Shrine s){
        
        //plugin.getServer().broadcastMessage("s " + s.active);
        for (int i=0; i<shrine.length; i++){
            
            //plugin.getServer().broadcastMessage(i+" " + shrine[i].active);
            if (shrine[i].active()==false){
                
                shrine[i] = s;
                plugin.getServer().broadcastMessage(i+" " + shrine[i].active());
                try {
                    plugin.settings.SaveShrines(shrine);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ShrineManager.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ShrineManager.class.getName()).log(Level.SEVERE, null, ex);
                }
                return true;
                
            }
            
        }
        return false;
        
    }
    
    public boolean blickIsPartOfShrine(Block b){
        
        for (int i=0; i<shrine.length; i++){
            
            //plugin.getServer().broadcastMessage(i+" " + shrine[i].active);
            if (shrine[i].active()){
                
                if (b.getX() >= shrine[i].x-1 && b.getX() <= shrine[i].x+1 && b.getY() >= shrine[i].y-1 && b.getY() <= shrine[i].y+1 && b.getZ() >= shrine[i].z-1 && b.getZ() <= shrine[i].z+1){
                    
                    shrine[i].facing = 0;
                    return true;
                   
                }
                
            }
            
        }
        return false;
        
    }
    
    public void deactivateShrine(Shrine s){
        
        for (int i=0; i<shrine.length; i++){
            
            if (shrine[i] == s) shrine[i].facing = 0;
            
        }
        
    }
    
}
