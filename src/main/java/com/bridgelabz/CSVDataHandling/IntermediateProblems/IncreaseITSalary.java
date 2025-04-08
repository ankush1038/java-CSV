package com.bridgelabz.CSVDataHandling.IntermediateProblems;

import java.io.*;
import java.nio.Buffer;

public class IncreaseITSalary {
    public static void main(String[] args) {
        String inputFile = "IT_employees.csv";
        String outputFile = "updated_employees.csv";

        String text;

        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))
                ){
            String header = reader.readLine();
            writer.write(header);
            writer.newLine();

            while ((text = reader.readLine()) != null){
                String[] data = text.split(",");

                String name = data[0];
                String department = data[1];
                Double salary = Double.parseDouble(data[2]);

                if(department.equals("IT")){
                    salary *= 1.10;
                }

                String updatedText = name + ", " + department + ", " + String.format("%.2f", salary);
                writer.write(updatedText);
                writer.newLine();

                System.out.println("Updated records printed successfully");
            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

/*
Name,Department,Salary
Ankush, IT, 72600.00  Salary increased
Akshit, HR, 55000.00
Nitesh, IT, 84700.00   Salary Increased
Praveen, Finance, 62000.00
Sehaj, Engineering, 65000.00

 */
