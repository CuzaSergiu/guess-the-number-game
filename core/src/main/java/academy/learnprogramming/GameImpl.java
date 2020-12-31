package academy.learnprogramming;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

// == @Slf4j this annotations enables Lombok console (log) on this class
@Slf4j
// == @Getter - on class will auto generate getters for every field we have
@Getter
@Component
public class GameImpl implements Game {

    // == fields ==
    // == we dont need a getter on this field so we set @Getter(AccessLevel.NONE) annotation above it
    @Getter(AccessLevel.NONE)
    private final NumberGenerator numberGenerator;

    private final Integer guessCount;

    private Integer number;
    private Integer smallest;
    private Integer biggest;
    private Integer remainingGuesses;
    private boolean validNumberRange = true;

    // == this way we only have setters on the specified field below
    @Setter
    private Integer guess;

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
