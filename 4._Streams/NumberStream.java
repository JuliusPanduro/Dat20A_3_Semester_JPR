import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Julius Panduro
 */
public class NumberStream {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(11, 22, 11, 55, 2, 6, 1, 77, 8,1, 2, 14);
        int sum = numbers.stream().mapToInt(number -> number).sum();

        int sumParallelized = numbers.parallelStream().mapToInt(number -> number).sum();

        System.out.println(sumParallelized);

        Double avgTemperature = numbers.stream().mapToInt(number -> number).average().getAsDouble();

        System.out.println(avgTemperature);

        List<Integer> squaredNumbers =  numbers.stream().map(nomNom -> nomNom * nomNom).collect(Collectors.toList());
        System.out.println(squaredNumbers);

        List<Integer> evenNumbers = numbers.stream().filter(number -> number % 2 == 0).collect(Collectors.toList());
        System.out.println(evenNumbers);

        List<Integer> oddNumbers = numbers.stream().filter(number -> number % 2 != 0).collect(Collectors.toList());
        System.out.println(oddNumbers);

        List<Integer> uniqueNumbers = numbers.stream().distinct().collect(Collectors.toList());
        System.out.println(uniqueNumbers);

        IntSummaryStatistics summary = numbers.parallelStream().mapToInt(number->number).summaryStatistics();
        System.out.println(summary);
        System.out.println("Summary min = " + summary.getMin());
        System.out.println("Summary max = "+summary.getMax());
        System.out.println("Summary sum = "+summary.getSum());
        System.out.println("Summary Avg = " + summary.getAverage());
        System.out.println("Summary count = " +summary.getCount());
    }
}
