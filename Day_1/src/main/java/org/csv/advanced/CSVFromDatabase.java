package org.csv.advanced;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import com.opencsv.CSVWriter;

import java.util.Map;

public class CSVFromDatabase {
    public static void main(String[] args) {
        try {
            Map<String, String> env = EnvLoader.loadEnv(".env");

            String dbUrl = env.get("DB_URL");
            String dbUser = env.get("DB_USER");
            String dbPass = env.get("DB_PASS");

            String query = "SELECT employee_id, name, department, salary FROM employees";

            try (Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPass);
                 Statement stmt = con.createStatement();
                 ResultSet rs = stmt.executeQuery(query);
                 FileWriter fw = new FileWriter("employees_report.csv");
                 CSVWriter writer = new CSVWriter(fw)) {

                writer.writeNext(new String[]{"ID", "Name", "Dept", "Salary"});

                while (rs.next()) {
                    String id = String.valueOf(rs.getInt("employee_id"));
                    String name = rs.getString("name");
                    String dept = rs.getString("department");
                    String salary = String.valueOf(rs.getDouble("salary"));

                    writer.writeNext(new String[]{id, name, dept, salary});
                }

                System.out.println("CSV Report Generated!");
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}