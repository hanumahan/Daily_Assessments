package week1;
import java.util.Scanner;

public class FactorialMethod {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();
        int res=calculateFactorial(n);
        System.out.println("Factorial of " + n + " is: " +res);
    }
    
    public static int calculateFactorial(int n) {
        if (n == 0) {
            return 1;
        }
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}
