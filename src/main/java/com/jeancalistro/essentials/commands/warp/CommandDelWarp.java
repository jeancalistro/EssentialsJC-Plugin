package com.jeancalistro.essentials.commands.warp;

import com.jeancalistro.essentials.service.WarpService;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CommandDelWarp implements CommandExecutor {
    private WarpService warpService;

    public CommandDelWarp(WarpService warpService) {
        this.warpService = warpService;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(args.length == 1) {
                String warpName = args[0];
                if(warpService.delete(warpName)) {
                    player.sendMessage("Warp excluida!");
                }
                else {
                    player.sendMessage("Não foi possível excluir a Warp!");
                }
                return true;
            }
        }
        return false;
    }
}
