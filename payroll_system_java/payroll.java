import java.util.Scanner;
import java.util.random.*;
import java.util.ArrayList;
import java.util.List;

public class payroll {
    public static void main(String[] args) {
        // make a variable to call scanner
        boolean T_f = false;
        Scanner New_scanner1 = new Scanner(System.in);
        // asking for user information
        System.out.println("Developer payroll page");

        System.out.print("name: ");
        String name = New_scanner1.nextLine();
        System.out.print("age: ");
        int age;
        while (!T_f) {
            if (New_scanner1.hasNextInt()) {
                System.out.println("printing here1");
                break;

            } else {
                New_scanner1.next();
                System.out.println("printing here2");
                continue;
            } if (new);

        }

    }
}
