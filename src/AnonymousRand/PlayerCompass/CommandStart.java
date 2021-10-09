package AnonymousRand.PlayerCompass;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.Arrays;

import static org.bukkit.Bukkit.getServer;

public class CommandStart implements CommandExecutor{

    private PlayerCompass plugin;

    public CommandStart(PlayerCompass plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand (CommandSender sender, Command command, String label, String[] args) { //when the command is executed
        BukkitScheduler scheduler = getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(this.plugin, new Runnable() {

            Player player1;

            @Override
            public void run() {
                if (sender instanceof Player) {
                    player1 = (Player) sender;
                } else {
                    return;
                }

                String name = Arrays.toString(args);
                name = name.substring(1, name.length() - 1);

                for (Player target : Bukkit.getOnlinePlayers()) {
                    if (target.getName().equals(name) && target.getWorld() == player1.getWorld()) { //if the current player being iterated over is the player that you want to track
                        player1.setCompassTarget(target.getLocation()); //set target
                    }
                }
            }
        }, 0L, 20L); //loop every 20 ticks or 1 second

        return true;
    }
}