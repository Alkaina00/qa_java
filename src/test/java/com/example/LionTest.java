package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    Lion lion;
    @Mock
    Feline feline;
    private List<String> expectedFood;

    @Before
    public void setup() throws Exception {
        lion = new Lion("Самец", feline);
        expectedFood = List.of("Животные", "Птицы", "Рыба");
    }

    @Test
    public void getKittensTest() {
        // создали стаб, теперь при вызове getKittens будет возвращаться 1
        Mockito.when(feline.getKittens()).thenReturn(1);

        int result = lion.getKittens();
        assertEquals(1, result);
    }

    @Test
    public void getFoodTest() throws Exception {
        // создали стаб, теперь при вызове getFood("Хищник") будет возвращаться expectedFood
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood);

        List<String> foodLion = lion.getFood();
        assertEquals(expectedFood, foodLion);
    }
}