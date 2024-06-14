package week1;

import java.util.Arrays;
import java.util.List;

public class FilterA {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Apple", "Banana", "Avocado", "Blueberry", "Apricot");
        
        strings.stream()
               .filter(s -> s.startsWith("A"))
               .forEach(System.out::println);
    }
}
