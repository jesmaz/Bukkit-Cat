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
import java.util.List;

/**
 *
 * @author Jesse
 */
public final class BukkitCatSettings{
    
    int MaxShrines = 512;
    boolean blocksInvalid[] = new boolean[128];
    
    public BukkitCatSettings(BukkitCat plugin){
       
        plugin.getConfig();
        plugin.getConfig().options().copyDefaults(true);
        MaxShrines = plugin.getConfig().getInt("maxshrines");
        List<Integer> validblocks = plugin.getConfig().getIntegerList("validblocks");
        plugin.saveConfig();
        
        for (int i=0; i<validblocks.size(); i++) blocksInvalid[validblocks.get(i)] = false;
        
    }
    
    public Shrine[] LoadShrines() throws FileNotFoundException, IOException{
        
        int length = 16 * MaxShrines;
        ByteBuffer bb = ByteBuffer.allocateDirect(length);
        File in = new File("plugins/shrines.dat");
        Shrine s[] = new Shrine[MaxShrines];
        
        if (!in.isFile()){
            
            for (int i=0; i<s.length; i++) s[i] = new Shrine(0, 0, 0, (byte)0, (byte)0);
            return s;
            
        }
        
        FileInputStream FIS = new FileInputStream(in);
        byte b;
        
        for (int i=0; i<length; i++){
            
            b = 0;
            if (FIS.available() != 0)b = (byte)FIS.read();
            bb.put(b);
            
        }
        
        bb.position(0);
        
        for (int i=0; i<MaxShrines; i++){
            
            s[i] = new Shrine(bb.getInt(), bb.getInt(), bb.getInt(), bb.get(), bb.get(), bb.get(), bb.get());
        
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
            bb.put(s[i].facing);
            bb.put(s[i].matirial);
            bb.put(s[i].filler1);
            bb.put(s[i].filler2);
        
        }
        
        for (int i=0; i < length; i++){
            
            FOS.write(bb.get(i));
            
        }
        
        FOS.close();
        return false;
        
    }
    
}
