package org.example;

public class RenderClass {
    private final String[] hangmanStatus = new String[] {
            """ 
                 _________
                |/        |
                |
                |
                |
                |
                |
                |
              __|______________
            /   |             /|
            _________________/ |
            _________________|/
            """,
            """ 
                 _________
                |/        |
                |         |
                |
                |
                |
                |
                |
              __|______________
            /   |             /|
            _________________/ |
            _________________|/
            """,
            """ 
                 _________
                |/        |
                |         |
                |         @
                |
                |
                |
                |
              __|______________
            /   |             /|
            _________________/ |
            _________________|/
            """,
            """ 
                 _________
                |/        |
                |         |
                |         @
                |        \\|/
                |
                |
                |
              __|______________
            /   |             /|
            _________________/ |
            _________________|/
            """,
            """ 
                 _________
                |/        |
                |         |
                |         @
                |        \\|/
                |         |
                |
                |
              __|______________
            /   |             /|
            _________________/ |
            _________________|/
            """,
            """ 
                 _________
                |/        |
                |         |
                |         @
                |        \\|/
                |         |
                |        / \\
                |
                |
              __|______________
            /   |             /|
            _________________/ |
            _________________|/
            """,

    };

    public void renderIntroMenu() {
        System.out.print(" _                                             \n");
        System.out.print("| |                                            \n");
        System.out.print("| |__   __ _ _ __   __ _ _ __ ___   __ _ _ __  \n");
        System.out.print("| '_ \\ / _` | '_ \\ / _` | '_ ` _ \\ / _` | '_ \\ \n");
        System.out.print("| | | | (_| | | | | (_| | | | | | | (_| | | | |\n");
        System.out.print("|_| |_|\\__,_|_| |_|\\__, |_| |_| |_|\\__,_|_| |_|\n");
        System.out.print("                    __/ |                      \n");
        System.out.print("                   |___/                       \n");
        System.out.print("     _________    \n");
        System.out.print("    |/       |   \n");
        System.out.print("    |        |   \n");
        System.out.print("    |        @   \n");
        System.out.print("    |       \\|/  \n");
        System.out.print("    |        |   \n");
        System.out.print("    |       / \\ \n");
        System.out.print(" ___|___________ \n");
        System.out.print("/   |          /|\n");
        System.out.print("______________/ |\n");
        System.out.print("______________|/ \n");
        System.out.println("Menu:");
        System.out.println("1. Play Game");
        System.out.println("2. Quit");
        System.out.print("Your choice: ");
    }

    public void drawGameMenu(final Game game) {
        System.out.print("Lives: " + game.getLives() + "               Misses left: " + game.getMissesLeft() + "\n");
        System.out.print("Words completed: " + game.getWordsCompleted() + "               Score: " + game.getScore() + "\n");
        System.out.println(hangmanStatus[5 - game.getMissesLeft()]);
        System.out.println("Guessed word: " + String.valueOf(game.getGuessedWord()));
        System.out.println("Characters guessed: " + game.getCharactersGuessed());

    }
}
