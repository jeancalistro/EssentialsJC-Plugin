package com.jeancalistro.essentials;

import com.jeancalistro.essentials.commands.CommandFix;
import com.jeancalistro.essentials.commands.CommandPing;
import com.jeancalistro.essentials.commands.warp.CommandSetWarp;
import com.jeancalistro.essentials.utils.FileUtils;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.nio.file.Paths;

public final class Essential extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        //make a directory and file if not exists
        if(!FileUtils.exists(Paths.get("plugins/EssentialsJC"))) {
            try {
                FileUtils.createDirectory("plugins/", "EssentialsJC");
                FileUtils.createDirectory("plugins/EssentialsJC", "warps");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        //init commands
        this.getCommand("fix").setExecutor(new CommandFix());
        this.getCommand("ping").setExecutor(new CommandPing());
        this.getCommand("setwarp").setExecutor(new CommandSetWarp());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
