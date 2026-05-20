package com.example;

import java.util.Arrays;
import java.util.List;

public class AlexLion extends Lion {

    public AlexLion() throws Exception {
        // Передаём "Самец" и новый экземпляр Feline
        super("Самец", new Feline());
    }

    public List<String> getFriends() {
        return Arrays.asList("Марти", "Глория", "Мелман");
    }

    public String getPlaceOfLiving() {
        return "Нью-Йоркский зоопарк";
    }

    @Override
    public int getKittens() {
        return 0;
    }
}