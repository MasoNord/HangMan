package org.example.command;

import org.example.Game;
import org.example.RenderClass;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class NewGameCommand implements Command<Void>{
    private final Game game;
    private final RenderClass renderClass;
    private final InputStreamReader input = new InputStreamReader(System.in);
    private final BufferedReader reader = new BufferedReader(input);
    private List<String> listOfWords;

    public NewGameCommand(Game game, RenderClass renderClass) throws IOException {
        this.game = game;
        this.renderClass = renderClass;
        readFromFile();
    }

    private void init() {
        game.setScore(0);
        game.setWordsCompleted(0);
        game.setLives(3);
        game.setMissesLeft(5);
        game.setCharactersGuessed(0);
        guessRandomWord();
    }

    private void readFromFile() throws IOException {
        String PATH = "./word.txt";
        BufferedReader bf = new BufferedReader(
                new FileReader(PATH)
        );
        listOfWords = new ArrayList<>();
        String line = bf.readLine();
        while (line != null) {
            listOfWords.add(line);
            line = bf.readLine();
        }
        bf.close();
    }

    private void guessRandomWord() {
        Random random = new Random();
        game.setCurrentWord(listOfWords.get(random.nextInt(listOfWords.size())));
        char[] guessedWord = new char[game.getCurrentWord().length()];
        Arrays.fill(guessedWord, '_');
        game.setGuessedWord(guessedWord);
    }

    private void guessWord(String line) throws IOException {
        int index = game.getCurrentWord().indexOf(line);
        if (index == -1) {
            for (int i = 0; i < line.length(); i++) {
                if (game.getMissesLeft() != 0) {
                    game.setMissesLeft(game.getMissesLeft() - 1);
                }else {
                    if (game.getLives() != 0) {
                        game.setLives(game.getLives() - 1);
                        game.setMissesLeft(5);
                    }else {
                        break;
                    }
                }
            }
        }else {
            int guessed = game.setGuessedWordChar(line);
            if (guessed != 0) {
                if (line.length() == 1) {
                    game.setScore(game.getScore() + 100);
                }else if (line.length() == game.getCurrentWord().length()) {
                    game.setScore(game.getScore() + line.length() * 1000);
                }else {
                    game.setScore(game.getScore() + 100 * line.length() * 2);
                }
            }else {
                System.out.println("You've already guessed this sequence, try another one");
                System.out.print("Press any key to continue...");
                reader.readLine();
            }
        }
    }

    private boolean validate(String line) {
        for (int i = 0; i < line.length(); i++) {
            if (Character.isUpperCase(line.charAt(i)) || Character.isDigit(line.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void execute() throws IOException {
        init();
        while(true) {
            renderClass.drawGameMenu(game);
            if (game.getLives() == 0 && game.getMissesLeft() == 0) {
                System.out.println("You've lost all your lives :(");
                System.out.print("If you want to continue press any key otherwise type No: ");
                String line = reader.readLine();
                if (line.equalsIgnoreCase("no")) {
                    System.out.println("Thank you for your time and I hope to see you again!");
                    System.out.print("Press any key to continue...");
                    reader.readLine();
                    break;
                }
                init();
                continue;
            }
            if (game.getCharactersGuessed() != game.getCurrentWord().length()) {
                System.out.print("Next guess (Type '!' to Quit): ");
                String line = reader.readLine();
                if (line.equals("!")) {
                    System.out.println("Have a nice day!");
                    System.out.print("Press any key to continue...");
                    reader.readLine();
                    break;
                }
                if (validate(line)) {
                    guessWord(line);
                }else {
                    System.out.println("Please DO NOT enter upper case letters and digits!");
                    System.out.print("Press any key to continue...");
                    reader.readLine();
                }
            }else {
                System.out.println("Congratulation! You've guessed the word!");
                System.out.print("If you want to continue press any key otherwise type No: ");
                String line = reader.readLine();
                if (line.equalsIgnoreCase("no")) {
                    System.out.println("Thank you for your time and I hope to see you again!");
                    System.out.print("Press any key to continue...");
                    reader.readLine();
                    break;
                }else {
                    game.setCharactersGuessed(0);
                    guessRandomWord();
                };
            }
        }
    }
}
