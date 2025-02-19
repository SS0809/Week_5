package org.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

//Parse JSON and filter only those records where age > 25.
public class ParseJSON {
    public static void main(String[] args) {
        JsonMapper jsonMapper = new JsonMapper();
        try {
            JsonNode jsonNode = jsonMapper.readTree(new File("studentrecord.json"));
            Iterator<JsonNode> iterator = jsonNode.iterator();
            ObjectMapper objectMapper = new ObjectMapper();
            while (iterator.hasNext()){
                JsonNode record = iterator.next();
                if (record.get("age").asInt() > 25) {
                    System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(record));
                }
            }
        }catch (IOException e){
            System.out.println(e);
        }
    }
}
