package org.example.command;

import java.io.IOException;
import java.util.Scanner;

public class HelpCommand implements Command<Void>{

    @Override
    public void execute() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Rules:");
        System.out.println(" 1. Guess a word letter by letter");
        System.out.println(" 2. Guess a word by a subsequence of letters");
        System.out.println(" 3. Guess an entire word");
        System.out.println(" 4. Failure will lead to loss of misses");
        System.out.println("\nAwards: ");
        System.out.println(" 1. Letter by letter guess will give you the score: 100 points per successful guess");
        System.out.println(" 2. Subsequence of letters guess will give you the score: guessed letters * 100 * 2");
        System.out.println(" 3. If you're lucky and could guess a word from the first try you'll get the score: length of the word * 1000 ");
        System.out.print("Press any key to continue...");
        scanner.nextLine();
    }
}
