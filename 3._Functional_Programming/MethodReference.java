
import java.util.Arrays;
import java.util.List;

/**
 * @author Julius Panduro
 */
public class MethodReference {

    public MethodReference(String content) {
        System.out.println(content);
    }


    public static void outStaticVersion(String content) {
        System.out.println(content);
    }

    public void out(String content) {
        System.out.println(content);
    }

    public static void main(String[] args) {

        List<String> greetings = Arrays.asList("Hello Word", "Godmorgen");

        //Not a method reference but a lambda!
        greetings.forEach((greeting) -> System.out.println(greeting));

        //Method reference
        //forEach(new MethodReference()::out) //Dosent work is there is a contructor
//      greetings.forEach(new MethodReference()::out); //-> kalder den ikke static out. Men der skal laves en New MethodReference da metoden ikke er static
        greetings.forEach(MethodReference::outStaticVersion); //-> Kalder static out. Der behøves ikke lave en New MethodReference da metoden er static
        greetings.forEach(MethodReference::new); //-> Kalder contructoren
        greetings.forEach(System.out::println); //-> Kalder Sout. Det er muligt grundet Sout er static.

    }
}
