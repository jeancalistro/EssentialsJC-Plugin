package com.jeancalistro.essentials;

import com.jeancalistro.essentials.commands.CommandFix;
import com.jeancalistro.essentials.commands.CommandPing;
import com.jeancalistro.essentials.commands.warp.CommandDelWarp;
import com.jeancalistro.essentials.commands.warp.CommandSetWarp;
import com.jeancalistro.essentials.commands.warp.CommandWarp;
import com.jeancalistro.essentials.db.Database;
import com.jeancalistro.essentials.repository.WarpRepository;
import com.jeancalistro.essentials.service.WarpService;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.Connection;
import java.sql.SQLException;

public final class EssentialJC extends JavaPlugin {

    private Database db;
    private Connection dbConnection;
    private WarpRepository warpRepository;
    private WarpService warpService;

    @Override
    public void onEnable() {
        // Plugin startup logic

        //Initialize Database
        this.db = new Database();
        try {
            this.dbConnection = this.db.getConnection();
            this.db.initializeDatabase(this.dbConnection);
        }
        catch (SQLException e) {
            System.out.println("Could not initialize database");
        }

        //Initialize Repositories
        this.warpRepository = new WarpRepository(this.dbConnection);

        //Initialize Services
        this.warpService = new WarpService(this.warpRepository);

        //Initialize commands
        this.getCommand("fix").setExecutor(new CommandFix());
        this.getCommand("ping").setExecutor(new CommandPing());
        this.getCommand("setwarp").setExecutor(new CommandSetWarp(this.warpService));
        this.getCommand("warp").setExecutor(new CommandWarp(this.warpService));
        this.getCommand("delwarp").setExecutor(new CommandDelWarp(this.warpService));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Plugin getPlugin() {
        return getPlugin(EssentialJC.class);
    }
}
