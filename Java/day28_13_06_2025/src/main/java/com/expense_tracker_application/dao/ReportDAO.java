package com.expense_tracker_application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.expense_tracker_application.db.DBConnection;
import com.expense_tracker_application.model.Expense;

public class ReportDAO {

    // Fetch total expenses for a user in a given month and year
    public double getTotalExpenses(int userId, int month, int year) {
        String query = "SELECT SUM(amount) FROM expenses WHERE user_id = ? AND MONTH(date) = ? AND YEAR(date) = ?";
        double total = 0;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            conn.setAutoCommit(true);

            stmt.setInt(1, userId);
            stmt.setInt(2, month);
            stmt.setInt(3, year);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                total = rs.getDouble(1);
            }

        } catch (SQLException e) {
            System.out.println("Error fetching total expenses: " + e.getMessage());
        }

        return total;
    }

    // Fetch expenses grouped by category for a user in a given month and year
    public List<String> getCategoryWiseReport(int userId, int month, int year) {
        List<String> report = new ArrayList<>();
        String query = "SELECT category, SUM(amount) AS total FROM expenses WHERE user_id = ? AND MONTH(date) = ? AND YEAR(date) = ? GROUP BY category";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, userId);
            stmt.setInt(2, month);
            stmt.setInt(3, year);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String category = rs.getString("category");
                double total = rs.getDouble("total");
                report.add("Category: " + category + " | Total: ₹" + total);
            }

        } catch (SQLException e) {
            System.out.println("Error fetching category-wise report: " + e.getMessage());
        }

        return report;
    }

    // List all expenses in a month/year for the user
    public List<Expense> getMonthlyExpenseDetails(int userId, int month, int year) {
        List<Expense> expenses = new ArrayList<>();
        String query = "SELECT * FROM expenses WHERE user_id = ? AND MONTH(date) = ? AND YEAR(date) = ? ORDER BY date";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, userId);
            stmt.setInt(2, month);
            stmt.setInt(3, year);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Expense expense = new Expense();
                expense.setId(rs.getInt("id"));
                expense.setUserId(rs.getInt("user_id"));
                expense.setAmount(rs.getDouble("amount"));
                expense.setCategory(rs.getString("category"));
                expense.setDate(rs.getDate("date").toLocalDate());
                expense.setDescription(rs.getString("description"));

                expenses.add(expense);
            }

        } catch (SQLException e) {
            System.out.println("Error fetching monthly expense details: " + e.getMessage());
        }

        return expenses;
    }
}