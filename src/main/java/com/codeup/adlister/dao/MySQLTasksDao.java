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
    public List<Task> all(Long houseId) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM tasklister_db.tasks WHERE household_id=?");
            stmt.setLong(1, houseId);
            ResultSet rs = stmt.executeQuery();
            return createTasksFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }
    @Override
    public List<Task> sortAllByName(Long houseId) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM tasklister_db.tasks WHERE household_id=? ORDER BY name");
            stmt.setLong(1, houseId);
            ResultSet rs = stmt.executeQuery();
            return createTasksFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }
    @Override
    public Long insert(Task task) {
        try {
            String insertQuery = "INSERT INTO tasklister_db.tasks(id, name, description, repeatable, household_id) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, task.getId());
            stmt.setString(2, task.getName());
            stmt.setString(3, task.getDescription());
            stmt.setInt(4, task.getRepeatable() ? 1 : 0);
            stmt.setLong(5, task.getHouseholdId());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new task.", e);
        }
    }

    @Override
    public void deleteTask(long id) {
        try {
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM tasklister_db.tasks WHERE id = ?");
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting a task.", e);
        }
    }

    @Override
    public long updateName(long id, String name) {
        try {
            PreparedStatement stmt = connection.prepareStatement("UPDATE tasklister_db.tasks SET name = ? WHERE id = ?", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, name);
            stmt.setLong(2, id);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
//            rs.next();
//            return rs.getLong(1);
            if(rs.next()) {
                System.out.println("updateName rs.next is false!");
                return rs.getLong(1);
            } else
                return -1L;
        } catch (SQLException e) {
            throw new RuntimeException("Error updating task name.", e);
        }
    }

    @Override
    public long updateDescription(long id, String description) {
        try {
            PreparedStatement stmt = connection.prepareStatement("UPDATE tasklister_db.tasks SET description = ? WHERE id = ?", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, description);
            stmt.setLong(2, id);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
//            rs.next();
//            return rs.getLong(1);
            if(rs.next()) {
                System.out.println("updateName rs.next is false!");
                return rs.getLong(1);
            } else
                return -1L;
        } catch (SQLException e) {
            throw new RuntimeException("Error updating task description.", e);
        }
    }

    @Override
    public long updateStatus(long id, int status) {
        try {
            PreparedStatement stmt = connection.prepareStatement("UPDATE tasklister_db.tasks SET status = ? WHERE id = ?", Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, status);
            stmt.setLong(2, id);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
//            rs.next();
//            return rs.getLong(1);
            if(rs.next()) {
                System.out.println("updateName rs.next is false!");
                return rs.getLong(1);
            } else
                return -1L;
        } catch (SQLException e) {
            throw new RuntimeException("Error updating task status.", e);
        }
    }

    @Override
    public long updateRepeatable(long id, int repeatable) {
        try {
            PreparedStatement stmt = connection.prepareStatement("UPDATE tasklister_db.tasks SET repeatable = ? WHERE id = ?", Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, repeatable);
            stmt.setLong(2, id);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
//            rs.next();
//            return rs.getLong(1);
            if(rs.next()) {
                System.out.println("updateName rs.next is false!");
                return rs.getLong(1);
            } else
                return -1L;
        } catch (SQLException e) {
            throw new RuntimeException("Error updating task repeatable.", e);
        }
    }

    @Override
    public long updateCategory(long id, String category) {
        try {
            PreparedStatement stmt = connection.prepareStatement("UPDATE tasklister_db.tasks SET category = ? WHERE id = ?", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, category);
            stmt.setLong(2, id);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
//            rs.next();
//            return rs.getLong(1);
            if(rs.next()) {
                System.out.println("updateName rs.next is false!");
                return rs.getLong(1);
            } else
                return -1L;
        } catch (SQLException e) {
            throw new RuntimeException("Error updating task category.", e);
        }
    }

    @Override
    public Task findById(long taskId) throws SQLException {
        String viewSingleTask = "SELECT * FROM tasklister_db.tasks WHERE id= ?";
        PreparedStatement statement = connection.prepareStatement(viewSingleTask);
        statement.setLong(1, taskId);
        ResultSet rs = statement.executeQuery();
        rs.next();
        return extractTask(rs);
    }

    private Task extractTask(ResultSet rs) throws SQLException {
        return new Task(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("description"),
                rs.getBoolean("repeatable"),
                rs.getBoolean("status"),
                rs.getLong("household_id")
        );
    }

    private List<Task> createTasksFromResults(ResultSet rs) throws SQLException {
        List<Task> tasks = new ArrayList<>();
        while (rs.next()) {
            tasks.add(extractTask(rs));
        }
        return tasks;
    }
}
