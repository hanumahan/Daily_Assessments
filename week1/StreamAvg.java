package week1;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StreamAvg {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter integers separated by spaces:");
        String input = scanner.nextLine();
        
        List<Integer> numbers = Arrays.stream(input.split("\\s+"))
                                      .map(Integer::parseInt)
                                      .toList();
        
        double average = numbers.stream()
                                .mapToInt(Integer::intValue)
                                .average()
                                .orElse(0);
        
        System.out.println("Average of the integers: " + average);
    }
}
