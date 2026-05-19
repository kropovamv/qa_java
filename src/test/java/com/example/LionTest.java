package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class LionTest {

    @Mock
    private Predator mockPredator;

    @ParameterizedTest
    @CsvSource({
            "Самец, true",
            "Самка, false"
    })
    void lionConstructorShouldSetHasManeCorrectly(String sex, boolean expectedHasMane) throws Exception {
        Lion lion = new Lion(sex, mockPredator);
        assertEquals(expectedHasMane, lion.doesHaveMane());
    }

    @Test
    void lionConstructorWithInvalidSexShouldThrowException() {
        Exception exception = assertThrows(Exception.class, () -> {
            new Lion("Неизвестно", mockPredator);
        });
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

    @Test
    void getKittensShouldReturnValueFromPredator() {
        Mockito.when(mockPredator.getKittens()).thenReturn(3);

        Lion lion;
        try {
            lion = new Lion("Самец", mockPredator);
            assertEquals(3, lion.getKittens());
            Mockito.verify(mockPredator, Mockito.times(1)).getKittens();
        } catch (Exception e) {
            fail("Исключение не должно было быть выброшено");
        }
    }

    @Test
    void getFoodShouldReturnValueFromPredator() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(mockPredator.eatMeat()).thenReturn(expectedFood);

        Lion lion = new Lion("Самец", mockPredator);
        assertEquals(expectedFood, lion.getFood());

        Mockito.verify(mockPredator, Mockito.times(1)).eatMeat();
    }
}