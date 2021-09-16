import java.lang.reflect.Array;
import java.util.List;

/**
 * @author Julius Panduro
 */
public class Systemos {


    //innerclass with all primitive datatypes
    public static class out {
        public static void println(int text) {
            System.out.println(text);
        }

        public static void println(byte text) {
            System.out.println(text);
        }

        public static void println(boolean text) {
            System.out.println(text);
        }

        public static void println(double text) {
            System.out.println(text);
        }

        public static void println(float text) {
            System.out.println(text);
        }

        public static void println(long text) {
            System.out.println(text);
        }

        public static void println(String text) {
            System.out.println(text);
        }

        public static void println(char text) {
            System.out.println(text);
        }


        //Print of object.
        public static void println(Object content) {
            System.out.println(content);
        }


        //Print of Array with For loop
        public static void println(Object[] words) {
            for (int i = 0; i < words.length; i++) {
                System.out.println(words[i]);
            }
        }

        //for Each Loop of a List
        public static void println(List content) {
            content.forEach(object -> println(object));
            //content.forEach(out::println);
        }
    }

}
