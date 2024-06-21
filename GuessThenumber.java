import java.util.Random;
import java.util.Scanner;

public class GuessThenumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int maxRounds = 3; // Number of rounds
        int maxAttempts = 5; // Max attempts per round
        int totalScore = 0; // Total score
        
        for (int round = 1; round <= maxRounds; round++) {
            int randomNumber = random.nextInt(100) + 1; // Generate a random number between 1 and 100
            int attemptsLeft = maxAttempts;
            boolean isGuessed = false;
            
            System.out.println("Round " + round + ":");
            
            while (attemptsLeft > 0) {
                System.out.println("Enter your guess (1-100): ");
                int userGuess = scanner.nextInt();
                
                if (userGuess == randomNumber) {
                    isGuessed = true;
                    int points = attemptsLeft * 10; // Calculate points based on remaining attempts
                    totalScore += points;
                    System.out.println("Congratulations! You've guessed the number. Points: " + points);
                    break;
                } else if (userGuess < randomNumber) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }
                
                attemptsLeft--;
                System.out.println("Attempts left: " + attemptsLeft);
            }
            
            if (!isGuessed) {
                System.out.println("Sorry, you've run out of attempts. The correct number was " + randomNumber);
            }
            
            System.out.println("Current Score: " + totalScore);
        }
        
        System.out.println("Game Over! Your total score is: " + totalScore);
        scanner.close();
    }
}
