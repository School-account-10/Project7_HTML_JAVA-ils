package Testenviro;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.random.*;
import java.util.ArrayList;
import java.util.Arrays;

public class payroll3rd {
    public static void main(String[] args) {
        boolean tr_fl = false; // true and false current value false

        Scanner new_scanner1 = new Scanner(System.in);
        ArrayList<String> Listofdepartment = new ArrayList<String>();
        Listofdepartment.add("Human Resources");
        Listofdepartment.add("Finance");
        Listofdepartment.add("Marketing");
        Listofdepartment.add("Sales");
        Listofdepartment.add("Operations");
        int department1 = 0;
        int counter1;

        System.out.print("Remaining departments: ");
        System.out.println(Listofdepartment.size());
        System.out.print("How many departments Do You Want to create: ");

        while (!tr_fl) {
            try {
                department1 = new_scanner1.nextInt();
            } catch (InputMismatchException e) {
                new_scanner1.next();
                System.out.println("Numbers Only Please try again");
                System.out.print("How many departments Do You Want to create: ");
                continue;

            }
            if (Listofdepartment.size() < department1) {
                System.out.println("bigger than list selected please try again ");
                System.out.print("How many departments Do You Want to create: ");
            } else {
                System.out.println("working ");
                for(counter1 = 0; counter1 < department1; counter1++){
                Listofdepartment.remove(Listofdepartment.size() -1 );
                System.out.println(Listofdepartment.get(counter1));
                }
                
            }

        }
        

    }
}
