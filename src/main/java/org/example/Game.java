package org.example;

public class Game {
    private int lives;
    private int wordsCompleted;
    private int missesLeft;
    private int score;
    private int charactersGuessed;
    private String currentWord;
    private char[] guessedWord;

    public void changeVariables(int guesses) {
        if (guesses != 0) {
            score += 100 * guesses;
        }else {
            if (missesLeft == 0) {
                lives -= 1;
                missesLeft = 5;
            }else {
                missesLeft -= 1;
            }
        }
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getWordsCompleted() {
        return wordsCompleted;
    }

    public void setWordsCompleted(int wordsCompleted) {
        this.wordsCompleted = wordsCompleted;
    }

    public int getMissesLeft() {
        return missesLeft;
    }

    public void setMissesLeft(int missesLeft) {
        this.missesLeft = missesLeft;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getCurrentWord() {
        return currentWord;
    }

    public void setCurrentWord(String currentWord) {
        this.currentWord = currentWord;
    }

    public int getCharactersGuessed() {
        return charactersGuessed;
    }

    public void setCharactersGuessed(int charactersGuessed) {
        this.charactersGuessed = charactersGuessed;
    }

    public char[] getGuessedWord() {
        return guessedWord;
    }

    public void setGuessedWord(char[] guessedWord) {
        this.guessedWord = guessedWord;
    }

    public void setGuessedWordChar(char ch, int i) {
        if (guessedWord[i] == '_') {
            guessedWord[i] = ch;
            charactersGuessed += 1;
        }
    }
}
