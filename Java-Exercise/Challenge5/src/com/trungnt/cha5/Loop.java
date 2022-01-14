package com.trungnt.cha5;

public class Loop {
    public int input;

    public Loop(int input) {
        this.input = input;
        for(int i= 1;i<=10;i++){
            System.out.println("2 x "+input+" ="+input*i);
        }
    }
}
