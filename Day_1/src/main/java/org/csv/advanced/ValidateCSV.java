package org.csv.advanced;
//8️⃣ Validate CSV Data Before Processing
//Ensure that the "Email" column follows a valid email format using regex.
//Ensure that "Phone Numbers" contain exactly 10 digits.
//Print any invalid rows with an error message.
import com.opencsv.*;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateCSV {
    public static void main(String[] args) {
        try{
            CSVReader csvReader = new CSVReader(new FileReader("validate.csv"));
            String[] line ;
            csvReader.readNext();
            while (
                    (line = csvReader.readNext()) != null
            ){
                String email_regex = "^[0-9A-Za-z._%+-]+@[a-zA-Z]+\\\\.[a-z]{2,}$";
                Pattern p0 = Pattern.compile(email_regex);
                Matcher m0 = p0.matcher(line[2]);

                String number_regex = "^\\+\\d{1,3}\\s*\\d{5}\\s*\\d{5}$";
                Pattern p1 = Pattern.compile(number_regex);
                Matcher m1 = p1.matcher(line[3]);

                if (!m0.find() && !m1.find()) {
                    System.out.println("ID : " + line[0] + " is not valid.");
                } else {
                    System.out.println("Valid entry: " + String.join(", ", line));
                }
            }
        }catch (IOException e){
            System.out.println(e);
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
}
