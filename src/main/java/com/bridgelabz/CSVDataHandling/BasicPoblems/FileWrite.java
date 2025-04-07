package com.bridgelabz.CSVDataHandling.BasicPoblems;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWrite {
    public static void main(String[] args) {
        String filePath = "Employee.csv";

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("ID, Name, Department, Salary\n");
            writer.write("104, Ankush, Engineering, 1000000\n");
            writer.write("105, Akshit, HR, 10000000\n");
            writer.write("106, Praveen, Management, 100000000\n");
            writer.write("107, Nitesh, CEO, 1000000000\n");

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
