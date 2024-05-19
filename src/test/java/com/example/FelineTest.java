package com.example;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineTest {
    Feline feline;
    private List<String> expectedFood;

    @Before
    public void setup(){
        this.feline = new Feline();
        expectedFood = List.of("Животные", "Птицы", "Рыба");
    }

    @Test
    public void eatMeatTest() throws Exception {
        List<String> foodFeline = feline.eatMeat();
        assertEquals(expectedFood, foodFeline);
    }

    @Test
    public void getFamilyTest() {
        String result = feline.getFamily();
        assertEquals("Кошачьи", result);
    }

    @Test
    public void getKittensTest() {
        int result = feline.getKittens();
        assertEquals(1, result);
    }

    @Test
    public void testGetKittensTest() {
        int result = feline.getKittens(10);
        assertEquals(10, result);
    }
}