package week1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UpperRes {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "orange", "banana", "grape");
        
        List<String> upperCaseStrings = strings.stream()
                                               .map(String::toUpperCase)
                                               .collect(Collectors.toList());
        
        System.out.println("Uppercase strings: " + upperCaseStrings);
    }
}
