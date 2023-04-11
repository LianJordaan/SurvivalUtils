package survivalutils.survivalutils.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import survivalutils.survivalutils.SurvivalUtils;

public class creeperGrief implements Listener {

    @EventHandler
    public void onCreeperGrief(EntityExplodeEvent event){
        if(event.getEntityType() == EntityType.CREEPER){
            if(!SurvivalUtils.config.getBoolean("allowCreeperGrief")){
                 event.setCancelled(true);
                 event.getLocation().createExplosion(0, false, false);
            }
        }
    }

}
