package com.hans.belatrix.question.service;

import com.hans.belatrix.question.enums.LevelEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LogServiceTest {

    @Autowired
    private ILogService service;

    @Test
    public void messageTest() {
        service.loadMessage("Test message", LevelEnum.MESSAGE.getLevel());
    }

    @Test
    public void warningTest() {
        service.loadMessage("Warning message", LevelEnum.WARNING.getLevel());
    }

    @Test
    public void errorTest() {
        service.loadMessage("Error message", LevelEnum.ERROR.getLevel());
    }

    @Test
    public void messageEmptyTest() {
        service.loadMessage("", LevelEnum.WARNING.getLevel());
    }

    @Test
    public void messageNullTest() {
        service.loadMessage(null, LevelEnum.WARNING.getLevel());
    }

    @Test
    public void levelErrorTest() {
        service.loadMessage("Test message", 4);
    }
}