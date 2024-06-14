package week1;

import java.util.Scanner;

public class PrimeMethod {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();
        
        if (Prime(n)) {
            System.out.println(n + " is a prime number.");
        } else {
            System.out.println(n + " is not a prime number.");
        }
    }
    
    public static boolean Prime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i<n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
