package academy.learnprogramming.console;

import academy.learnprogramming.config.GameConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    //The LoggerFactory is a utility class producing Loggers for various logging APIs, most notably for log4j, logback and JDK 1.4 logging.
    //Other implementations such as NOPLogger and SimpleLogger are also supported.
    //LoggerFactory is essentially a wrapper around an ILoggerFactory instance bound with LoggerFactory at compile time.
    //Please note that all methods in LoggerFactory are static
    private final static Logger log = LoggerFactory.getLogger(Main.class);

    //psvm - shortcut for the main method
    public static void main(String[] args) {
        log.info("Guess the number game");

        // Create context ( container )
        ConfigurableApplicationContext context
                = new AnnotationConfigApplicationContext(GameConfig.class);

        // close context (container)
        context.close();

    }
}
