package com.jeancalistro.essentials.repository;

import com.jeancalistro.essentials.Warp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WarpRepository {

    private Connection dbConnection;

    public WarpRepository(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public Map<String, Object> get(String warpname) throws SQLException {
        PreparedStatement preparedStatement = dbConnection.prepareStatement("SELECT * FROM Warp WHERE name = ?");
        preparedStatement.setString(1, warpname);

        ResultSet resultset = preparedStatement.executeQuery();
        Map<String, Object> result = new HashMap<>();
        if(resultset.next()) {
            result.put("name", resultset.getString("name"));
            result.put("world", resultset.getString("world"));
            result.put("x", resultset.getDouble("x"));
            result.put("y", resultset.getDouble("y"));
            result.put("z", resultset.getDouble("z"));
        }

        preparedStatement.close();
        return result;
    }

    public List<Map<String, Object>> getAll() throws SQLException {
        PreparedStatement preparedStatement = dbConnection.prepareStatement("SELECT * FROM Warp");

        ResultSet resultset = preparedStatement.executeQuery();

        List<Map<String, Object>> result = new ArrayList<>();
        while(resultset.next()) {
            Map<String, Object> data = new HashMap<>();
            data.put("name", resultset.getString("name"));
            data.put("world", resultset.getString("world"));
            data.put("x", resultset.getDouble("x"));
            data.put("y", resultset.getDouble("y"));
            data.put("z", resultset.getDouble("z"));
            result.add(data);
        }

        preparedStatement.close();
        return result;
    }

    public void save(Warp warp) throws SQLException {
        PreparedStatement preparedStatement = dbConnection.prepareStatement("INSERT INTO Warp (name, world, x, y, z) VALUES (?, ?, ?, ?, ?)");
        preparedStatement.setString(1, warp.getName());
        preparedStatement.setString(2, warp.getWorld());
        preparedStatement.setDouble(3, warp.getX());
        preparedStatement.setDouble(4, warp.getY());
        preparedStatement.setDouble(5, warp.getZ());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public void delete(String warpname) throws SQLException {
        PreparedStatement preparedStatement = dbConnection.prepareStatement("DELETE FROM Warp WHERE name = ?");
        preparedStatement.setString(1, warpname);
        preparedStatement.execute();
        preparedStatement.close();
    }

}