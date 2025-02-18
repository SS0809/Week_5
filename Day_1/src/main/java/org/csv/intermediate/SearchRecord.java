package org.csv.intermediate;
import com.opencsv.*;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class SearchRecord {
    String getEmployee(String name){
        try {
            CSVReader csvReader = new CSVReader(new FileReader("employees.csv"));
            String[] line ;
            int cnt =0;
            while (
                    (line = csvReader.readNext()) != null
            ){
                if(cnt>0 && line[1].equals(name)) {
                    for (String temp : line) {
                        System.out.print(temp + " ");
                    }
                    System.out.println();
                }
                cnt++;
            }
        }catch (IOException | CsvValidationException e){
            System.out.println(e);
        }
        return new String();
    }
    public static void main(String[] args) {
        SearchRecord sr = new SearchRecord();
        sr.getEmployee("Saurabh");
    }
}
