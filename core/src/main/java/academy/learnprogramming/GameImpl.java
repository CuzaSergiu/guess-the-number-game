package academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class GameImpl implements Game {

    // == constants ==
    private static final Logger log = LoggerFactory.getLogger(GameImpl.class);

    // == fields ==
    private final NumberGenerator numberGenerator;

    private final Integer guessCount;

    private Integer number;
    private Integer guess;
    private Integer smallest;
    private Integer biggest;
    private Integer remainingGuesses;
    private boolean validNumberRange = true;

    // == constructors ==
    @Autowired
    public GameImpl(NumberGenerator numberGenerator, @GuessCount Integer guessCount) {
        this.numberGenerator = numberGenerator;
        this.guessCount = guessCount;
    }

    // == init ==
    @PostConstruct
    @Override
    public void reset() {
        smallest = numberGenerator.getMinNumber();
        guess = numberGenerator.getMinNumber();
        remainingGuesses = guessCount;
        biggest = numberGenerator.getMaxNumber();
        number = numberGenerator.next();
        log.debug("The number is {}", number);
    }

    @PreDestroy
    public void preDestroy() {
        log.info("in Game preDestroy()");
    }

    // == public methods ==
    @Override
    public Integer getNumber() {
        return number;
    }

    @Override
    public Integer getGuess() {
        return guess;
    }

    @Override
    public void setGuess(Integer guess) {
        this.guess = guess;
    }

    @Override
    public Integer getSmallest() {
        return smallest;
    }

    @Override
    public Integer getBiggest() {
        return biggest;
    }

    @Override
    public Integer getRemainingGuesses() {
        return remainingGuesses;
    }

    @Override
    public Integer getGuessCount() {
        return guessCount;
    }

    @Override
    public void check() {
        checkValidNUmberRange();

        if (validNumberRange) {
            if (guess > number) {
                biggest = guess - 1;
            }
            if (guess < number) {
                smallest = guess + 1;
            }
        }
        remainingGuesses--;
    }

    @Override
    public boolean isValidNumberRange() {
        return validNumberRange;
    }

    @Override
    public boolean isGameWon() {
        return guess == number;
    }

    @Override
    public boolean isGameLost() {
        return !isGameWon() && remainingGuesses <= 0;
    }

    // == private methods ==
    private void checkValidNUmberRange() {
        validNumberRange = (guess >= smallest) && (guess <= biggest);
    }
}
