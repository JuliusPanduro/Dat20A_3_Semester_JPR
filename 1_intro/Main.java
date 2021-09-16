import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @author Julius Panduro
 */
public class Main {


    //implement with all the primative datatypes..
    public static void main(String[] args) {
        Word[] words = new Word[]{
                new Word("hey"),
                new Word("how"),
                new Word("Are"),
                new Word("you"),
                new Word("mate")
        };

        ArrayList<Word> wordArrayList = new ArrayList<>() {{ //{{ means inline, so you dont have to write wordArrayList.add
            add(new Word("hello"));
            add(new Word("how"));
            add(new Word("are"));
            add(new Word("you"));
            add(new Word("mate"));
        }};


        Systemos.out.println(5);
        Systemos.out.println("This is my text");
        Systemos.out.println(5.00);
        Systemos.out.println(1.21);
        Systemos.out.println('a');
        Systemos.out.println(12L);
        Systemos.out.println(12F);


        Systemos.out.println(new Word("Hello World!"));
        Systemos.out.println(words);
        Systemos.out.println(wordArrayList);
    }


    //Generics
    /*public static <T> void out(T out){
        System.out.println(out);
     */


}
