package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class CatTest {

    @Mock
    private Feline mockFeline;

    @Test
    void getSoundShouldReturnMeow() {
        Cat cat = new Cat(new Feline());
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    void getFoodShouldReturnWhatPredatorEats() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(mockFeline.eatMeat()).thenReturn(expectedFood);

        Cat cat = new Cat(mockFeline);
        assertEquals(expectedFood, cat.getFood());

        Mockito.verify(mockFeline, Mockito.times(1)).eatMeat();
    }

    @Test
    void getFoodWhenExceptionThrows() throws Exception {
        Mockito.when(mockFeline.eatMeat()).thenThrow(new Exception("Ошибка"));

        Cat cat = new Cat(mockFeline);
        assertThrows(Exception.class, cat::getFood);
    }
}