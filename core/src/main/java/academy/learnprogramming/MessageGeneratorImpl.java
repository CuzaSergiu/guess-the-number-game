package academy.learnprogramming;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class MessageGeneratorImpl implements MessageGenerator {

    // == constants ==
    private static final String MAIN_MESSAGE = "game.main.message";
    private static final String WIN = "game.win";
    private static final String LOSE = "game.lose";
    private static final String INVALID_RANGE = "game.invalid.range";
    private static final String FIRST_GUESS = "game.first.guess";
    private static final String HIGHER = "game.higher";
    private static final String LOWER = "game.lower";
    private static final String REMAINING = "game.remaining";


    // == fields ==
    private final Game game;
    private final MessageSource messageSource;

    // == constructors ==
    @Autowired
    public MessageGeneratorImpl(Game game, MessageSource messageSource) {
        this.game = game;
        this.messageSource = messageSource;
    }

    // == init ==
    @PostConstruct
    public void init() {
        log.debug("game = {} ", game);
    }

    // == public methods ==
    @Override
    public String getMainMessage() {
        // new return using message generator internationalization ( message.properties )
        return getMessage(MAIN_MESSAGE, game.getSmallest(), game.getBiggest());

        // Old return
//        return "Number is between "
//                + game.getSmallest()
//                + " and "
//                + game.getBiggest()
//                + ". Can you guess it?";
    }

    @Override
    public String getResultMessage() {

        // new return using message generator internationalization ( message.properties )
        if (game.isGameWon()) {
            return getMessage(WIN, game.getNumber());
        } else if (game.isGameLost()) {
            return getMessage(LOSE, game.getNumber());
        } else if (!game.isValidNumberRange()) {
            return getMessage(INVALID_RANGE);
        } else if (game.getRemainingGuesses() == game.getGuessCount()) {
            return getMessage(FIRST_GUESS);
        } else {
            String direction = getMessage(LOWER);

            if (game.getGuess() < game.getNumber()) {
                direction = getMessage(HIGHER);
            }
            return getMessage(REMAINING, direction, game.getRemainingGuesses());
        }

        // Old return using Strings
//        if (game.isGameWon()) {
//            return "You guessed it! The number was " + game.getNumber();
//        } else if (game.isGameLost()) {
//            return "You lost! The number was " + game.getNumber();
//        } else if (!game.isValidNumberRange()) {
//            return "Invalid number range!";
//        } else if (game.getRemainingGuesses() == game.getGuessCount()) {
//            return "What is your first guess?";
//        } else {
//            String direction = "Lower";
//
//            if (game.getGuess() < game.getNumber()) {
//                direction = "Higher";
//            }
//            return direction + "! You have " + game.getRemainingGuesses() + " guesses left";
//        }
    }

    // == private methods ==
    //method that get the messages from our message.source
    private String getMessage(String code, Object... args) {
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }
}
