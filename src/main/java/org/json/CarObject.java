package org.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//Convert a Java object (Car) into JSON format.
public class CarObject {
    String name ;
    String fuel ;
    double price ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static void main(String[] args) {
        CarObject carObject = new CarObject();
        carObject.setFuel("Petrol");
        carObject.setName("Nano");
        carObject.setPrice(210000.0);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            System.out.println(objectMapper.writeValueAsString(carObject));

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
