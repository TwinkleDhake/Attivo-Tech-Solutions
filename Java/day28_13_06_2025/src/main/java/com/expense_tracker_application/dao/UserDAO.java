package com.expense_tracker_application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.expense_tracker_application.db.DBConnection;
import com.expense_tracker_application.model.User;

public class UserDAO {

    public boolean register(String username, String password, String email) {
        String query = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

             /* System.out.println("DEBUG username: [" + username + "]");
                System.out.println("DEBUG password: [" + password + "]");

                stmt.setString(1, username.trim());
                stmt.setString(2, password.trim()); */

            conn.setAutoCommit(true);

            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setString(3, email);

            int result = stmt.executeUpdate();
            return result > 0;

        } catch (SQLException e) {
            System.out.println("Error registering user: " + e.getMessage());
            return false;
        }
    }

    public User login(String username, String password) {
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            conn.setAutoCommit(true);

            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                return user;
            }

        } catch (SQLException e) {
            System.out.println("Error during login: " + e.getMessage());
        }

        return null;
    }
}