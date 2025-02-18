package org.csv.basic;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WritingCSV {
    public static void main(String[] args) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("data.csv",true));
            bufferedWriter.write("2,Uday,CDE,425000\n");
            System.out.println("file written successfully");
            bufferedWriter.close();
        }catch (IOException e){
            System.out.println("File not Found");
        }
    }
}
