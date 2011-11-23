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
    boolean active;
    
    public Shrine(int lx, int ly, int lz, int f){
        
        x=lx; y=ly; z=lz; facing=f;
        active=true;
        
    }
    
}
