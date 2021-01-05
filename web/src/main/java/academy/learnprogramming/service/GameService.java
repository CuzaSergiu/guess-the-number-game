package academy.learnprogramming.service;

public interface GameService {

    boolean isGameOver();

    String getMainMessage();

    String getResultMessage();

    void checkGuess(Integer guess);

    void reset();

}
