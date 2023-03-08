/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.midtermproject;

/**
 *
 * @author darry
 */
public class Employee {
   private String name;
   private int ID;
   private double salary;
   public Employee(String name, int ID, double salary) {
      this.name = name;
      this.ID = ID;
      this.salary = salary;
   }
   public String getName() {
      return name;
   }
   public int getID() {
      return ID;
   }
   public double getSalary() {
      return salary;
   }

    /**
     *
     * @return
     */
    @Override
   public String toString() {
      return name + "   " + "ID: " + ID + "    " + "Salary:$" + salary;
   }
}