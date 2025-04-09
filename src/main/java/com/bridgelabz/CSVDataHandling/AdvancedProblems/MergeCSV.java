package com.bridgelabz.CSVDataHandling.AdvancedProblems;

import com.opencsv.*;

import java.io.*;
import java.util.*;

public class MergeCSV{
    public static void main(String[] args) throws Exception {
        Map<String,String[]> map1=new HashMap<>();
        Map<String, String[]> map2=new HashMap<>();

        CSVReader reader1=new CSVReader(new FileReader("file1.csv"));

        reader1.readNext();
        String[] line;
        while((line=reader1.readNext())!=null){
            map1.put(line[0], new String[]{line[1],line[2]});
        }
        reader1.close();



        CSVReader reader2=new CSVReader(new FileReader("file2.csv"));
        reader2.readNext();
        String[] line2;
        while((line2=reader2.readNext())!=null){
            map2.put(line2[0], new String[]{line2[1],line2[2]});
        }
        reader2.close();


        CSVWriter writer=new CSVWriter(new FileWriter("mergedFile.csv"));
        for(String key:map1.keySet()){
            if(map2.containsKey(key)){
                String[] s1=map1.get(key);
                String[] s2=map2.get(key);
                writer.writeNext(new String[]{key, s1[0],s1[1],s2[0],s2[1]});
            }
        }
        writer.close();
    }
}
