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

public class tntDamage implements Listener {

    @EventHandler
    public void onTntDamagePlayer(EntityDamageByEntityEvent event){
        if(event.getEntityType() == EntityType.PLAYER){
            if(event.getDamager().getType() == EntityType.PRIMED_TNT || event.getDamager().getType() == EntityType.MINECART_TNT){
                if (!SurvivalUtils.config.getBoolean("allowTntDamagePlayer")) {
                    event.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void onTntDamageOther(EntityDamageByEntityEvent event){
        if(event.getEntityType() != EntityType.PLAYER){
            if(event.getDamager().getType() == EntityType.PRIMED_TNT || event.getDamager().getType() == EntityType.MINECART_TNT){
                if (!SurvivalUtils.config.getBoolean("allowTntDamageOther")) {
                    event.setCancelled(true);
                }
            }
        }
    }

}
