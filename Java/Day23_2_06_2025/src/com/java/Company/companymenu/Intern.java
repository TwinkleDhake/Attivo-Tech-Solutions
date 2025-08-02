package com.java.Company.companymenu;

public class Intern extends Employee {
    private final int durationMonths;
    public Intern(String name, int id, double salary, int durationMonths) {
        super(name, id, salary);
        this.durationMonths = durationMonths;
    }
    public void attendTraining() {
        System.out.println(name + " is attending training. Internship duration: " + durationMonths + " months.");
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Internship Duration: " + durationMonths + " months");
    }
}