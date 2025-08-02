package com.java.Company.companymenu;

public class Manager extends Employee {
    private final String department;

    public Manager(String name, int id, double salary, String department) {
        super(name, id, salary);
        this.department = department;
    }
    public void conductMeeting() {
        System.out.println(name + " is conducting a meeting for the " + department + " department.");
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Department: " + department);
    }
}