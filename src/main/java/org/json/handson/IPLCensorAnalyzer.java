package org.json.handson;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.csv.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class IPLCensorAnalyzer {

    public static void main(String[] args) throws IOException {
        // Process JSON File
        processJson("ipl_data.json", "ipl_censored.json");

        // Process CSV File
        processCsv("ipl_data.csv", "ipl_censored.csv");
    }

    // Function to process JSON File
    public static void processJson(String inputFile, String outputFile) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Map<String, Object>> matches = objectMapper.readValue(new File(inputFile), List.class);

        for (Map<String, Object> match : matches) {
            match.put("team1", maskTeamName((String) match.get("team1")));
            match.put("team2", maskTeamName((String) match.get("team2")));
            match.put("winner", maskTeamName((String) match.get("winner")));
            match.put("player_of_match", "REDACTED");
        }

        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(outputFile), matches);
        System.out.println("Censored JSON file saved as " + outputFile);
    }

    // Function to process CSV File
    public static void processCsv(String inputFile, String outputFile) throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(inputFile));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());

        List<Map<String, String>> records = csvParser.getRecords().stream()
                .map(CSVRecord::toMap)
                .collect(Collectors.toList());

        for (Map<String, String> record : records) {
            record.put("team1", maskTeamName(record.get("team1")));
            record.put("team2", maskTeamName(record.get("team2")));
            record.put("winner", maskTeamName(record.get("winner")));
            record.put("player_of_match", "REDACTED");
        }

        // Write back to new CSV file
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputFile));
             CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                     .withHeader("match_id", "team1", "team2", "score_team1", "score_team2", "winner", "player_of_match"))) {

            for (Map<String, String> record : records) {
                csvPrinter.printRecord(record.values());
            }
        }

        System.out.println("Censored CSV file saved as " + outputFile);
    }

    // Function to mask team names
    private static String maskTeamName(String team) {
        String[] parts = team.split(" ");
        return parts[0] + " ***";
    }
}
