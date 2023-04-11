package survivalutils.survivalutils.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import survivalutils.survivalutils.SurvivalUtils;

public class tntGrief implements Listener {

    @EventHandler
    public void onTntGrief(EntityExplodeEvent event){
        if(event.getEntityType() == EntityType.PRIMED_TNT || event.getEntityType() == EntityType.MINECART_TNT){
            if(!SurvivalUtils.config.getBoolean("allowTntGrief")){
                event.setCancelled(true);
                event.getLocation().createExplosion(0, false, false);
            }
        }
    }

}
