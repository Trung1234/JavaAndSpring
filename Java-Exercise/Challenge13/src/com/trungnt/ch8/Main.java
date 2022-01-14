package com.trungnt.ch8;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Canien c = new KleeKai("Lilah", "Grey/White", 5, 'F');
//        Canien d = new SiberianHusky("Alaska", "Grey/Black/White", 16, 'F');
//        c.printInfo();
//        d.printInfo();
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        String author = scanner.nextLine();
        int price = scanner.nextInt();
        scanner.close();

        Book book = new MyBook(title, author, price);
        book.display();
    }
}
