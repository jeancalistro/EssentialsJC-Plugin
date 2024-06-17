package com.jeancalistro.essentials.commands.warp;

import com.jeancalistro.essentials.utils.FileUtils;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class CommandSetWarp implements CommandExecutor {

    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(sender instanceof Player) {
            String warpName = args[0] + ".yaml";
            Player player = (Player) sender;

            if(warpExists(warpName)) {
                player.sendMessage("Warp já existente!");
                return false;
            }

            Map<String, Object> playerCoordinates = getPlayerCoordinates(player);

            try {
                FileUtils.write(playerCoordinates, new File("plugins/EssentialsJC/warps/", warpName));
            } catch (IOException e) {
                player.sendMessage("Falha ao criar a warp!");
            }
        }
        return true;
    }

    private static boolean warpExists(String warpName) {
        return FileUtils.exists(Paths.get("plugins/EssentialsJC/warps/", warpName));
    }

    private static Map<String, Object> getPlayerCoordinates(Player player) {
        Location playerLocation = player.getLocation();
        Map<String, Object> coordinates = new HashMap<>();
        coordinates.put("x", playerLocation.getX());
        coordinates.put("y", playerLocation.getY());
        coordinates.put("z", playerLocation.getZ());
        return coordinates;
    }
}
