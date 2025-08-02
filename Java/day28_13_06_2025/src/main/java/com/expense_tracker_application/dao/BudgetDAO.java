package com.expense_tracker_application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.expense_tracker_application.db.DBConnection;
import com.expense_tracker_application.model.Budget;

public class BudgetDAO {

    public boolean setBudget(Budget budget) {
        String query = "INSERT INTO budgets (user_id, category, monthly_limit) VALUES (?, ?, ?) " +
                       "ON DUPLICATE KEY UPDATE monthly_limit = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            conn.setAutoCommit(true);

            stmt.setInt(1, budget.getUserId());
            stmt.setString(2, budget.getCategory());
            stmt.setDouble(3, budget.getMonthlyLimit());
            stmt.setDouble(4, budget.getMonthlyLimit());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error setting budget: " + e.getMessage());
            return false;
        }
    }

    public List<Budget> getBudgetsByUserId(int userId) {
        List<Budget> list = new ArrayList<>();
        String query = "SELECT * FROM budgets WHERE user_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Budget b = new Budget();
                b.setId(rs.getInt("id"));
                b.setUserId(rs.getInt("user_id"));
                b.setCategory(rs.getString("category"));
                b.setMonthlyLimit(rs.getDouble("monthly_limit"));
                list.add(b);
            }

        } catch (SQLException e) {
            System.out.println("Error fetching budgets: " + e.getMessage());
        }

        return list;
    }
}