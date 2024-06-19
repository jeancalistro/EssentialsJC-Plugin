package com.jeancalistro.essentials.commands.warp;

import com.jeancalistro.essentials.Warp;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import java.io.IOException;

public class CommandSetWarp implements CommandExecutor {

    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player && args.length == 1) {
            String warpName = args[0];
            Player player = (Player) sender;
            try {
                Warp warp = Warp.setWarp(warpName, player.getLocation());
                if(warp != null) {
                    player.sendMessage(String.format("Warp %s foi criada com sucesso!", warp.getName()));
                }
                else {
                    player.sendMessage(String.format("Não foi possível criar a warp %s", warpName));
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            return true;
        }
        return false;
    }
}
