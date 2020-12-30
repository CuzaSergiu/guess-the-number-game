package academy.learnprogramming;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


// @Target - Annotation MaxNumber can be added to fields, parameters and methods
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})
// @Retention - annotations are recorded in the class file by the compiler and retained by JVM at runtime
@Retention(RetentionPolicy.RUNTIME)
// @Qualifier - used to annotate other custom annotations that can be used as Qualifiers
@Qualifier
public @interface MaxNumber {

    // this interface is a custom made annotation named MaxNumber that we can use
    // in our case if we change the method names in GameConfig the application will still be able to run

}
