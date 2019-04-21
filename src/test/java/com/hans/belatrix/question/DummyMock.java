package com.hans.belatrix.question;

import com.hans.belatrix.question.entity.Log;
import com.hans.belatrix.question.enums.LevelEnum;

public class DummyMock {

    public Log buildLog() {
        Log log = new Log();
        log.setLevel(LevelEnum.MESSAGE.getLevel());
        log.setMessage("Test insert");
        return log;
    }
}
