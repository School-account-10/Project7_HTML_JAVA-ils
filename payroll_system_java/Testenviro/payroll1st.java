package Testenviro;

import java.util.Scanner;
import java.util.random.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class payroll1st {
    public static void main(String[] args) {
        // make a variable to call scanner
        boolean T_f = false;
        Scanner New_scanner1 = new Scanner(System.in);
        String[] Departments = { "1", "2", "3", "4", "5", "6", };
        ArrayList<String> Listofdepartment = new ArrayList<>(Arrays.asList(Departments)); // lazy af so List
        // asking for user information
        System.out.println("Developer payroll page");
        // ----------------------------------------------
        System.out.println("Select how many departments you want ");
        for (int counter1 = 4; counter1 < Departments.length; counter1++) {
            System.out.print("Departments: ");
            System.out.println(Arrays.toString(Departments));
            break;
        }
        System.out.println("Put 0 if you've put your desired value");
        System.out.print("How many departments: ");
        while (!T_f) {
            int RMrfdepartment;
            String confirm;
            if (New_scanner1.hasNextInt()) {

                RMrfdepartment = New_scanner1.nextInt();

                int newSize = Listofdepartment.size() - RMrfdepartment; // TODO fix only 5 can be selected - FranzOli
                newSize = Math.max(newSize, 0);
                System.out.println("Current Available Departments: " + newSize);

                if (RMrfdepartment <= Listofdepartment.size()) {
                    if (RMrfdepartment == 0) {
                        System.out.println("okay!"); // lazy asf wtf????
                        break;

                    }
                    System.out.print("How many departments: ");
                    while (Listofdepartment.size() > newSize) {
                        Listofdepartment.remove(Listofdepartment.size() - 1);
                    }
                    if (newSize == 0) {
                        System.out.println("too much");
                        System.out.print("How many departments: ");

                    }
                }

            } else {
                New_scanner1.next();
                System.out.println("Numbers only");
                System.out.print("How many departments: ");
                continue;
            }
        }

    }

}
