package org.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

//4️⃣ Merge two JSON objects into one.
public class MergeJson {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            //JsonNode is base class of ObjectNode && ArrayNode
            JsonNode j0 = objectMapper.readTree(new File("student.json"));
            JsonNode j1 = objectMapper.readTree(new File("person.json"));
            ObjectNode mergedJson = objectMapper.createObjectNode();
            mergedJson.setAll((ObjectNode) j0);
            mergedJson.setAll((ObjectNode) j1);
            objectMapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValue(new File("merged.json"),mergedJson);
            System.out.println(mergedJson);
        }catch (IOException e){
            System.out.println(e);
        }
    }
}
