/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bukkit.cat;

import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Jesse
 */
public class BukkitCat extends JavaPlugin {

    /**
     * @param args the command line arguments
     */
    
    Logger log = Logger.getLogger("Minecraft");
    
    public static void main(String[] args) {
    }

    @Override
    public void onDisable() {
        
        log.info(this + "is disabled");
        
    }

    @Override
    public void onEnable() {
        
        log.info(this + "is enabled");
        
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args)  {
    
        if (commandLabel.equalsIgnoreCase("hello")){
            
            getServer().broadcastMessage("hi");
            return true;
        
        }
        
        return true;
    
    }
    
}
