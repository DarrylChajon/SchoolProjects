/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.midtermproject;
/**
 *
 * @author darry
 */
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
public class MidtermProject {
    private static int option;
   public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       Employee[] employees = {};
       int h = 0;
       do {
          switch (menu(input)) {
              case 1:
                  employees = loadEmployee(input, employees);
                  break;
              case 2:
                  employees = addEmployee(input, employees);
                  System.out.println("Added");
                  break;
              case 3:
                  employees = removeEmployee(input, employees);
                  System.out.println("Removed");
                  break;
              case 4:
                  displayEmployees(employees);
                  break;
              case 5:
                  getEmployee(input, employees);
                  break;
              case 6:
                  salaryRange(input, employees);
                  break;
              case 7:
                  employees = sortHighLowSalary(input, employees);
                  System.out.println("Sorted, click 4 to see");
                  break;
              case 8:
                  employees = sortLowHighName(input, employees);
                  System.out.println("Sorted, click 4 to see");
                  break;
              case 9:
                  employees = sortLowHighID(input, employees);
                  System.out.println("Sorted, click 4 to see");
                  break;
              case 10:
                  employees = new Employee[0];
                  System.out.println("Employee data cleared");
                  break;
              case 11:
                  h = 1;
                  System.out.println("Thank you come again");
                  break;
              default:
                  System.out.println("Invalid input, try again");
                  break;
          }
       } while (h == 0);
      }

   public static int menu(Scanner input) {
       System.out.println("Choose one of the following options: ");
       System.out.println("(1) Load employee data");
       System.out.println("(2) Add new employee");
       System.out.println("(3) Remove an employee");
       System.out.println("(4) Display all employees");
       System.out.println("(5) Retrieve employee data with ID");
       System.out.println("(6) Retrieve employees with salaries based on range");
       System.out.println("(7) Sort employees by salary (highest to lowest)");
       System.out.println("(8) Sort employees by name (alphabetical order)");
       System.out.println("(9) Sort employees by ID number (lowest to highest)");
       System.out.println("(10) Clear all employee data    ");
       System.out.println("(11) Exit program");
       option = input.nextInt();
       return option;
   }
   public static Employee[] loadEmployee(Scanner input, Employee[] employees) {
          System.out.println("How many employees would you like to load?");
          int m = input.nextInt();
          employees = new Employee[m];
          for (int i = 0; i < m; i++) {
             input.nextLine();
             System.out.println("Enter employee " + (i + 1) + " name");
             String name = input.nextLine();
             System.out.println("Enter employee 5 digit ID");
             int ID = input.nextInt();
             System.out.println("Enter employee salary");
             double salary = input.nextDouble();
             Employee newEmployee = new Employee(name, ID, salary);
             employees[i] = newEmployee;
           }
          return employees;
        }
   public static Employee[] addEmployee(Scanner input, Employee[] employees) {
       System.out.println("Enter employee name");
       input.nextLine();
        String name = input.nextLine();
       System.out.println("Enter employee 5 digit ID");
       int ID = input.nextInt();
       System.out.println("Enter employee salary");
       double salary = input.nextDouble();
       Employee newEmployee = new Employee(name, ID, salary);
       Employee[] temp = new Employee[employees.length + 1];
       for (int i = 0; i < temp.length - 1; i++) {
            temp[i] = employees[i];
       }
       temp[temp.length - 1] = newEmployee;
       employees = temp.clone();
       return employees;
        }
   public static Employee[] removeEmployee(Scanner input, Employee[] employees) {
       System.out.println("Enter 5 digit ID of employee you want removed");
       int ID = input.nextInt();
       for (int i = 0; i < employees.length; i++) {
           if (ID == employees[i].getID()) {
               employees[i] = new Employee(null, 0, 0);
           }
       }
       return employees;
   }
   public static Employee[] sortHighLowSalary(Scanner input, Employee[] employees) {
       int size = employees.length;
       for (int i = 0; i < size - 1; i++) {
           for (int j = 0; j < size - 1; j++) {
               if (employees[j].getSalary() < employees[j + 1].getSalary()) {
                   Employee temp = employees[j];
                   employees[j] = employees[j+1];
                   employees[j+1] = temp;
               }
           }
       }
       return employees;
   }
   public static Employee[] sortLowHighID(Scanner input, Employee[] employees) {
       int size = employees.length;
       for (int i = 0; i < size - 1; i++) {
           for (int j = 0; j < size - 1; j++) {
               if (employees[j].getID() > employees[j + 1].getID()) {
                   Employee temp = employees[j];
                   employees[j] = employees[j+1];
                   employees[j+1] = temp;
               }
           }
       }
       return employees;
   }
   public static Employee[] sortLowHighName(Scanner input, Employee[] employees) {
       int size = employees.length;
       for (int i = 0; i < size - 1; i++) {
           for (int j = 0; j < size - 1; j++) {
               if (employees[j].getName().charAt(0) > employees[j + 1].getName().charAt(0)) {
                   Employee temp = employees[j];
                   employees[j] = employees[j+1];
                   employees[j+1] = temp;
               }
           }
       }
       return employees;
   }
   public static void displayEmployees(Employee[] employees) {
       for (int i = 0; i < employees.length; i++) {
           System.out.println(employees[i].toString());
       }
   }

    /**
     *
     * @param input
     * @param employees
     */
    public static void getEmployee(Scanner input, Employee[] employees) {
       System.out.println("Enter 5 digit employee ID");
       int ID = input.nextInt();
       int i;
       boolean exists = false;
       for (i = 0; i < employees.length; i++) {
           if (employees[i].getID() == ID) {
               exists = true;
               break;
           }
       }
       if (exists) {
           System.out.println(employees[i].toString());
       }
       else {
           System.out.println("Employee not found");
       }
   }
   public static void salaryRange(Scanner input, Employee[] employees) {
       System.out.println("Enter lowest salary");
       double low = input.nextDouble();
       System.out.println("Enter highest salary");
       double high = input.nextDouble();
       for (int i = 0; i < employees.length; i++) {
           if (employees[i].getSalary() >= low && employees[i].getSalary() <= high) {
               System.out.println(employees[i].toString());
           }
       }
   }
}