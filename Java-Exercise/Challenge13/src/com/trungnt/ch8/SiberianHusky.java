package com.trungnt.ch8;

public class SiberianHusky extends Canien {
    public SiberianHusky(String name, String color, int age, char gender) {
        super(name, color, age, gender);
    }

    @Override
    String getBreed() {
        return "SiberianHusky";
    }
}
