package com.trungnt.ch8;

public class MyBook extends Book {
    int price;
    MyBook(String title, String author, int price) {
        super(title, author);
        this.price = price;
    }

    @Override
    void display() {
        System.out.print("Title: "+title+"\n"+
                "Author: "+author+"\n"+
                "Price: "+price);
    }
}
