import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        // Define the range and the number of attempts
        int min = 1;
        int max = 100;
        int numberOfAttempts = 5;
        
        // Generate a random number within the range
        int randomNumber = random.nextInt((max - min) + 1) + min;
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a number between " + min + " and " + max + ".");
        System.out.println("You have " + numberOfAttempts + " attempts to guess the number.");

        boolean hasGuessedCorrectly = false;
        
        for (int attempt = 1; attempt <= numberOfAttempts; attempt++) {
            System.out.print("Attempt " + attempt + ": Enter your guess: ");
            int playerGuess = scanner.nextInt();
            
            if (playerGuess < min || playerGuess > max) {
                System.out.println("Please enter a number between " + min + " and " + max + ".");
            } else if (playerGuess < randomNumber) {
                System.out.println("Too low! Try again.");
            } else if (playerGuess > randomNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You guessed the correct number.");
                hasGuessedCorrectly = true;
                break;
            }
        }
        
        if (!hasGuessedCorrectly) {
            System.out.println("Sorry, you've used all " + numberOfAttempts + " attempts. The correct number was " + randomNumber + ".");
        }

        scanner.close();
    }
}
