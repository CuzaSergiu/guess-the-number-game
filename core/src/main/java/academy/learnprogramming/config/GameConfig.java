package academy.learnprogramming.config;

import academy.learnprogramming.GuessCount;
import academy.learnprogramming.MaxNumber;
import academy.learnprogramming.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config/game.properties")
@ComponentScan(basePackages = "academy.learnprogramming")
public class GameConfig {

    // == fields ==
    @Value("${game.maxNumber:90}")
    private Integer maxNumber;

    @Value("${game.guessCount:8}")
    private Integer guessCount;

    @Value("${game.minNumber:2}")
    private Integer minNumber;

    // == bean methods ==
    @Bean
    @MaxNumber
    public Integer maxNumber() {
        return maxNumber;
    }

    @Bean
    @GuessCount
    public Integer guessCount() {
        return guessCount;
    }

    @Bean
    @MinNumber
    public Integer minNumber() {
        return minNumber;
    }

}
