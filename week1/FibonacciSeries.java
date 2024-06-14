package week1;
import java.util.Scanner;

public class FibonacciSeries {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of terms for the Fibonacci series: ");
        int n = scanner.nextInt();
        
        if (n <= 0) {
            System.out.println("Please enter a positive number.");
        } else {
            int first = 0, second = 1;
            int count = 0;
            
            System.out.print("Fibonacci series up to " + n + " terms: ");
            while (count < n) {
                System.out.print(first + " ");
                int next = first + second;
                first = second;
                second = next;
                count++;
            }
        }
    }
}
