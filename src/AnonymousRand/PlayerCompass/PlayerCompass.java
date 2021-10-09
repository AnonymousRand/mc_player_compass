package AnonymousRand.PlayerCompass;

import org.bukkit.plugin.java.JavaPlugin;


public class PlayerCompass extends JavaPlugin {

    @Override
    public void onEnable() { //register the commands
        getCommand("start").setExecutor(new CommandStart(this));
        getServer().getPluginManager().registerEvents(new Listeners(), this); //register the listeners
    }

    @Override
    public void onDisable() {

    }
}
