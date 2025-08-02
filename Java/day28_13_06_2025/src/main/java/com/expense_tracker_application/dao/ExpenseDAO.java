package com.expense_tracker_application.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.expense_tracker_application.db.DBConnection;
import com.expense_tracker_application.model.Expense;

public class ExpenseDAO {

    public boolean addExpense(Expense expense) {
        String query = "INSERT INTO expenses (user_id, category, amount, date) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            conn.setAutoCommit(true);

            stmt.setInt(1, expense.getUserId());
            stmt.setString(2, expense.getCategory());
            stmt.setDouble(3, expense.getAmount());
            stmt.setDate(4, Date.valueOf(expense.getDate()));

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error adding expense: " + e.getMessage());
            return false;
        }
    }

    public List<Expense> getExpensesByUserId(int userId) {
        List<Expense> list = new ArrayList<>();
        String query = "SELECT * FROM expenses WHERE user_id = ? ORDER BY date DESC";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Expense e = new Expense(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getString("category"),
                        rs.getDouble("amount"),
                        rs.getDate("date").toLocalDate()
                );
                list.add(e);
            }

        } catch (SQLException e) {
            System.out.println("Error fetching expenses: " + e.getMessage());
        }

        return list;
    }

    public Map<String, Double> getExpenseSummary(int userId) {
        Map<String, Double> summary = new HashMap<>();
        String query = "SELECT category, SUM(amount) as total FROM expenses WHERE user_id = ? GROUP BY category";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                summary.put(rs.getString("category"), rs.getDouble("total"));
            }

        } catch (SQLException e) {
            System.out.println("Error generating summary: " + e.getMessage());
        }

        return summary;
    }
}