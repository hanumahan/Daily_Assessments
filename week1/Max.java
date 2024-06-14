package week1;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Max {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 5, 7, 2, 8, 10);

        Optional<Integer> maxNumber = numbers.stream()
                                             .max(Integer::compare);

        maxNumber.ifPresent(max -> System.out.println("Maximum number: " + max));
    }
}

