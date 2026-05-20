package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class LionTest {

    @Mock
    private Feline mockFeline;  // ← Исправлено: Predator → Feline

    @Test
    void lionConstructorWithInvalidSexShouldThrowException() {
        Exception exception = assertThrows(Exception.class, () -> {
            new Lion("Неизвестно", mockFeline);  // ← Исправлено: mockPredator → mockFeline
        });
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

    @Test
    void getKittensShouldReturnValueFromPredator() {
        Mockito.when(mockFeline.getKittens()).thenReturn(3);  // ← Исправлено

        assertDoesNotThrow(() -> {
            Lion lion = new Lion("Самец", mockFeline);  // ← Исправлено
            assertEquals(3, lion.getKittens());
            Mockito.verify(mockFeline).getKittens();  // ← Исправлено
        });
    }

    @Test
    void getFoodShouldReturnValueFromPredator() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(mockFeline.eatMeat()).thenReturn(expectedFood);  // ← Исправлено

        Lion lion = new Lion("Самец", mockFeline);  // ← Исправлено
        assertEquals(expectedFood, lion.getFood());

        Mockito.verify(mockFeline).eatMeat();  // ← Исправлено
    }
}