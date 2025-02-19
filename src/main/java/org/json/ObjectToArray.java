package org.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.ArrayList;
import java.util.Map;

//Convert a list of Java objects into a JSON array.
class Intern{
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public String getLaptopType() {
        return laptopType;
    }

    public void setLaptopType(String laptopType) {
        this.laptopType = laptopType;
    }

    public double getSalarySlab() {
        return salarySlab;
    }

    public void setSalarySlab(double salarySlab) {
        this.salarySlab = salarySlab;
    }

    String name;
    String Department;
    String laptopType;
    double salarySlab;
    public Intern(int id, String name, String department, String laptopType, double salarySlab) {
        this.id = id;
        this.name = name;
        Department = department;
        this.laptopType = laptopType;
        this.salarySlab = salarySlab;
    }
}
public class ObjectToArray {
    public static void main(String[] args)  {
        ArrayList<Intern> listIntern = new ArrayList<>();
        listIntern.add(new Intern(1,"Saurabh","IT","ASUS",575000));
        listIntern.add(new Intern(2,"Uday","IT","ASUS",575000));
        listIntern.add(new Intern(3,"Nishant","IT","Lenovo",575000));
        listIntern.add(new Intern(4,"Pankaj","IT","HP",575000));
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(listIntern);
            System.out.println(json);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
