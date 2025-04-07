package com.bridgelabz.CSVDataHandling.BasicPoblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVRowCounter {
    public static void main(String[] args) {
        String filePath = "Employee.csv"; // Make sure this file exists at the project root
        int rowCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Read and skip the header
            reader.readLine();

            // Count remaining lines
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    rowCount++;
                }
            }

            System.out.println("Number of data rows: " + rowCount);
        } catch (IOException e) {
            System.out.println("Error reading file");
            e.printStackTrace();
        }
    }
}

/*

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVRowCounter {
    public static void main(String[] args) {
        String filePath = "Employee.csv"; // Make sure this file exists in the project root
        int rowCount = 0;

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;

            // Skip the header
            reader.readNext();

            // Count the remaining rows
            while ((nextLine = reader.readNext()) != null) {
                rowCount++;
            }

            System.out.println("Number of data rows: " + rowCount);
        } catch (IOException e) {
            System.out.println("Error reading CSV file");
            e.printStackTrace();
        }
    }
}

 */

