import java.util.Comparator;

/**
 * @author Julius Panduro
 */
public class Main {
    public static void main(String[] args) {
     /*   //<editor-fold desc= Abstract instance with anonymouse class, instance is inline
        AbstractClass abstractClassImplemented = new AbstractClass() {
            @Override
            public void makeSurrealArt()  {  //anonym klasse kan blive lavet da den abstracte klasse bliver instanceret inline.
                System.out.println("Hellow");
            }
        };
        //</editor-fold>
        //<editor-fold desc="From { -> }; is inline  (DETTE ER EN ANONYM IMPLEMANTATION AF EN KLASSE)">
        Comparator<String> stringComparator = new Comparator<String>() {
            @Override
            public int compare(String firstString, String secondString) {
                return firstString.compareTo(secondString);
            }
        };
        //</editor-fold>
        // System.out.println(stringComparator.compare("Hello", "World"));

      //  Comparator<String> stringComparatorLambda = (String firstString, String secondString)->firstString.compareTo(secondString);

    //    System.out.println(stringComparatorLambda.compare("a", "b"));

      */
        AbstractClass abstractClassImplemented = new AbstractClass() {
            @Override
            public void makeSurrealArt() {
            }
        };

        //Implementation of a (functional) interface
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String firstString, String secondString) {
                return firstString.compareTo(secondString);
            }
        };
        System.out.println(comparator.compare("a","b"));

        Comparator<String> lambdaComparator = (String firstString, String secondString) ->firstString.compareTo(secondString);

        Comparator<String> lambdaComparatorTypeInference = (firstString,secondString) ->firstString.compareTo(secondString);

        System.out.println(lambdaComparator.compare("a","b"));

     Concatenator concat = ((firstString, secondString) -> firstString + " " + secondString);
        System.out.println(concat.cat("Mind","Blown"));
    }
}
