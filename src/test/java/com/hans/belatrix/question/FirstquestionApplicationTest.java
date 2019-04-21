package com.hans.belatrix.question;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Created on 26/01/2018.
 *
 * @author Hans H. Bravo
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FirstquestionApplicationTest {

    public static void main(String[] args) {
        SpringApplication.run(FirstquestionApplicationTest.class, args);
    }

}