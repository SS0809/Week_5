package org.csv.intermediate;
import com.opencsv.*;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
//Modify a CSV File (Update a Value)
//Read a CSV file and increase the salary of employees from the "IT" department by 10%.
//Save the updated records back to a new CSV file.


public class ModifyCSV {
    public static void main(String[] args) {
        try {
            CSVReader csvReader = new CSVReader(new FileReader("employees.csv"));
            List<String[]> csv = csvReader.readAll();
            for (String[] temp : csv){
                if(temp[2].equals("IT")) {
                    int salary  = Integer.parseInt(temp[3]);
                    salary+=salary / 10;
                    temp[3] = String.valueOf(salary);
                    for (String t : temp) {
                        System.out.print(t+"|");
                    }
                    System.out.println();
                }
            }
            CSVWriter csvWriter = new CSVWriter(new FileWriter("employees.csv"));
            csvWriter.writeAll(csv);
            csvWriter.close();
        }catch (IOException | CsvValidationException e){
            System.out.println(e);
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }
    }
}
