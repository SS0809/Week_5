package org.csv.advanced;
//1️⃣2️⃣ Detect Duplicates in a CSV File
//Read a CSV file and detect duplicate entries based on the ID column.
//Print all duplicate records.

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class DetectDuplicates {
    public static void main(String[] args) {
        try {
            CSVReader csvReader = new CSVReader(new FileReader("duplicate.csv"));
            csvReader.readNext();
            HashSet<Integer> hs = new HashSet<>();
            String[] line;
            while (
                    ((line = csvReader.readNext()) != null)
            ){
                if(!hs.add(Integer.parseInt(line[0]))){
                    System.out.println(Integer.parseInt(line[0])+" "+line[1]);
                }
            }

        }catch (IOException e){
            System.out.println(e);
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
}
