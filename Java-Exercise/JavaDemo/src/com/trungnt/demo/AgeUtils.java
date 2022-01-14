package com.trungnt.demo;

public class AgeUtils {
    public static void checkAge(int age) throws TooYoungException, TooOldException {
        if(age<18){
            throw new TooYoungException("Age "+age+" too young");
        }
        else if(age>40){
            throw new TooOldException("Age "+age+" too old");
        }
        System.out.println("Age "+age+ " Ok ");

    }
}
