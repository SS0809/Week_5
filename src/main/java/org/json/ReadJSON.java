package org.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;
import java.util.Map;

class User{
    private int id;
    private String name;
    private int age;
    private String email;
    private List<String> skills;
    private Map<String, String> address;
}
//Read a JSON file and extract only specific fields (e.g., name, email).
public class ReadJSON {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode user = objectMapper.readTree(new File("student.json"));
            System.out.println("name : "+user.path("name").asText());
            System.out.println("email : "+user.path("email").asText());
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
