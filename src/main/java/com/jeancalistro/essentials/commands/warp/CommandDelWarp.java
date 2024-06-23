package com.jeancalistro.essentials.commands.warp;

import com.jeancalistro.essentials.Warp;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CommandDelWarp implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(args.length == 1) {
                String warpName = args[0];
                if(Warp.delWarp(warpName)) {
                    player.sendMessage(String.format("Warp %s foi excluída!", warpName));
                }
                else {
                    player.sendMessage(String.format("Não foi possível excluir a warp %s!", warpName));
                }
                return true;
            }
        }
        return false;
    }
}
