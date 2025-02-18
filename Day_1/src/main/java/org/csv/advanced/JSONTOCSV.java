package org.csv.advanced;


import com.opencsv.CSVWriter;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class JSONTOCSV {
    static void toCSV(JSONObject jsonObject) {
        try {
            CSVWriter csvWriter = new CSVWriter(new FileWriter("csvfromjson.csv"));
            for(String te :jsonObject.keySet()){
                String[] s = new String[]{te,jsonObject.getString(te)};
                csvWriter.writeNext(s);
            }
            csvWriter.close();
        }catch (IOException e){
            System.out.println(e);
        }
    }
    public static void main(String args[])
    {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("Full Name", "Ritu Sharma");
        jsonObject.put("Roll No.", "1704310046");
        jsonObject.put("Tuition Fees", "65400");

        System.out.print(jsonObject);
        toCSV(jsonObject);
    }
}
