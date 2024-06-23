package com.jeancalistro.essentials.commands.warp;

import com.jeancalistro.essentials.EssentialJC;
import com.jeancalistro.essentials.Warp;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

public class CommandWarp implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(args.length == 0) {
                for(Warp warp : Warp.getWarps()) {
                    player.sendMessage(warp.getName());
                }
            }
            else if (args.length == 1) {
                String warpName = args[0];
                Warp warp = Warp.getWarp(warpName);
                if(warp != null) {
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            player.teleportAsync(warp.getLocation(), PlayerTeleportEvent.TeleportCause.COMMAND);
                        }
                    }.runTaskLater(EssentialJC.getPlugin(), 20L * 3);
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
