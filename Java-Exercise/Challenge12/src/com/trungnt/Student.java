package com.trungnt;

public class Student extends Person {
    private int[] testScores;
    Student(String firstName, String lastName, int identification, int[] testScores) {
        super(firstName, lastName, identification);
        this.testScores = testScores;
    }
    char calculate() {
        int sum = 0;
        char c = 'O';
        for (int i = 0; i < testScores.length; i++) {
            sum = sum + testScores[i];
        }
        int avg = sum / testScores.length;
        if (90 <= avg && avg <= 100) {
            return c;
        } else if (80 <= avg && avg < 90) {
            c = 'E';
            return c;
        } else if (70 <= avg && avg < 80) {
            c = 'A';
            return c;
        } else if (55 <= avg && avg < 70) {
            c = 'P';
            return c;
        } else if (40 <= avg && avg < 55) {
            c = 'D';
            return c;
        } else if (avg < 40) {
            c = 'T';
            return c;
        }
        return c;

    }

    @Override
    public void printPerson() {
        super.printPerson();
        System.out.println("Avareage: "+calculate());
    }
}
