package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    Cat cat;
    @Mock
    Feline feline;

    private List<String> expectedFood;

    @Before
    public void setup(){
        this.cat = new Cat(feline);
        expectedFood = List.of("Животные", "Птицы", "Рыба");
    }

    @Test
    public void testGetSound() {
        String result = cat.getSound();
        assertEquals("Мяу", result);
    }

    @Test
    public void testGetFood() throws Exception {
        // создали стаб, теперь при вызове eatMeat будет возвращаться список expectedFood
        Mockito.when(feline.eatMeat()).thenReturn(expectedFood);

        List <String> foodCat = cat.getFood();
        assertEquals(expectedFood, foodCat);
    }
}