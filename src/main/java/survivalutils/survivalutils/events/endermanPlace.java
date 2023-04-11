package survivalutils.survivalutils.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import survivalutils.survivalutils.SurvivalUtils;

public class endermanPlace implements Listener {

    //public endermanPlace(SurvivalUtils plugin) {
    //    Bukkit.getPluginManager().registerEvents(this, plugin);
    //}
    @EventHandler
    public void onEndermanPlace(EntityChangeBlockEvent event){
        if(event.getEntityType() == EntityType.ENDERMAN){
            if(!SurvivalUtils.config.getBoolean("allowEndermanPlace")){
                if(event.getTo() != Material.AIR){
                    event.setCancelled(true);
                }
            }
        }
    }

}
