/* Q6. Create a package com.example.company containing classes Employee, Manager, and Intern with attributes and methods. 
Write a program to instantiate these classes and perform operations. */
package com.java.Company.companymain;

import com.java.Company.companymenu.Intern;
import com.java.Company.companymenu.Manager;
import java.util.Scanner;
public class CompanyAppMain {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter Manager Details:");
            System.out.print("Name: ");
            String mName = scanner.nextLine();
            System.out.print("ID: ");
            int mId = scanner.nextInt();
            System.out.print("Salary: ");
            double mSalary = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Department: ");
            String department = scanner.nextLine();
            Manager manager = new Manager(mName, mId, mSalary, department);
            System.out.println("\nEnter Intern Details:");
            System.out.print("Name: ");
            String iName = scanner.nextLine();
            System.out.print("ID: ");
            int iId = scanner.nextInt();
            System.out.print("Stipend: ");
            double iSalary = scanner.nextDouble();
            System.out.print("Duration in months: ");
            int duration = scanner.nextInt();
            Intern intern = new Intern(iName, iId, iSalary, duration);
            System.out.println("\n--- Manager Info ---");
            manager.displayInfo();
            manager.conductMeeting();
            System.out.println("\n--- Intern Info ---");
            intern.displayInfo();
            intern.attendTraining();
            scanner.close();
        }
    }
}