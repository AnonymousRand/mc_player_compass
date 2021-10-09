package AnonymousRand.PlayerCompass;

import net.minecraft.server.v1_16_R1.Item;
import net.minecraft.server.v1_16_R1.Items;
import org.bukkit.craftbukkit.v1_16_R1.entity.CraftItem;
import org.bukkit.craftbukkit.v1_16_R1.inventory.CraftItemStack;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

public class Listeners implements Listener {

    @EventHandler
    public void playerRespawn(PlayerRespawnEvent event) { //gives players a compass when they respawn
        org.bukkit.inventory.ItemStack i = CraftItemStack.asBukkitCopy(new net.minecraft.server.v1_16_R1.ItemStack(Items.COMPASS)); //convert nms itemstack to craftitemstack which is a subclass of bukkit itemstack
        event.getPlayer().getInventory().setItem(8, i);
    }

    @EventHandler
    public void playerJoin(PlayerJoinEvent event) { //gives players a compass when they join
        org.bukkit.inventory.ItemStack i = CraftItemStack.asBukkitCopy(new net.minecraft.server.v1_16_R1.ItemStack(Items.COMPASS)); //convert nms itemstack to craftitemstack which is a subclass of bukkit itemstack
        event.getPlayer().getInventory().setItem(8, i);
    }
}
