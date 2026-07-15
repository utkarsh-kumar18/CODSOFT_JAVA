import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Random random = new Random();

        int score = 0;
        String choice;

        System.out.println("==== Welcome to the Number Guessing Game! ====");

        do {
            int number = random.nextInt(100) + 1;
            int attempts = 5;
            boolean win = false;

            System.out.println("\nI have selected a number between 1 and 100. You have " + attempts + " attempts to guess it.");
            System.out.println("You have " + attempts + " chances to guess it.");

            while (attempts > 0) {
                System.out.print("Enter your guess: ");
                int guess = input.nextInt();

                if (guess == number) {
                    System.out.println("Correct! You've guessed the number.");
                    score++;
                    win = true;
                    break;
                } else if (guess > number) {
                    System.out.println("Your guess is too high.");
                } else {
                    System.out.println("Your guess is too low.");
                }

                attempts--;
                if (attempts > 0) {
                    System.out.println("You have " + attempts + " attempts left.\n");
                }
            }

            if (!win) {
                System.out.println("Game over! The correct number was: " + number);
            }

            System.out.println("Score: " + score);

            System.out.print("Do you want to play again? (yes/no): ");
            choice = input.next();

        } while (choice.equalsIgnoreCase("yes"));

        System.out.println("Thank you for playing! Your final score is: " + score);
        input.close();
    }
}