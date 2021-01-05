package academy.learnprogramming;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@Slf4j
//@SpringBootApplication - sets the main class to a Spring boot application
@SpringBootApplication
public class Main {

    //psvm - shortcut for the main method
    public static void main(String[] args) {
        log.debug("Guess the number game");

        // starts the spring application
        SpringApplication.run(Main.class, args);
    }
}
