package com.hans.belatrix.question.dao;

import com.hans.belatrix.question.DummyMock;
import com.hans.belatrix.question.entity.Log;
import com.hans.belatrix.question.enums.LevelEnum;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ILogDAOTest {

    @Autowired
    ILogDAO logDAO;
    private DummyMock dummyMock;

    @Before
    public void setUp() {
        dummyMock = new DummyMock();
    }

    @Test
    public void insertLevelMessageLogTest() {
        Log input = dummyMock.buildLog();
        Log result = logDAO.save(input);

        Assert.assertNotNull(result);
        Assert.assertEquals(input.getMessage(), result.getMessage());
        Assert.assertEquals(input.getLevel(), result.getLevel());
    }

    @Test
    public void insertLevelErrorLogTest() {
        Log input = dummyMock.buildLog();
        input.setLevel(LevelEnum.ERROR.getLevel());
        Log result = logDAO.save(input);

        Assert.assertNotNull(result);
        Assert.assertEquals(input.getMessage(), result.getMessage());
        Assert.assertEquals(input.getLevel(), result.getLevel());
    }
}