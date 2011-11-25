/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bukkit.cat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 *
 * @author Jesse
 */
public class BukkitCatSettings {
    
    int MaxShrines = 16;
    
    public Shrine[] LoadShrines() throws FileNotFoundException, IOException{
        
        int length = 16 * MaxShrines;
        ByteBuffer bb = ByteBuffer.allocateDirect(length);
        File in = new File("plugins/shrines.dat");
        Shrine s[] = new Shrine[MaxShrines];
        
        if (!in.isFile()){
            
            for (int i=0; i<s.length; i++) s[i] = new Shrine(0, 0, 0, 0);
            return s;
            
        }
        
        FileInputStream FIS = new FileInputStream(in);
        
        for (int i=0; i<length; i++){
            
            bb.put((byte)FIS.read());
            
        }
        
        bb.position(0);
        
        for (int i=0; i<MaxShrines; i++){
            
            s[i] = new Shrine(bb.getInt(), bb.getInt(), bb.getInt(), bb.getInt());
        
        }
        
        return s;
        
    }
    
    public boolean SaveShrines(Shrine s[]) throws FileNotFoundException, IOException{
        
        int length = 16 * MaxShrines;
        ByteBuffer bb = ByteBuffer.allocateDirect(length);
        File out = new File("plugins/shrines.dat");
        FileOutputStream FOS = new FileOutputStream(out);
        
        for (int i=0; i<MaxShrines; i++){
            
            bb.putInt(s[i].x);
            bb.putInt(s[i].y);
            bb.putInt(s[i].z);
            bb.putInt(s[i].facing);
        
        }
        
        for (int i=0; i < length; i++){
            
            FOS.write(bb.get(i));
            
        }
        
        FOS.close();
        return false;
        
    }
    
}
