package org.json.handson;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.json.XML;

import java.io.File;
import java.io.IOException;

public class JsonToXmlConverter {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JSONObject json = new JSONObject(objectMapper.readTree(new File("data.json")).toString());
            String xml = XML.toString(json);

            System.out.println("Converted XML:");
            System.out.println(xml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
