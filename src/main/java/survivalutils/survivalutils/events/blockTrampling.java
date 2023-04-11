package survivalutils.survivalutils.events;

import jdk.javadoc.internal.doclint.HtmlTag;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Ageable;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockFadeEvent;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import survivalutils.survivalutils.SurvivalUtils;

import java.util.Objects;

public class blockTrampling implements Listener {

    @EventHandler
    public void onCropTrampleGrief(EntityInteractEvent event){
        if(event.getBlock().getType() == Material.FARMLAND) {
            if (event.getEntityType() != EntityType.PLAYER) {
                if (!SurvivalUtils.config.getBoolean("allowOtherCropTrample")) {
                    event.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void onCropTrampleGrief(PlayerInteractEvent event){
        if (event.getAction() == Action.PHYSICAL) {
            if(Objects.requireNonNull(event.getClickedBlock()).getType() == Material.FARMLAND){
                if (!SurvivalUtils.config.getBoolean("allowPlayerCropTrample")) {
                    event.setCancelled(true);
                }
            }
        }
    }

}
