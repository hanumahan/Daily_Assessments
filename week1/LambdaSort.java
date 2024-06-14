package week1;

import java.util.Arrays;


public class LambdaSort {
    public static void main(String[] args) {
        String[] strings = {"apple", "orange", "banana", "grape"};
        
        Arrays.sort(strings, (s1, s2) -> s2.compareTo(s1));

        System.out.println("Strings in descending order: " + Arrays.toString(strings));
    }
}

