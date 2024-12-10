import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Payroll {

  public static void main(String[] args) {
    Scanner departments = new Scanner(System.in);
    int max_size = 10;
    boolean t_f = false;
    int Userval = 0;

    ArrayList<ArrayList<String>> departmentArrayLists = new ArrayList<>(); 

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
        departments.next(); 
      } catch (IllegalArgumentException e) {
        System.out.println("Value given is too big");
        System.out.println("10 or lower");
      }
    }

    for (int i = 0; i < Userval; i++) {
      String deptName = "Department_" + (i + 1);
      ArrayList<String> deptList = new ArrayList<>();
      departmentMaker(deptName, deptList);
      departmentArrayLists.add(deptList);
      System.out.println(deptList);
      departmentfolders(deptName);
    }

    askemp(departmentArrayLists); 
  }

  public static void departmentMaker(String deptName, ArrayList<String> deptList) {
    deptList.add(deptName);
  }

  public static void departmentfolders(String deptName) {
    String currentDir = System.getProperty("user.dir");

    String currdirwfolder = currentDir + File.separator + deptName;
    System.out.println("Department Location: " + currdirwfolder);
    File dir = new File(currdirwfolder);

    if (!dir.exists()) {
      boolean result = dir.mkdir();
      if (result) {
        System.out.println("Directory '" + deptName + "' created successfully.");
      } else {
        System.out.println("Failed to create directory '" + deptName + "'.");
      }
    } else {
      System.out.println("Directory '" + deptName + "' already exists.");
    }
  }

  public static void askemp(ArrayList<ArrayList<String>> departmentArrayLists) {
    Scanner Askinfo = new Scanner(System.in);
    boolean t_f = false;

    System.out.println("Employee Information");
    System.out.print("Name: ");
    String name = Askinfo.nextLine();

    int min_age = 18;
    int age = 0;

    while (!t_f) {
      try {
        System.out.print("Age: ");
        age = Askinfo.nextInt();

        if (age < min_age) {
          throw new IllegalArgumentException("Too young to get a job");
        }
        t_f = true;
      } catch (InputMismatchException e) {
        System.out.println("Try again");
        System.err.println("NUMBERS ONLY");
        Askinfo.next(); 
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    }

    System.out.print("Phone Number: ");
    int phoneNumber = Askinfo.nextInt();

    Askinfo.nextLine();

    System.out.print("Home Address: ");
    String address = Askinfo.nextLine();

   
    System.out.println("Available Departments:");
    for (int i = 0; i < departmentArrayLists.size(); i++) {
      System.out.println((i + 1) + ". " + departmentArrayLists.get(i).get(0));
    }

    int departmentChoice = -1;
    while (true) {
      try {
        System.out.print("Select a department by number: ");
        departmentChoice = Askinfo.nextInt();

        if (departmentChoice < 1 || departmentChoice > departmentArrayLists.size()) {
          throw new IllegalArgumentException("Invalid department selection.");
        }
        break;
      } catch (InputMismatchException e) {
        System.out.println("Try again");
        System.err.println("NUMBERS ONLY");
        Askinfo.next(); 
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    }

    
    ArrayList<String> selectedDeptList = departmentArrayLists.get(departmentChoice - 1);
    selectedDeptList.add("Name: " + name + ", Age: " + age + ", Phone: " + phoneNumber + ", Address: " + address);

    System.out.println("Employee added to " + selectedDeptList.get(0));
    System.out.println("Updated Department Details: " + selectedDeptList);
  }
  public static void partimeornot(){
    
  }
}
