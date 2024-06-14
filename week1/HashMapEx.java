package week1;

import java.util.HashMap;
import java.util.Map;

public class HashMapEx {
    public static void main(String[] args) {
        HashMap<String, Integer> students = new HashMap<>();
        students.put("hanuma", 22);
        students.put("philip", 27);
        students.put("Charan", 18);

        for (Map.Entry<String, Integer> entry : students.entrySet()) {
            System.out.println("Name: " + entry.getKey() + ", Marks: " + entry.getValue());
        }
    }
}

