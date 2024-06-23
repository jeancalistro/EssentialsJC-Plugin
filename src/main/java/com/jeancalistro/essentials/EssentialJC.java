package com.jeancalistro.essentials;

import com.jeancalistro.essentials.commands.CommandFix;
import com.jeancalistro.essentials.commands.CommandPing;
import com.jeancalistro.essentials.commands.warp.CommandDelWarp;
import com.jeancalistro.essentials.commands.warp.CommandSetWarp;
import com.jeancalistro.essentials.commands.warp.CommandWarp;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class EssentialJC extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        //make a directory and file if not exists
        File dataFolder = getDataFolder();
        if(!dataFolder.exists()) {
            dataFolder.mkdir();
        }
        //warps directory
        File warpsFolder = new File(String.format("%s/warps", dataFolder.getPath()));
        if(!warpsFolder.exists()) {
            warpsFolder.mkdir();
        }
        //init commands
        this.getCommand("fix").setExecutor(new CommandFix());
        this.getCommand("ping").setExecutor(new CommandPing());
        this.getCommand("setwarp").setExecutor(new CommandSetWarp());
        this.getCommand("warp").setExecutor(new CommandWarp());
        this.getCommand("delwarp").setExecutor(new CommandDelWarp());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Plugin getPlugin() {
        return getPlugin(EssentialJC.class);
    }
}
