package com.bridgelabz.CSVDataHandling.AdvancedProblems;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.regex.*;

public class EmailValidator {
    public static void main(String[] args) {

        String fileName = "contacts.csv";
        String emailRegex = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
       // String emailRegex = "^[a-zA-Z0-9]+@[a-zA-Z]+\\.[a-zA-Z]{2,}$";
        // Alternate
        String phoneRegex = "\\d{10}";

        Pattern emailPattern = Pattern.compile(emailRegex);
        Pattern phonePattern = Pattern.compile(phoneRegex);

        try(CSVReader reader = new CSVReader(new FileReader(fileName))){
            String[] row;
            boolean isHeader = true;

            while ((row = reader.readNext()) != null){
                if(isHeader) {
                    isHeader = false;
                    continue;
                }

                String name = row[0].trim();
                String email = row[1].trim();
                String phone = row[2].trim();

                boolean isEmailValid = emailPattern.matcher(email).matches();
                boolean isPhoneValid = phonePattern.matcher(phone).matches();

                if (!isEmailValid || !isPhoneValid){
                    System.out.println("Invalid entry found: ");
                    System.out.println("Name: " + name + ", Email: " + email + ", Phone: " + phone);

                    if (!isEmailValid)
                        System.out.println("Invalid Email Format");

                    if (!isPhoneValid)
                        System.out.println("Phone number must be exactly 10 digits");

                    System.out.println("-------------------------------------------------");
                }
            }

        } catch (IOException  | CsvValidationException e){
            e.printStackTrace();
        }

    }
}
