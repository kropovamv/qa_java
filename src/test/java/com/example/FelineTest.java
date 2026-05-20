package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class FelineTest {

    private Feline feline;

    @BeforeEach
    void setUp() {
        feline = new Feline();
    }

    @Test
    void eatMeatShouldReturnPredatorFood() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, feline.eatMeat());
    }

    @Test
    void getFamilyShouldReturnFamily() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    void getKittensWithoutArgShouldReturnOne() {
        assertEquals(1, feline.getKittens());
    }
}