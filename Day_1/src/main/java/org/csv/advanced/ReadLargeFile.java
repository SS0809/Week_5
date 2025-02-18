package org.csv.advanced;
//Given a large CSV file (500MB+), implement a memory-efficient way to read it in chunks.
//Process only 100 lines at a time and display the count of records processed.

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadLargeFile {
    public static void main(String[] args) {
        try {
            //create the file
            CSVWriter csvWriter = new CSVWriter(new FileWriter("largefile.txt"));
            String[] s = new String[]{"\"1\"", "\"Alice\"", "\"20\"", "\"88\"", "\"B\""};
            for (int i = 0; i < 100*100*1144; i++) {
                csvWriter.writeNext(s);
                if (i/50000==0)System.out.println("Waits creating file"+i%50000);
            }
            csvWriter.close();
            CSVReader csvReader = new CSVReader(new FileReader("largefile.txt"));
            String[] line0;
            int cnt=0;
            while (
                    ((line0 = csvReader.readNext()) != null)
            ){
                cnt++;
                if(cnt==100)break;
                System.out.print(line0[0]);
                System.out.println(line0[1]);
            }
            csvReader.close();
            Path path = Paths.get("largefile.txt");
            Files.delete(path);


        }catch (IOException e){
            System.out.println(e);
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
}
