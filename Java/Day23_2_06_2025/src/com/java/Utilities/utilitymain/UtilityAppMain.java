/* Q8. Create two packages com.example.utilities and com.example.helpers, 
each containing a class Utility with the same method name but different functionality. 
Write a program to resolve ambiguity when importing both packages. */
package com.java.Utilities.utilitymain;

import java.util.Scanner;

public class UtilityAppMain {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a number: ");
            int num = scanner.nextInt();
            com.java.Utilities.utility.Utility squareUtil = new com.java.Utilities.utility.Utility();
            com.java.Utilities.helper.HelperUtil cubeUtil = new com.java.Utilities.helper.HelperUtil();
            System.out.println(squareUtil.process(num));
            System.out.println(cubeUtil.process(num));
        }
    }
}