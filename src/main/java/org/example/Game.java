package org.example;

public class Game {
    private int lives;
    private int wordsCompleted;
    private int missesLeft;
    private int score;
    private int charactersGuessed;
    private String currentWord;
    private char[] guessedWord;

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

    public int setGuessedWordChar(String str) {
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < currentWord.length(); j++) {
                if (str.charAt(i) == currentWord.charAt(j) && guessedWord[j] == '_') {
                    guessedWord[j] = str.charAt(i);
                    charactersGuessed += 1;
                    result++;
                }
            }
        }
        return result;
    }
}
