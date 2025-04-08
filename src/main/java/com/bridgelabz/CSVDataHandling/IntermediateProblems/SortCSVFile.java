package com.bridgelabz.CSVDataHandling.IntermediateProblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SortCSVFile {
    public static void main(String[] args) {
        String fileName = "employees.csv";
        List<Employee> employeeList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine(); // Skip header
            if (line == null) {
                System.out.println("CSV file is empty.");
                return;
            }

            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length != 3) continue; // skip invalid rows

                String name = fields[0].trim();
                String department = fields[1].trim();
                double salary =Double.parseDouble(fields[2].trim());

                employeeList.add(new Employee(name, department, salary));
            }

            employeeList.sort((e1, e2) -> Double.compare(e2.salary, e1.salary));

            System.out.println("Top 5 Highest-Paid Employees:");
            System.out.println("----------------------------------");
            System.out.print("Name" + "Department" + "Salary");

            for (int i = 0; i < Math.min(5, employeeList.size()); i++) {
                Employee emp = employeeList.get(i);
                System.out.printf("%-10s %-15s %.2f\n", emp.name, emp.department, emp.salary);
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

class Employee {
    String name;
    String department;
    double salary;

    Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
}
