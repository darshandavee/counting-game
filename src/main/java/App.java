import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int playerScore = 0;
        int computerScore = 0;

        while (playerScore < 2 && computerScore < 2) {

            int randomInt = random.nextInt(50) + 1;
            int attempts = 4;
            boolean correctGuess = false;

            System.out.println("New Round");
            System.out.println("Guess the number between 1 and 50");

            for (int i = 1; i <= attempts; i++) {

                System.out.print("Attempt" + i + ":");
                int guess = scanner.nextInt();

                if (guess == randomInt) {
                    System.out.println("You guessed Correct!");
                    correctGuess = true;
                    playerScore++;
                    break;

                } else if (guess < randomInt) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
            }
            if (!correctGuess) {
                System.out.println("You ran out of attempts. The number was " + randomInt);
                computerScore++;
            }

            System.out.println("Score -> Player:" + playerScore
                    + "|Computer:" + computerScore);
        }

        if (playerScore == 2) {
            System.out.println("You win the BO3!");
        } else {
            System.out.println("Computer wins the BO3!");
        }
    }
}

