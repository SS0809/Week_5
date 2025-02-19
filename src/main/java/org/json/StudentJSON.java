package org.json;

//Create a JSON object for a Student with fields: name, age, and subjects (array).
public class StudentJSON {
    String name = "Saurabh";
    int age = 21;
    String[] subj = {"MAths","TOC","PHYSics"};
    public static void main(String[] args) {
        StudentJSON studentJSON = new StudentJSON();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name",studentJSON.name);
        jsonObject.put("age",studentJSON.age);
        JSONArray subj = new JSONArray(studentJSON.subj);
        jsonObject.put("subjects",subj);
        System.out.println(jsonObject);
    }
}
