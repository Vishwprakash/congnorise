package CongoRise;

import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class Hangman {
    public static void drawHangman(int l) {
        if (l == 6) {
            System.out.println("|----------");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        } else if (l == 5) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        } else if (l == 4) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|    |");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        } else if (l == 3) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        } else if (l == 2) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|-");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        } else if (l == 1) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|-");
            System.out.println("|   /");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        } else {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|-");
            System.out.println("|   /|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
    }

    public static void main(String[] args) {
        // List of words to choose from
        String[] wordList = new String[] { "apple", "boy", "cat", "dog", "elephant","frog","hen","ice","jump","knife","lion","monkey","night","owl","pink"};

        // Randomly choose a word from the list
        Random rand = new Random();
        String chosenWord = wordList[rand.nextInt(wordList.length)];

        // Variables to keep track of the game state
        StringBuilder hiddenWord = new StringBuilder("_".repeat(chosenWord.length()));
        int attempts = 6;
        boolean wordGuessed = false;
        ArrayList<Character> guessedLetters = new ArrayList<Character>();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Hangman!");

        // Main game loop
        while (attempts > 0 && !wordGuessed) {
            System.out.println("Word to guess: " + hiddenWord);
            System.out.println("Attempts remaining: " + attempts);
            System.out.print("Guess a letter: ");
            char guessedLetter = scanner.nextLine().charAt(0);

            // Check if the letter has already been guessed
            if (guessedLetters.contains(guessedLetter)) {
                System.out.println("You already guessed that letter. Try again.");
                continue;
            }

            guessedLetters.add(guessedLetter);

            // Check if the guessed letter is in the chosen word
            boolean correctGuess = false;
            for (int i = 0; i < chosenWord.length(); i++) {
                if (chosenWord.charAt(i) == guessedLetter) {
                    hiddenWord.setCharAt(i, guessedLetter);
                    correctGuess = true;
                }
            }

            if (!correctGuess) {
                attempts--;
                System.out.println("Incorrect guess. You lose an attempt.");
                drawHangman(attempts);
            }

            // Check if the word is fully guessed
            if (hiddenWord.toString().equals(chosenWord)) {
                wordGuessed = true;
            }
        }

        if (wordGuessed) {
            System.out.println("Congratulations! You guessed the word: " + chosenWord);
        } else {
            System.out.println("Game over! The word was: " + chosenWord);
        }

        scanner.close();
    }
}
