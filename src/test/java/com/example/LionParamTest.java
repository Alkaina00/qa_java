package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParamTest {
    Lion lion;
    private final String sex;
    private final boolean result;

    public LionParamTest(String sex, boolean result){
        this.sex = sex;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Before
    public void setup() throws Exception {
        lion = new Lion(sex, null);
    }

    @Test
    public void doesHaveManeTest() {
        assertEquals(result, lion.doesHaveMane());
    }
}
