package com.jeancalistro.essentials;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class User {

    public static Map<String, Object> getLocation(Player player) {
        Location playerLocation = player.getLocation();
        Map<String, Object> coordinates = new HashMap<>();
        coordinates.put("world", playerLocation.getWorld().getName());
        coordinates.put("x", playerLocation.getX());
        coordinates.put("y", playerLocation.getY());
        coordinates.put("z", playerLocation.getZ());
        return coordinates;
    }
}
