import java.util.Random;

/**
 * @author Julius Panduro
 */
//Stream er en strøm af data, og man kan godt sige stop, man bliver bare nød til at sige stop.
//En stream kører uendeligt medmindre at den bliver Terminated ved brug af en terminate operator.
public class RandomStream {
    public static void main(String[] args) {
        Random random = new Random(); //Not a Stream!
        random.ints().limit(4).forEach(System.out::println); //This is a stream of numbers. with a limit




        //  System.out.println(random.nextInt()); //Not a stream!
        // random.ints().forEach(System.out::println); //This is a stream of numbers.

        /* random.ints(). //Main Stream
        limit(4). //intimidate operation (modificere mainstream)
        limit(2). //intimidate operation (modificere mainstream)
        forEach(System.out::println); //Terminal Operation (Samler, regner, printer ud mm.)

        */


    }

}
