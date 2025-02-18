package org.csv.basic;
//1️⃣ Read a CSV File and Print Data
//Read a CSV file containing student details (ID, Name, Age, Marks).
//Print each record in a structured format.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSV {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("data.csv"));
            String line;
            while ((line = reader.readLine())!=null){
                line = line.replaceAll("\\s+","");
                String[] re = line.split(",");
                for (int i= 0 ;i<re.length;i++)
                    System.out.print(re[i]+" | ");
                System.out.println();
            }
        }catch (IOException e1){
            System.out.println("OOPS:)");
        }
    }
}
