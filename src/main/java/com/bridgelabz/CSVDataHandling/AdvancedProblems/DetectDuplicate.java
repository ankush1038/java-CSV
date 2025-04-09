package com.bridgelabz.CSVDataHandling.AdvancedProblems;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.*;

public class DetectDuplicate {
    public static void main(String[] args) throws Exception {
        Set<String> set = new HashSet<>();
        List<String[]> list = new ArrayList<>();

        CSVReader reader = new CSVReader(new FileReader("duplicates.csv"));
        reader.readNext();

        String[] line;
        while ((line = reader.readNext()) != null) {
            String id = line[0];
            if (set.contains(id)) {
                list.add(line);
            }
            else {
                set.add(id);
            }

        }
        reader.close();

        if (list.isEmpty()) {
            System.out.println("No duplicate");
        }
        else {
            for (String[] record : list) {
                System.out.println(Arrays.toString(record));
            }
        }
    }
}
