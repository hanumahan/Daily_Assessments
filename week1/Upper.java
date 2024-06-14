package week1;

import java.util.Arrays;
import java.util.List;

public class Upper {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "orange", "banana", "grape","potato");

        strings.forEach(s -> System.out.println(s.toUpperCase()));
    }
}
