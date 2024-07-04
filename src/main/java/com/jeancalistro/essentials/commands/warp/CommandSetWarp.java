package com.jeancalistro.essentials.commands.warp;

import com.jeancalistro.essentials.Warp;
import com.jeancalistro.essentials.repository.WarpRepository;
import com.jeancalistro.essentials.service.WarpService;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CommandSetWarp implements CommandExecutor {
    private WarpService warpService;

    public CommandSetWarp(WarpService warpService) {
        this.warpService = warpService;
    }

    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player && args.length == 1) {
            String warpName = args[0];
            Player player = (Player) sender;
            Warp warp = new Warp(warpName, player.getLocation());
            if(warpService.set(warp)) {
                player.sendMessage("Warp criada com sucesso!");
            }
            else {
                player.sendMessage("Não foi possível criar a Warp!");
            }
            return true;
        }
        return false;
    }
}
