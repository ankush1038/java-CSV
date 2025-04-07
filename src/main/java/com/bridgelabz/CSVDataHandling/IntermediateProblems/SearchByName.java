package com.bridgelabz.CSVDataHandling.IntermediateProblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchByName {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter name to search: ");
        String searchName = sc.nextLine().trim();

        String text;
        String filePath = "employees.csv";
        boolean found = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            reader.readLine();

            while ((text = reader.readLine()) != null){
                String[] data = text.split(",");

                String name = data[0];
                String department = data[1];
                String salary = data[2];

                if(name.equals(searchName)){
                    System.out.println("Department: " + department);
                    System.out.println("Salary: " + salary);
                    found = true;
                    break;
                }
            }

            if(!found){
                System.out.println("Employee " + searchName + "not found");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
