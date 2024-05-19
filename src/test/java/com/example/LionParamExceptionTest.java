package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class LionParamExceptionTest {
    public static final String EXPECTED_ERROR = "Используйте допустимые значения пола животного - самец или самка";
    private final String sex;

    public LionParamExceptionTest(String sex){
        this.sex = sex;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {null},
                {"Небинарная"},
                {"unknown"}
        };
    }

    @Test
    public void doesHaveManeExceptionTest(){
        Exception exception = Assert.assertThrows(Exception.class, () -> new Lion(sex, null));
        Assert.assertEquals(EXPECTED_ERROR, exception.getMessage());
    }
}
