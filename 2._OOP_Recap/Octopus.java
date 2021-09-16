import java.util.Random;

/**
 * @author Julius Panduro
 */

public class Octopus extends Animal {

    final Random random = new Random();

    static final int min = 1;
    static final int max = 10;

    static final int octopusCounter = 10;


    public void makeDoActivity() {
        while (true) {
            try {
                String activity = selectActivity();
                System.out.println(activity);

                     if (activity.equals("Come on groove with me")){
                    GameOfOctopus gameThread = new GameOfOctopus();
                    gameThread.start();  //If activity equals "come on grove" it will make a new thread which will make a new "octopus"
                     }

                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
                System.out.println("Something went wrong");
            }
        }
    }

    public String selectActivity() {
        String selectActivity;


        int number = random.nextInt(max) + min;

        switch (number) {
            case 1:
                selectActivity = "This is my arm number " + number + " I will now wave with it";
                break;
            case 2:
                selectActivity = "I will now spin around for you ";
                break;
            case 3:
                selectActivity = "Come on groove with me";
                break;
            case 4:
                selectActivity = "Ups i had to take a leak, sorry for that";
                break;
            case 5, 6, 7, 8, 9, 10:
                selectActivity = "I will now eat a worm and jet ink";
                break;

            default:
                selectActivity = move() + " Insert a number between 1-6 " + move();

        }
        return selectActivity;
    }

 /*   public String selectActivity() {


        int number = random.nextInt(max) + min;

        switch (number) {
            case 1:
                return "This is my arm number " + number + " I will now wave with it";
            case 2:
                return "I will now spin around for you ";
            case 3:
                return "Come on groove with me";
            case 4:
                return "Ups i had to take a leak, sorry for that";
            case 5, 6, 7, 8, 9, 10:
                return "I will now eat a worm and jet ink";
            default:
                return move() + " Insert a number between 1-6 " + move();
        }
    }

  */

    @Override
    public String move() {
        return "Swish Swosh";
    }



}
