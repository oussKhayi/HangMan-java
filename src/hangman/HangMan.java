package hangman;
import java.util.*;

public class HangMan {
    public static void main(String[] args) {
         
        // Create an array of fruits
        String[] fruits = {"banana", "apple", "orange", "strawberry", "watermelon", "kiwi", "mango", "pineapple"};
        
        // Generate a random index to select a fruit
        Random random = new Random();
        int randomIndex = random.nextInt(fruits.length);

        // Get the random fruit using the random index
        String randomFruit = fruits[randomIndex];
        
        int wordLength = randomFruit.length();
        StringBuilder catchWord = new StringBuilder();
        // Generate a new catchWord:
        for (int i = 0; i < wordLength; i++) {
            catchWord.append('*');
        }
        
        // Convert the concealed word to String:
        String catchString = catchWord.toString();

        // The game starts here:
        Scanner scanner = new Scanner(System.in);
        int attempt = 5;
        while (attempt > 0) {
            System.out.println("The concealed word: " + catchString);
            System.out.println("Pick a letter from the concealed word: ");
            char scLetter = scanner.next().charAt(0);
            
            boolean containsLetter = randomFruit.contains(String.valueOf(scLetter));

            if (containsLetter) {
                for (int j = 0; j < randomFruit.length(); j++) {
                    if (randomFruit.charAt(j) == scLetter) {
                        catchWord.setCharAt(j, scLetter);
                    }
                }
                catchString = catchWord.toString();
                
                if (catchString.equals(randomFruit)) {
                    System.out.println("Congratulations! You win.");
                    System.out.println("The fruit's name is: " + randomFruit);
                    break;
                }
                
                System.out.println("Good guess!");
                System.out.println("You still have " + attempt + " attempt(s) left.");
            } else {
                attempt--;
                if (attempt <= 0) {
                    System.out.println("You lose! You are out of chances.");
                    break;
                } else {
                    System.out.println("Incorrect guess.");
                    System.out.println("You have " + attempt + " attempt(s) left.");
                    System.out.println("Try again...");
                }
            }
        }
    
        if (attempt <= 0) {
            System.out.println("The fruit's name was: " + randomFruit);
        }
    }
}
