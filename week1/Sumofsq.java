package week1;

import java.util.Arrays;

public class Sumofsq {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};

        int sos = Arrays.stream(numbers)
                                 .map(n -> n * n)
                                 .sum();

        System.out.println("Sum of squares: " + sos);
    }
}
