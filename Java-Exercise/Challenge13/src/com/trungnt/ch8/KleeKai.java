package com.trungnt.ch8;

public class KleeKai extends Canien {
    public KleeKai(String name, String color, int age, char gender) {
        super(name, color, age, gender);
    }

    @Override
    String getBreed() {
        return "KleeKai";
    }
}
