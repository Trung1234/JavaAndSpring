package com.trungnt.demo;

public class Main {
    public static void main(String[] args) {

        System.out.println("Check age");
        int age = 50;

        try{
            AgeUtils.checkAge(age);
            System.out.println("pass");


        } catch (TooYoungException e) {
            System.out.println(e.getMessage());
        } catch (TooOldException e) {
            System.out.println(e.getMessage());
        }
        }
    }

