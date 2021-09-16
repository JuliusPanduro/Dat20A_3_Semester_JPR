/**
 * @author Julius Panduro
 */
public class Main {
    public static void main(String[] args) {

        /* TODO
        Create a zoo/aquarium
        It's possible to name threads in Java
        (Give each animal a unique name and say wh is doing what)
        ASCII animations that move when move is called?
        Animals can die
        Change the activity frequently.
         */
        GameOfOctopus game = new GameOfOctopus();


             // game.start(); //creates a new thread.
            // game.run(); // calls run in the main thread but doesn't creat a new thread.
        game.start();
    }
}
