package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class AlexLionTest {

    @Test
    void alexLionShouldHaveMane() throws Exception {
        AlexLion alex = new AlexLion();  // теперь без параметров
        assertTrue(alex.doesHaveMane());
    }

    @Test
    void alexLionShouldHaveNoKittens() throws Exception {
        AlexLion alex = new AlexLion();
        assertEquals(0, alex.getKittens());
    }

    @Test
    void alexLionShouldHaveCorrectFriends() throws Exception {
        AlexLion alex = new AlexLion();
        List<String> expectedFriends = List.of("Марти", "Глория", "Мелман");
        assertEquals(expectedFriends, alex.getFriends());
    }

    @Test
    void alexLionShouldLiveInNYZoo() throws Exception {
        AlexLion alex = new AlexLion();
        assertEquals("Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }

    @Test
    void alexLionGetFoodShouldWork() throws Exception {
        AlexLion alex = new AlexLion();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedFood, alex.getFood());
    }
}