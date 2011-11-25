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
    
    int x, y, z;
    byte facing, matirial, filler1=0, filler2=0;
    
    public Shrine(int lx, int ly, int lz, byte f, byte m){
        
        x=lx; y=ly; z=lz; facing=f; matirial=m;
        
    }
    
    public Shrine(int lx, int ly, int lz, byte f, byte m, byte f1, byte f2){
        
        x=lx; y=ly; z=lz; facing=f; matirial=m;
        
    }
    
    public boolean active (){
        
        if (facing == 0) return false;
        return true;
        
    }
    
}
