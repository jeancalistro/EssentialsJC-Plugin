package com.jeancalistro.essentials.commands.warp;

import com.jeancalistro.essentials.Warp;
import com.jeancalistro.essentials.service.WarpService;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.World;
import org.bukkit.Location;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CommandWarp implements CommandExecutor {
    private WarpService warpService;

    public CommandWarp(WarpService warpService) {
        this.warpService = warpService;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(args.length == 0) {
                List<Warp> warps = warpService.getAll();
                if(warps != null) {
                    for(Warp warp : warps) {
                        player.sendMessage(warp.getName());
                    }
                }
            }
            else if (args.length == 1) {
                String warpName = args[0];
                Warp warp = warpService.get(warpName);
                if(warp != null) {
                    World world = Bukkit.getWorld(warp.getWorld());
                    Location warpLocation = new Location(world, warp.getX(), warp.getY(), warp.getZ());
                    player.teleportAsync(warpLocation, PlayerTeleportEvent.TeleportCause.COMMAND);
                }
                else {
                    player.sendMessage(String.format("Warp %s Não Existe!", warpName));
                }
            }
            else {
                return false;
            }
        }
        return true;
    }
}
