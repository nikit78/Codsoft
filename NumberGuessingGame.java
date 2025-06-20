import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int score = 0;
        int round = 1;
        String playAgain;

        System.out.println("🎮 Welcome to the Number Guessing Game!");

        do {
            int numberToGuess = rand.nextInt(100) + 1; // generates number between 1 and 100
            int attemptsAllowed = 7;
            int attempts = 0;
            boolean hasWon = false;

            System.out.println("\n--- Round " + round + " ---");
            System.out.println("I have picked a number between 1 and 100. You have " + attemptsAllowed + " attempts.");

            while (attempts < attemptsAllowed) {
                System.out.print("Enter your guess: ");
                int guess;

                // Input validation
                try {
                    guess = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("❗ Please enter a valid number.");
                    continue;
                }

                attempts++;

                if (guess == numberToGuess) {
                    System.out.println("🎉 Correct! You guessed the number in " + attempts + " attempts.");
                    hasWon = true;
                    score++;
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("🔽 Too low!");
                } else {
                    System.out.println("🔼 Too high!");
                }
            }

            if (!hasWon) {
                System.out.println("😢 Out of attempts! The number was: " + numberToGuess);
            }

            System.out.println("🏆 Your current score: " + score + " round(s) won.");

            System.out.print("Do you want to play another round? (yes/no): ");
            playAgain = sc.nextLine().trim().toLowerCase();
            round++;

        } while (playAgain.equals("yes") || playAgain.equals("y"));

        System.out.println("\nThank you for playing!");
        System.out.println("🔢 Total rounds played: " + (round - 1));
        System.out.println("✅ Rounds won: " + score);

        sc.close();
    }
}
