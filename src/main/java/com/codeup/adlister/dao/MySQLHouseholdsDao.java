package com.codeup.adlister.dao;

import com.codeup.adlister.models.Household;
import com.codeup.adlister.models.Task;
import com.codeup.adlister.util.Config;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLHouseholdsDao implements com.codeup.adlister.dao.Households {
    private Connection connection;

    public MySQLHouseholdsDao(Config config) {
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
    public List<Household> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM tasklister_db.households");
            ResultSet rs = stmt.executeQuery();
            return createHouseholdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }
    @Override
    public Household findByUsername(String username) {
        String query = "SELECT * FROM tasklister_db.households WHERE username = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if(!rs.next()) {
                return null;
            }
            return extractHousehold(rs);
        } catch (SQLException e) {
            throw new RuntimeException("User does not exist.", e);
        }
    }

    public Household findByEmail(String email) {
        String query = "SELECT * FROM tasklister_db.households WHERE email = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if(!rs.next()) {
                return null;
            }
            return extractHousehold(rs);

        } catch (SQLException e) {
            throw new RuntimeException("Email does not exist.", e);
        }
    }

    @Override
    public Long insert(Household household) {
        String query = "INSERT INTO tasklister_db.households(username, email, password) VALUES (?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, household.getUsername());
            stmt.setString(2, household.getEmail());
            stmt.setString(3, household.getPassword());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating new user", e);
        }
    }

    public void updatePassword(long id, String password) throws SQLException {
        try {
            PreparedStatement stmt = connection.prepareStatement("UPDATE tasklister_db.households SET password = ? WHERE id = ? ");
            stmt.setString(1, password);
            stmt.setLong(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error resetting your password", e);
        }
    }

    public void updateUsername(long id, String username) throws SQLException {
        try {
            PreparedStatement stmt = connection.prepareStatement("UPDATE tasklister_db.households SET username = ? WHERE id = ?");
            stmt.setString(1, username);
            stmt.setLong(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error resetting your username", e);
        }
    }
    public void updateName(long id, String name) throws SQLException {
        try {
            PreparedStatement stmt = connection.prepareStatement("UPDATE tasklister_db.households SET name = ? WHERE id = ?");
            stmt.setString(1, name);
            stmt.setLong(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error resetting your name.", e);
        }
    }
    public void updateEmail(long id, String email) throws SQLException {
        try {
            PreparedStatement stmt = connection.prepareStatement("UPDATE tasklister_db.households SET email = ? WHERE id = ?");
            stmt.setString(1, email);
            stmt.setLong(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteHousehold(long id) throws SQLException {
        try {
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM tasklister_db.households WHERE id = ?");
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting your household", e);
        }
    }

    private Household extractHousehold(ResultSet rs) throws SQLException {
        return new Household(
            rs.getInt("id"),
            rs.getString("username"),
            rs.getString("email"),
            rs.getString("password"),
            rs.getString("name")
        );
    }
    private List<Household> createHouseholdsFromResults(ResultSet rs) throws SQLException {
        List<Household> households = new ArrayList<>();
        while (rs.next()) {
            households.add(extractHousehold(rs));
        }
        return households;
    }

}
