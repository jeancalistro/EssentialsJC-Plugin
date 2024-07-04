package com.jeancalistro.essentials;

import org.bukkit.Location;

public class Warp {
    private Integer id;
    private String name;
    private String world;
    private Double x;
    private Double y;
    private Double z;

    public Warp() {

    }

    public Warp(String warpname, Location location) {
        this.name = warpname;
        this.world = location.getWorld().getName();
        this.x = location.getX();
        this.y = location.getY();
        this.z = location.getZ();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getWorld() {
        return world;
    }
    public void setWorld(String world) {
        this.world = world;
    }
    public Double getX() {
        return x;
    }
    public void setX(Double x) {
        this.x = x;
    }
    public Double getY() {
        return y;
    }
    public void setY(Double y) {
        this.y = y;
    }
    public Double getZ() {
        return z;
    }
    public void setZ(Double z) {
        this.z = z;
    }
}
