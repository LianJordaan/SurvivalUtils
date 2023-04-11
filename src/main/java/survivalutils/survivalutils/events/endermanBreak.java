package survivalutils.survivalutils.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.checkerframework.checker.units.qual.Prefix;
import survivalutils.survivalutils.SurvivalUtils;

public class endermanBreak implements Listener {

    //public endermanBreak(SurvivalUtils plugin) {
    //    Bukkit.getPluginManager().registerEvents(this, plugin);
    //}
    @EventHandler
    public void onEndermanBreak(EntityChangeBlockEvent event){
        if(event.getEntityType() == EntityType.ENDERMAN){
            if(!SurvivalUtils.config.getBoolean("allowEndermanBreak")){
                if(event.getTo() == Material.AIR){
                    event.setCancelled(true);
                }
            }
        }
    }

}
