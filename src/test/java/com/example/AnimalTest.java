package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class AnimalTest {

    private final Animal animal = new Animal();

    @Test
    void getFoodWithPlantsShouldReturnHerb() throws Exception {
        List<String> expected = List.of("Трава", "Различные растения");
        assertEquals(expected, animal.getFood("Травоядное"));
    }

    @Test
    void getFoodWithPredatorShouldReturnAnimals() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, animal.getFood("Хищник"));
    }

    @Test
    void getFoodWithInvalidFoodShouldThrowException() {
        Exception exception = assertThrows(Exception.class, () -> {
            animal.getFood("Неизвестно");
        });
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
    }

    @Test
    void getFamilyShouldReturnFamilys() {
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        assertEquals(expected, animal.getFamily());
    }
}