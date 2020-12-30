package academy.learnprogramming;

public interface Game {

    Integer getNumber();

    Integer getGuess();

    void setGuess(Integer guess);

    Integer getSmallest();

    Integer getBiggest();

    Integer getRemainingGuesses();

    Integer getGuessCount();

    void reset();

    void check();

    boolean isValidNumberRange();

    boolean isGameWon();

    boolean isGameLost();

}
