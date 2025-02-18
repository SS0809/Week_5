package org.csv.basic;
//3️⃣ Read and Count Rows in a CSV File
//Read a CSV file and count the number of records (excluding the header row).

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import com.opencsv.*;

public class CountRowCSV {
    public static void main(String[] args) {
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader("data.csv"));
            String line ;
            int cnt =0;
            while ((line = bufferedReader.readLine())!=null){
                cnt++;
            }
            System.out.println("Count of lines in CSV file : " +cnt);
            System.out.println("Count of lines in CSV file when not including the header : " +(cnt-1));
        }catch (IOException e){
            System.out.println("OOPs");
        }
    }
}
