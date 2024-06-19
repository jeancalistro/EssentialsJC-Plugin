package com.jeancalistro.essentials;

import com.jeancalistro.essentials.repository.WarpRepository;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.Bukkit;
import java.io.IOException;
import java.util.HashMap;

public class Warp {

    private String name;
    Location location;
    World world;

    private Warp(String name, Location location) {
        this.name = name;
        this.location = location;
        this.world = location.getWorld();
    }

    public static void getWarps() {

    }

    public static Warp getWarp(String warpName) {
        HashMap<String, Object> data = (HashMap<String, Object>) WarpRepository.read(warpName);
        String worldName = (String) data.get("world");
        World world = Bukkit.getWorld(worldName);
        double x = (double) data.get("x");
        double y = (double) data.get("y");
        double z = (double) data.get("z");
        Location location = new Location(world, x, y, z);
        return new Warp(warpName, location);
    }

    public static Warp setWarp(String warpName, Location location) throws IOException {
        Warp warp = new Warp(warpName, location);
        if(WarpRepository.create(warp)) {
            return warp;
        }
        return null;
    }

    public static void delWarp() {

    }

    public String getName() {
        return this.name;
    }

    public double getX() {
        return this.location.getX();
    }

    public double getY() {
        return this.location.getY();
    }

    public double getZ() {
        return this.location.getZ();
    }

    public Location getLocation() {
        return this.location;
    }

    public World getWorld() {
        return this.world;
    }
}
