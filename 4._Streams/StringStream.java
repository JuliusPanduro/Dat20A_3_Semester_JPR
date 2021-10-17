import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Julius Panduro
 */
public class StringStream {
    public static void main(String[] args) {
        List<String> stringAsList = Arrays.asList("Cool", "SuperCool", "MegaCool", "Cool", "cool", "", "", "SuperMegaCool", "CoolestWordInTheWorld");


        List<String> onlyWords = stringAsList.stream().filter(word -> !word.isEmpty()).collect(Collectors.toList());
        System.out.println(onlyWords);

        int vocabulary = (int) stringAsList.stream().filter(word -> !word.isEmpty()).distinct().count();
        System.out.println(vocabulary);

        String sentence = stringAsList.parallelStream()
                .filter(word -> !word.isEmpty())
                .collect(Collectors.joining(" ")) + ".";

        System.out.println(sentence);




    }


}
