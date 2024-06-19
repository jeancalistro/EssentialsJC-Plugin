package com.jeancalistro.essentials.repository;

import com.jeancalistro.essentials.Warp;
import com.jeancalistro.essentials.utils.FileUtil;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WarpRepository {

    public static Map<String, Object> read(String warpName) {
        String warpFileName = FileUtil.addExtension(warpName, "yaml");
        return FileUtil.readData(new File(String.format("plugins/EssentialsJC/warps/%s", warpFileName)));
    }

    public static boolean create(Warp warp) throws IOException {
        String warpFileName = FileUtil.addExtension(warp.getName(), "yaml");
        Map<String, Object> attrs = new HashMap<>();
        attrs.put("world", warp.getWorld().getName());
        attrs.put("name", warp.getName());
        attrs.put("x", warp.getX());
        attrs.put("y", warp.getY());
        attrs.put("z", warp.getZ());
        FileUtil.saveData(new File(String.format("plugins/EssentialsJC/warps/%s", warpFileName)), attrs);
        return true;
    }

    public static boolean delete(String warpName) {
        return true;
    }
}