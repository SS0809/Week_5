package org.csv.intermediate;
//Sort CSV Records by a Column
//Read a CSV file and sort the records by Salary in descending order.
//Print the top 5 highest-paid employees.

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Period;
import java.util.*;

class Employee{
    public Employee(int id, String name, String department, int salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
    int id;
    String name;
    String department;
    int salary;
}
public class SortColumn {
    public static void main(String[] args) {
        try {
            CSVReader csvReader = new CSVReader(new FileReader("employees.csv"));
            List<String[]> csv = csvReader.readAll();
            int cnt=0;
            List<Employee> employees = new LinkedList<>();
            for (String[] temp : csv) {
                if(cnt>0){
                    Employee el = new Employee(Integer.parseInt(temp[0]),temp[1],temp[2],Integer.parseInt(temp[3]));
                    employees.add(el);
//                        for (String t : temp) {
//                            System.out.print(t + "|");
//                        }System.out.println();
                }
                cnt++;
            }
            employees.sort(
                    (Employee o1 , Employee o2 ) ->
                            Integer.compare(o2.salary,o1.salary)
            );
            for(int i=0;i<5;i++){
                System.out.println(employees.get(i).name);
            }
        }catch (IOException | CsvValidationException e){
            System.out.println(e);
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }
    }
}
