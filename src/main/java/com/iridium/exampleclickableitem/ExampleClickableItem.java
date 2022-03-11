package com.iridium.exampleclickableitem;

import com.iridium.exampleclickableitem.listener.Handler;
import org.bukkit.plugin.java.JavaPlugin;

public final class ExampleClickableItem extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new Handler(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
