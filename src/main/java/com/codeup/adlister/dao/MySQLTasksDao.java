package com.codeup.adlister.dao;

import com.codeup.adlister.util.Config;
import com.codeup.adlister.models.Task;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLTasksDao implements Tasks {
    private Connection connection = null;

    public MySQLTasksDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUser(),
                config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public List<Task> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM tasklister_db.tasks");
            ResultSet rs = stmt.executeQuery();
            return createTasksFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public Long insert(Task task) {
        try {
            String insertQuery = "INSERT INTO tasklister_db.tasks(id, name, description, household_id) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, task.getId());
            stmt.setString(2, task.getName());
            stmt.setString(3, task.getDescription());
            stmt.setInt(4, task.getHouseholdId());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    private Task extractAd(ResultSet rs) throws SQLException {
        return new Task(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getString("description"),
            rs.getInt("household_id")
        );
    }

    private List<Task> createTasksFromResults(ResultSet rs) throws SQLException {
        List<Task> tasks = new ArrayList<>();
        while (rs.next()) {
            tasks.add(extractAd(rs));
        }
        return tasks;
    }
}
