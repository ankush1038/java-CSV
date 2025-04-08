package com.bridgelabz.CSVDataHandling.AdvancedProblems;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentListConversion {
    public static void main(String[] args) {

        String fileName = "student_list.csv";
        List<Student> studentList = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(fileName))){
            String[] row;
            boolean isHeader = true;

            while ((row = reader.readNext()) != null){
                if(isHeader) {
                    isHeader = false;
                    continue;
                }

                int id = Integer.parseInt(row[0]);
                String name  = row[1];
                int age = Integer.parseInt(row[2]);
                int marks = Integer.parseInt(row[3]);

                Student student = new Student(id, name, age, marks);
                studentList.add(student);
            }

        }catch (IOException | CsvValidationException e){
            e.printStackTrace();
        }

        for (Student s: studentList){
            System.out.println(s);
        }
    }
}

class Student {
    private int id;
    private String name;
    private int age;
    private int marks;

    public Student(int id, String name, int age, int marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    // Convert to String
    @Override
    public String toString() {
        return "Student { " +
                "ID = " + id +
                ", Name = '" + name + '\'' +
                ", Age = " + age +
                ", Marks = " + marks +
                " }";
    }
}
