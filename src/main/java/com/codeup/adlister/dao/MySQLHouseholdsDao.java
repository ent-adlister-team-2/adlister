package com.codeup.adlister.dao;

import com.codeup.adlister.util.Config;
import com.codeup.adlister.models.Households;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;

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
    public com.codeup.adlister.models.Households findByUsername(String username) {
        String query = "SELECT * FROM users WHERE username = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            return extractUser(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by username", e);
        }
    }

    @Override
    public Long insert(Households households) {
        String query = "INSERT INTO users(username, email, password) VALUES (?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, households.getUsername());
            stmt.setString(2, households.getEmail());
            stmt.setString(3, households.getPassword());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating new user", e);
        }
    }

    private Households extractUser(ResultSet rs) throws SQLException {
        if (! rs.next()) {
            return null;
        }
        return new Households(
            rs.getInt("id"),
            rs.getString("username"),
            rs.getString("email"),
            rs.getString("password")
        );
    }

}
