package org.csv.advanced;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//
//9️⃣ Convert CSV Data into Java Objects
//Read a CSV file and convert each row into a Student Java object.
//Store the objects in a List<Student> and print them.
class Student{
    int id;

    public Student(int id, String name, String email, String number) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.number = number;
    }

    String name ;
    String email;
    String number;
}
public class CSVToObject {
    public static void main(String[] args) {
        try{
            CSVReader csvReader = new CSVReader(new FileReader("validate.csv"));
            String[] line ;
            csvReader.readNext();
            ArrayList<Student> students = new ArrayList<>();
            while (
                    (line = csvReader.readNext()) != null
            ){
                String number_regex = "\\s*";
                Pattern p1 = Pattern.compile(number_regex);
                Matcher m1 = p1.matcher(line[3]);
                String num = m1.replaceAll("");
                students.add(new Student(Integer.parseInt(line[0]), line[1], line[2], num));
            }

            for(Student st : students){
                System.out.println("Id: "+st.id + " Email: " + st.email + " Name: " + st.name + " Number: " + st.number + ",");
            }
        }catch (IOException e){
            System.out.println(e);
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
}
