package week1;

import java.util.Scanner;

public class SwapNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the first number ");
        int a = scanner.nextInt();
        
        System.out.print("Enter the second number ");
        int b = scanner.nextInt();
        
        System.out.println("Before swap: a = " + a + ", b = " + b);
        
        a = a + b;
        b = a - b;
        a = a - b;
        
        System.out.println("After swap: a = " + a + ", b = " + b);
    }
}
