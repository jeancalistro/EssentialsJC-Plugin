package com.jeancalistro.essentials.service;

import com.jeancalistro.essentials.Warp;
import com.jeancalistro.essentials.repository.WarpRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WarpService {
    private WarpRepository warpRepository;

    public WarpService(WarpRepository warpRepository) {
        this.warpRepository = warpRepository;
    }

    public boolean set(Warp warp) {
        try {
            warpRepository.save(warp);
            return true;
        }
        catch (SQLException e) {
            return false;
        }
    }

    public Warp get(String warpname) {
        try {
            Map<String, Object> warpData = warpRepository.get(warpname);
            Warp warp = new Warp();
            warp.setName((String) warpData.get("name"));
            warp.setWorld((String) warpData.get("world"));
            warp.setX((Double) warpData.get("x"));
            warp.setY((Double) warpData.get("y"));
            warp.setZ((Double) warpData.get("z"));
            System.out.println(warp.getName());
            return warp;
        }
        catch (SQLException e) {
            return null;
        }
    }

    public List<Warp> getAll() {
        try {
            List<Map<String, Object>> warpsData = warpRepository.getAll();
            List<Warp> warps = new ArrayList<>();
            for(Map<String, Object> warpData: warpsData) {
                Warp warp = new Warp();
                warp.setName((String) warpData.get("name"));
                warp.setWorld((String) warpData.get("world"));
                warp.setX((Double) warpData.get("x"));
                warp.setY((Double) warpData.get("y"));
                warp.setZ((Double) warpData.get("z"));
                warps.add(warp);
            }
            return warps;
        }
        catch (SQLException e) {
            return null;
        }

    }

    public boolean delete(String warpname) {
        try {
            warpRepository.delete(warpname);
            return true;
        }
        catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    /*public Location getLocation(String warpname) {
        Warp warp = warpRepository.findWarpByName(warpname);
        World world = Bukkit.getWorld(warp.getWorld());
        return new Location(world, warp.getX(), warp.getY(), warp.getZ());
    }*/
}
