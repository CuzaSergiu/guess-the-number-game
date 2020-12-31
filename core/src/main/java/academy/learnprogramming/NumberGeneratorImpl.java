package academy.learnprogramming;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

//we annotate the class so the interface doesnt need to be Spring dependent
@Component
public class NumberGeneratorImpl implements NumberGenerator {

    // == fields ==
    private final Random random = new Random();

    @Getter
    private final Integer maxNumber;

    @Getter
    private final Integer minNumber;

    // == constructors ==
    // we inject the numberGenerator using this constructor
    @Autowired
    public NumberGeneratorImpl(@MaxNumber Integer maxNumber, @MinNumber Integer minNumber) {
        this.maxNumber = maxNumber;
        this.minNumber = minNumber;
    }

    // == public methods ==
    @Override
    public Integer next() {
        // example: min=5 max=20 -> max-min=15 -> range 0-15 + min -> 5-20
        return random.nextInt(maxNumber - minNumber) + minNumber;
    }
}
