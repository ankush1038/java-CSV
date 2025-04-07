package com.bridgelabz.CSVDataHandling.IntermediateProblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterScore {
    public static void main(String[] args) {
        String text;
        String csvFile = "Records.csv";

        try(BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            reader.readLine();

            System.out.println("Students with more than 80 marks: ");
            while ((text = reader.readLine()) != null){
                String[] data = text.split(",");

                String name = data[0];
                String rollNumber = data[1];
                int marks = Integer.parseInt(data[2]);

                if(marks > 80){
                    System.out.println("Name: " + name + ", Roll: " + rollNumber + ", Marks: "+ marks);
                }
            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
