import java.util.Random;
import java.util.Scanner;

public class Game {

    private final GameConfig config;

    public Game(GameConfig config) {
        this.config = config;
    }

    public void runGame() {

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        boolean playAgain = true;

        while (playAgain) {

            int playerScore = 0;
            int computerScore = 0;

            System.out.println("New Game Started");
            System.out.println("Best of 3. First to 2 wins!");
            System.out.println("Guess a number between"
                    + config.getMin() + "and" + config.getMax());
            System.out.println();

            while (playerScore < 2 && computerScore < 2) {

                int randomInt = random.nextInt(
                        config.getMax() - config.getMin() + 1)
                        + config.getMin();

                boolean correctGuess = false;

                System.out.println("New Round");

                for (int attempt = 1; attempt <= config.getMax_attempts(); attempt++) {

                    System.out.print("Attempt" + attempt + ":");
                    int guess;

                    while (true) {
                        if (scanner.hasNextInt()) {
                            int input = scanner.nextInt();

                            if (input >= config.getMin() && input <= config.getMax()) {
                                guess = input;
                                break;
                            } else {
                                System.out.print("Enter a number between"
                                        + config.getMin() + "and"
                                        + config.getMax() + ":");
                            }

                        } else {
                            System.out.print("Invalid input. Enter a number:");
                            scanner.next();
                        }
                    }

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

            System.out.print("Play again? (y/n): ");
            String response = scanner.next().trim().toLowerCase();
            playAgain = response.equals("y");

            System.out.println();
        }
        scanner.close();
    }
}

