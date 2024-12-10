import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Payroll {

  // i would like to thank stackoverflow and discord people for the help on this prject

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
    writeall(departmentArrayLists);
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
    System.out.println("Department Location: " + currdirwfolder);
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

  public static void askemp(ArrayList<ArrayList<String>> departmentArrayLists) {
    Scanner Askinfo = new Scanner(System.in);
    boolean t_f = false;

    System.out.println("Employee Information");
    System.out.print("Name: ");
    String name = Askinfo.nextLine();
    int phoneNumber = 0;
    int min_age = 18;
    int age = 0;

    while (!t_f) {
      try {
        System.out.print("Age: ");
        age = Askinfo.nextInt();

        if (age < min_age) {
          throw new IllegalArgumentException("Too young to get a job");
        }
        System.out.print("Phone Number: ");
        phoneNumber = Askinfo.nextInt();
        t_f = true;
      } catch (InputMismatchException e) {
        System.out.println("Try again");
        System.err.println("NUMBERS ONLY");
        Askinfo.next();
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }
    }

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

        if (
          departmentChoice < 1 || departmentChoice > departmentArrayLists.size()
        ) {
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

    Scanner input = new Scanner(System.in);
    boolean validInput = false;
    boolean isFullTime = false;
    double salary = 0;
    String employmentType = "";

    while (!validInput) {
      System.out.print("Is the employee Full-time or Part-time? (full/part): ");
      String response = input.nextLine().trim().toLowerCase();

      if (response.equals("full")) {
        isFullTime = true;
        employmentType = "Full-time";
        validInput = true;
      } else if (response.equals("part")) {
        isFullTime = false;
        employmentType = "Part-time";
        validInput = true;
      } else {
        System.out.println("Invalid input. Please enter 'full' or 'part'.");
      }
    }

    if (isFullTime) {
      System.out.print("Enter Basic Salary: ");
      salary = input.nextDouble();
    } else {
      System.out.print("Enter Rate per Hour: ");
      double ratePerHour = input.nextDouble();

      System.out.print("Enter Work Days: ");
      int workDays = input.nextInt();

      System.out.print("Enter Overtime Hours: ");
      int overtimeHours = input.nextInt();

      double basicPay = ratePerHour * workDays * 8;
      double overtimePay = ratePerHour * (overtimeHours * 1.25);
      salary = basicPay + overtimePay;

      System.out.println("Part-time Salary Details:");
      System.out.println("Basic Pay: " + basicPay);
      System.out.println("Overtime Pay: " + overtimePay);
    }

    double salaryAfterTax =
      salary - (salary * 0.14 + salary * 0.04 + salary * 0.07);

    String employeeInfo =
      "Name: " +
      name +
      ", Age: " +
      age +
      ", Phone: " +
      phoneNumber +
      ", Address: " +
      address +
      ", Employment Type: " +
      employmentType +
      ", Salary Before Tax: " +
      salary +
      ", Salary After Tax: " +
      salaryAfterTax;

    ArrayList<String> selectedDeptList = departmentArrayLists.get(
      departmentChoice - 1
    );
    selectedDeptList.add(employeeInfo);

    System.out.println("Employee added to " + selectedDeptList.get(0));
    System.out.println("Updated Department Details: " + selectedDeptList);
  }

  public static void writeall(
    ArrayList<ArrayList<String>> departmentArrayLists
  ) {
    for (ArrayList<String> department : departmentArrayLists) {
      String departmentName = department.get(0);
      String currentDir = System.getProperty("user.dir");
      String departmentFolderPath =
        currentDir + File.separator + departmentName;
      File departmentFolder = new File(departmentFolderPath);
      if (!departmentFolder.exists()) {
        departmentFolder.mkdir();
        System.out.println("Created folder: " + departmentFolderPath);
      }

      for (int i = 1; i < department.size(); i++) {
        String employeeInfo = department.get(i);
        String[] infoParts = employeeInfo.split(",");

        if (infoParts.length >= 7) {
          String name = infoParts[0].split(":")[1].trim();
          String age = infoParts[1].split(":")[1].trim();
          String phone = infoParts[2].split(":")[1].trim();
          String address = infoParts[3].split(":")[1].trim();
          String employmentType = infoParts[4].split(":")[1].trim();
          String salaryBeforeTax = infoParts[5].split(":")[1].trim();
          String salaryAfterTax = infoParts[6].split(":")[1].trim();

          String fileName =
            departmentFolderPath + File.separator + name + ".txt";

          try (
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))
          ) {
            writer.write("Employee Name: " + name);
            writer.newLine();
            writer.write("Age: " + age);
            writer.newLine();
            writer.write("Phone: " + phone);
            writer.newLine();
            writer.write("Address: " + address);
            writer.newLine();
            writer.write("Employment Type: " + employmentType);
            writer.newLine();
            writer.write("Salary (Before Tax): " + salaryBeforeTax);
            writer.newLine();
            writer.write("Salary (After Tax): " + salaryAfterTax);
            writer.newLine();
            writer.write("=================================");
            writer.newLine();
            writer.newLine();
            System.out.println(
              "Data for " + name + " written to file: " + fileName
            );
          } catch (IOException e) {
            System.err.println("Error writing to file: " + fileName);
            e.printStackTrace();
          }
        } else {
          System.out.println("Invalid employee data: " + employeeInfo);
        }
      }
    }
  }
}
