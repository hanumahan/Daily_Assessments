package week1.com.example.test;

import week1.com.example.company.Manager;

public class TestManager {
    public static void main(String[] args) {
        Manager manager = new Manager("Jane Doe");
        System.out.println("Manager Name: " + manager.getName());
    }
}
