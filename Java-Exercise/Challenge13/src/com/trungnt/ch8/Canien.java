package com.trungnt.ch8;

abstract class Canien {
    String name, color;
    char gender;
    int age;

    public Canien(String name, String color,  int age, char gender) {
        this.name = name;
        this.color = color;
        this.age = age;
        this.gender = gender;
    }
    abstract String getBreed();
    void printInfo(){
        // print information about the dog:
        System.out.println(name + " is " + ((age%10 == 8)? "an " : "a ") + age + " year old "
                + gender + getBreed() + " with a " + color + " coat.");
        // note: the '(age%10 == 8)' conditional ensures grammatical correctness if dog is 8 or 18; dogs do not live longer than this.
    }
}
