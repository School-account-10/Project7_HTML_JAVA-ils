package payroll_system;

import java.util.Scanner;
import java.util.random.*;
import java.util.ArrayList;
import java.util.List;

public class payroll {
    public static void main(String[] args) {
        Scanner TextAndNumb = new Scanner(System.in);
        // lahat ng naditio dapat ma save sa file
        int current_Departments = 0; // put this on a file
        // deductions
        int current_sss = 10;
        int current_pagibig = 20;
        int current_phil_health = 0;

        // salary
        int salary_pay = 0;

        // listing values
        List<Integer> departmentList = new ArrayList<>();

        // Add elements to the list
        departmentList.add(1);
        departmentList.add(2);
        departmentList.add(3);
        departmentList.add(4); 
        departmentList.add(5);

        // randomise between

        // main display code
        System.out.print("Name: ");
        String Name1 = TextAndNumb.nextLine(); // asking for string shit

        System.out.print("Age: "); // age
        while (!TextAndNumb.hasNextInt()) {
            System.out.println("try again ");
            int age1 = TextAndNumb.nextInt();
            System.out.print("Contact_Number: ");

        }
        TextAndNumb.nextLine();

        System.out.print("Phone_number: "); // phone number
        while (!TextAndNumb.hasNextInt()) {
            System.out.println("try again ");
            int Phone_number = TextAndNumb.nextInt();
            System.out.print("Phone_Number: ");

        }
        TextAndNumb.nextLine();
        System.out.print("address: ");
        String adresss = TextAndNumb.nextLine(); // asking for string shit

    }
}