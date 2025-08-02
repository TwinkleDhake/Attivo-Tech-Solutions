/* Q1. Project Name: Expense Tracker Application
Objective:
Build a console-based application that helps users track their expenses by categorizing them, generating reports, and managing budgets.
Features:
User Management:
User registration and login.
Store user data securely.
Expense Management:
Add expenses with details such as amount, category (e.g., Food, Transport), and date.
View all expenses.
Budget Management:
Set monthly budgets for each category.
Alert if spending exceeds the budget.
Reports:
Generate monthly spending reports.
Visualize data using basic text-based charts (like histograms).
Data Persistence:
Use file storage or a lightweight database (e.g., SQLite). */

package com.expense_tracker_application;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.expense_tracker_application.dao.BudgetDAO;
import com.expense_tracker_application.dao.ExpenseDAO;
import com.expense_tracker_application.dao.UserDAO;
import com.expense_tracker_application.model.Budget;
import com.expense_tracker_application.model.Expense;
import com.expense_tracker_application.model.User;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final UserDAO userDAO = new UserDAO();
    private static final ExpenseDAO expenseDAO = new ExpenseDAO();
    private static final BudgetDAO budgetDAO = new BudgetDAO();

    private static User currentUser = null;

    public static void main(String[] args) {
        while (true) {
            if (currentUser == null) {
                System.out.println("\n==== Expense Tracker ====");
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> register();
                    case 2 -> login();
                    case 3 -> {
                        System.out.println("Goodbye!");
                        System.exit(0);
                    }
                    default -> System.out.println("Invalid choice.");
                }
            } else {
                showUserMenu();
            }
        }
    }

    private static void register() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        //String username = scanner.nextLine().trim();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        //String password = scanner.nextLine().trim();
        System.out.print("Enter email: ");
        String email = scanner.nextLine().toLowerCase();

        // Validate email format using regex
        if (!isValidEmail(email)) {
            System.out.println("Invalid email format. Please try again.");
            return;
        }

        boolean success = userDAO.register(username, password, email);
        if (success) {
            System.out.println("Registration successful. You can now log in.");
        } else {
            System.out.println("Username already exists. Try another.");
        }
    }

    private static void login() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        //String username = scanner.nextLine().trim();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        //String password = scanner.nextLine().trim();

        currentUser = userDAO.login(username, password);
        if (currentUser != null) {
            System.out.println("Login successful. Welcome " + currentUser.getUsername() + "!");
        } else {
            System.out.println("Invalid credentials. Try again.");
        }
    }

    private static void showUserMenu() {
        System.out.println("\n=== Menu ===");
        System.out.println("1. Add Expense");
        System.out.println("2. View Expenses");
        System.out.println("3. Set Budget");
        System.out.println("4. View Budget");
        System.out.println("5. Generate Report");
        System.out.println("6. Logout");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> addExpense();
            case 2 -> viewExpenses();
            case 3 -> setBudget();
            case 4 -> viewBudget();
            case 5 -> generateReport();
            case 6 -> {
                currentUser = null;
                System.out.println("Logged out.");
            }
            default -> System.out.println("Invalid choice.");
        }
    }

    private static void addExpense() {
        System.out.print("Enter category: ");
        String category = scanner.nextLine();
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter date (YYYY-MM-DD): ");
        String date = scanner.nextLine();

        Expense expense = new Expense(currentUser.getId(), amount, category, date);
        boolean success = expenseDAO.addExpense(expense);
        if (success) {
            System.out.println("Expense added successfully.");
        } else {
            System.out.println("Failed to add expense.");
        }
    }

    private static void viewExpenses() {
        List<Expense> expenses = expenseDAO.getExpensesByUserId(currentUser.getId());
        System.out.println("=== Your Expenses ===");
        for (Expense e : expenses) {
            System.out.println("[" + e.getDate() + "] " + e.getCategory() + ": ₹" + e.getAmount());
        }
    }

    private static void setBudget() {
        System.out.print("Enter category: ");
        String category = scanner.nextLine();
        System.out.print("Enter monthly limit: ");
        double limit = scanner.nextDouble();
        scanner.nextLine();

        Budget budget = new Budget(currentUser.getId(), category, limit);
        boolean success = budgetDAO.setBudget(budget);
        if (success) {
            System.out.println("Budget set successfully.");
        } else {
            System.out.println("Failed to set budget.");
        }
    }

    private static void viewBudget() {
        List<Budget> budgets = budgetDAO.getBudgetsByUserId(currentUser.getId());
        System.out.println("=== Your Budgets ===");
        for (Budget b : budgets) {
            System.out.println(b.getCategory() + " -> Limit: ₹" + b.getMonthlyLimit());
        }
    }

    private static void generateReport() {
        Map<String, Double> totals = expenseDAO.getExpenseSummary(currentUser.getId());
        List<Budget> budgets = budgetDAO.getBudgetsByUserId(currentUser.getId());

        System.out.println("=== Report ===");
        for (Map.Entry<String, Double> entry : totals.entrySet()) {
            String category = entry.getKey();
            double spent = entry.getValue();
            double limit = budgets.stream()
                    .filter(b -> b.getCategory().equalsIgnoreCase(category))
                    .map(Budget::getMonthlyLimit)
                    .findFirst()
                    .orElse(0.0);
            System.out.println(category + ": ₹" + spent + " / ₹" + limit);
        }
    }

    private static boolean isValidEmail(String email) {
        email = email.toLowerCase();
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email.matches(emailRegex);
    }
}