package com.trungnt;

public class Main {
    public static void main(String[] args) {
        int[] scores = {80,90};
        Student student = new Student("Heraldo", "Memelli", 8135627,scores);
        student.printPerson();
    }
}
