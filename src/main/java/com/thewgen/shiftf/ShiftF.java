package com.thewgen.shiftf;

import org.bukkit.plugin.java.JavaPlugin;

public final class ShiftF extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        //this.getCommand("commands").setExecutor(new commands());
        this.getServer().getPluginManager().registerEvents(new ShiftFEvent(), this);
        LoadConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

    }

    public void LoadConfig() {
        saveDefaultConfig();
        saveConfig();
    }
}
