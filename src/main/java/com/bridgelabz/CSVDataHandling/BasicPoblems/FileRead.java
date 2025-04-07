package com.bridgelabz.CSVDataHandling.BasicPoblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileRead {
    public static void main(String[] args) {
        String filePath = "employee.csv";

        try(BufferedReader reader = new BufferedReader( new FileReader(filePath))) {
            String text;
            while((text = reader.readLine()) != null){
                String[] columns = text.split(",");
                System.out.print("ID: " + columns[0] + ", Name: " + columns[1] + ", Age: " + columns[2] + ", Marks: " + columns[3] + "\n");
                System.out.println("--------------------------");
            }

        } catch (IOException e){
            e.printStackTrace();
        }

        
    }
}
