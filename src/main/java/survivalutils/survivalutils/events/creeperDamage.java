package survivalutils.survivalutils.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import survivalutils.survivalutils.SurvivalUtils;

public class creeperDamage implements Listener {

    @EventHandler
    public void onCreeperDamagePlayer(EntityDamageByEntityEvent event){
        if(event.getEntityType() == EntityType.PLAYER){
            if(event.getDamager().getType() == EntityType.CREEPER) {
                if (!SurvivalUtils.config.getBoolean("allowCreeperDamagePlayer")) {
                    event.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void onCreeperDamageOther(EntityDamageByEntityEvent event){
        if(event.getEntityType() != EntityType.PLAYER){
            if(event.getDamager().getType() == EntityType.CREEPER) {
                if (!SurvivalUtils.config.getBoolean("allowCreeperDamageOther")) {
                    event.setCancelled(true);
                }
            }
        }
    }

}
