import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Payroll2 {

  public static void main(String[] args) {
    Scanner departments = new Scanner(System.in);
    int max_size = 10;
    boolean t_f = false;
    int Userval = 0;

    while (!t_f) {
      try {
        System.out.print("How many departments to create: ");
        Userval = departments.nextInt();

        if (Userval > max_size) {
          throw new IllegalArgumentException();
        }

        t_f = true;
      } catch (InputMismatchException e) {
        System.out.println("Try again");
        System.err.println("NUMBERS ONLY");
        departments.next(); // Clear invalid input
      } catch (IllegalArgumentException e) {
        System.out.println("Value given is too big");
        System.out.println("10 or lower");
      }
      ArrayList<ArrayList<String>> departmentArrayLists = new ArrayList<>();
      for (int i = 0; i < Userval; i++) {
        String deptName = "Department_" + (i + 1);
        ArrayList<String> deptList = new ArrayList<>();
        departmentMaker(deptName, deptList);
        departmentArrayLists.add(deptList);
        System.out.println(deptList);
        departmentfolders(deptName);
      }
    }
    askemp();
  }

  public static void departmentMaker(
    String deptName,
    ArrayList<String> deptList
  ) {
    deptList.add(deptName);
  }

  public static void departmentfolders(String deptName) {
    String currentDir = System.getProperty("user.dir");

    String currdirwfolder = currentDir + File.separator + deptName;
    System.out.println("Current directory: " + currentDir);
    File dir = new File(currdirwfolder);

    if (!dir.exists()) {
      boolean result = dir.mkdir();
      if (result) {
        System.out.println(
          "Directory '" + deptName + "' created successfully."
        );
      } else {
        System.out.println("Failed to create directory '" + deptName + "'.");
      }
    } else {
      System.out.println("Directory '" + deptName + "' already exists.");
    }
  }

  public static void askemp() {
    Scanner Askinfo = new Scanner(System.in);
    System.out.println("Name: ");
    String name = Askinfo.nextLine();

  }
}
