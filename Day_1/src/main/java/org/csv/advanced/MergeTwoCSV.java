package org.csv.advanced;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//Merge Two CSV Files
//You have two CSV files:
//        students1.csv (contains ID, Name, Age)
//students2.csv (contains ID, Marks, Grade)
//Merge both files based on ID and create a new file containing all details.
public class MergeTwoCSV {
    public static void main(String[] args) {
        try{
            CSVReader csvReader0 = new CSVReader(new FileReader("students1.csv"));
            CSVReader csvReader1 = new CSVReader(new FileReader("students2.csv"));
            String[] line0 ;
            String[] line1 ;
            csvReader0.readNext();
            csvReader1.readNext();
            CSVWriter csvWriter = new CSVWriter(new FileWriter("merge.csv"));
            while (
                    ((line0 = csvReader0.readNext()) != null) &&
                    ((line1 = csvReader1.readNext()) != null)
            ){
                if(line0[0].equals(line1[0])) {
                    String[] ans = new String[line0.length + line1.length-1];
                    System.arraycopy(line0, 0, ans, 0, line0.length);
                    System.arraycopy(line1, 1, ans, line0.length, line1.length-1);
                    System.out.println(String.join(", ", ans));
                    csvWriter.writeNext(ans);
                }
            }
            csvWriter.close();
        }catch (IOException e){
            System.out.println(e);
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
}
