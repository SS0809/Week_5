package org.csv.intermediate;
//4️⃣ Filter Records from CSV
//Read a CSV file and filter students who have scored more than 80 marks.
//Print only the qualifying records.
import com.opencsv.*;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FilterRecords {
    public static void main(String[] args) {
            try {
                CSVReader csvReader = new CSVReader(new FileReader("student.csv"));
                String[] line ;
                int cnt =0;
                while (
                        (line = csvReader.readNext()) != null
                ){
                    if(cnt>0 && Integer.parseInt(line[3])>80) {
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

    }
}
