package org.json.handson;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CsvToJsonConverter {
    public static void main(String[] args) {
        String csvFilePath = "data.csv";  // Replace with your CSV file

        try (FileReader reader = new FileReader(csvFilePath);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {

            List<Map<String, String>> jsonList = new ArrayList<>();

            for (CSVRecord record : csvParser) {
                jsonList.add(record.toMap());
            }

            // Convert list to JSON
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonOutput = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonList);

            System.out.println("Converted JSON:");
            System.out.println(jsonOutput);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
