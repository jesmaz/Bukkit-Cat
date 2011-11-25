/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bukkit.cat;

/**
 *
 * @author Jesse
 */
public class Shrine {
    
    int x, y, z, facing;
    
    public Shrine(int lx, int ly, int lz, int f){
        
        x=lx; y=ly; z=lz; facing=f;;
        
    }
    
    public boolean active (){
        
        if (facing == 0) return false;
        return true;
        
    }
    
}
