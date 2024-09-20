import java.util.Scanner;
import java.util.random.*;
import java.util.Arrays;

public class payroll2nd {
    public static void main(String[] args) {

        // make a variable to call scanner
        boolean T_f = false;
        Scanner New_scanner1 = new Scanner(System.in);
        String[] Departments = { "1", "2", "3", "4", "5" };

        // asking for user information
        System.out.println("Developer payroll page");

        System.out.print("name: ");
        String name = New_scanner1.nextLine();
        // ---------------------------------------------------------
        System.out.print("age: ");
        int age;
        while (!T_f) {
            if (New_scanner1.hasNextInt()) {
                break;

            } else {
                New_scanner1.next();
                System.out.println("Number only");
                System.out.print("age: ");
                continue;
            }
        }

        // -----------------------------------------------------------
        System.out.print("Phone Number: ");
        int phone_number;
        New_scanner1.next();
        while (!T_f) {
            if (New_scanner1.hasNextInt()) {
                T_f = true;
                break;

            } else {
                New_scanner1.next();
                System.out.println("Number only");
                System.out.print("Phone Number: ");
                continue;

            }
        }
        // ----------------------------------------------
        System.out.print("Address: ");
        String Address = New_scanner1.nextLine();
        New_scanner1.next();
        // ----------------------------------------------
        System.out.println("Please select what department do you want to be on");
        for (int counter = 4; counter < Departments.length; counter++) {
            System.out.print("Departments: ");
            System.out.println(Arrays.toString(Departments));
            break;
        }
        System.out.print("choose a Department: ");
        int department;
        New_scanner1.next();
        while (!T_f) {
            if (New_scanner1.hasNextInt()) {
                T_f = true;
                break;

            } else {
                New_scanner1.next();
                System.out.println("Number only");
                System.out.print("departments: ");
                continue;

            }
        }

    }
}
