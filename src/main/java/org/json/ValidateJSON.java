package org.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.*;

import java.io.File;
import java.io.IOException;

//5️⃣ Validate JSON structure using Jackson.
public class ValidateJSON {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {

            JsonNode jsonNode = objectMapper.readTree(new File("merged.json"));
            JsonNode schemaJSON = objectMapper.readTree(new File("schema.json"));

            JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
            JsonSchema schema = factory.getJsonSchema(schemaJSON);

            ProcessingReport report = schema.validate(jsonNode);
            if (report.isSuccess()){
                System.out.println(true);
            }else {
                System.out.println("error in validation");
                report.forEach(msg -> System.out.println(msg));
            }
        }catch (IOException e){
            System.out.println(e);
        } catch (ProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
