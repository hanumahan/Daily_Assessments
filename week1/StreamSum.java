package week1;

import java.util.Arrays;

public class StreamSum {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        
        int sum = Arrays.stream(numbers).sum();
        
        System.out.println("Sum of all elements: " + sum);
    }
}
