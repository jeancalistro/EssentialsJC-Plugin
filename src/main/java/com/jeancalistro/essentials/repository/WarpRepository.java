package com.jeancalistro.essentials.repository;

import com.jeancalistro.essentials.Warp;
import com.jeancalistro.essentials.utils.FileUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WarpRepository {

    public static Map<String, Object> read(String warpName) {
        String warpFileName = FileUtil.addExtension(warpName, "yaml");
        try {
            return FileUtil.readData(new File(String.format("plugins/EssentialsJC/warps/%s", warpFileName)));
        }
        catch (FileNotFoundException e) {
            return null;
        }
    }

    public static List<String> list(boolean removeExtension) {
        List<String> warpNameList = new ArrayList<>();
        try {
            for(File file : FileUtil.listFiles(new File("plugins/EssentialsJC/warps/"))) {
                if(removeExtension) {
                    String filename = FileUtil.removeExtension(file.getName(), "yaml");
                    warpNameList.add(filename);
                }
                else {
                    warpNameList.add(file.getName());
                }
            }
            return warpNameList;
        }
        catch (FileNotFoundException e) {
            return null;
        }
    }

    public static boolean create(Warp warp) throws IOException {
        String warpFileName = FileUtil.addExtension(warp.getName(), "yaml");
        Map<String, Object> attrs = new HashMap<>();
        attrs.put("world", warp.getWorld().getName());
        attrs.put("name", warp.getName());
        attrs.put("x", warp.getX());
        attrs.put("y", warp.getY());
        attrs.put("z", warp.getZ());
        try {
            FileUtil.saveData(new File(String.format("plugins/EssentialsJC/warps/%s", warpFileName)), attrs);
        }
        catch (IOException e) {
            return false;
        }
        return true;
    }

    public static boolean delete(String warpName) {
        try {
            String warpFileName = FileUtil.addExtension(warpName, "yaml");
            FileUtil.deleteData(new File(String.format("plugins/EssentialsJC/warps/%s", warpFileName)));
            return true;
        }
        catch (FileNotFoundException e) {
            return false;
        }
    }
}