package com.trungnt.ch7;


import java.util.Arrays;

public class Main {
    public static void reverseArray(int[] numbers){
        for (int i = 0; i < numbers.length / 2; i++) {
            int temp = numbers[i];
            numbers[i] = numbers[numbers.length - 1 - i];
            numbers[numbers.length - 1 - i] = temp;
        }
    }
    public static void main(String[] args) {
        int[] num = {1,4,3,2};

        reverseArray(num);
        for(int i=0;i<num.length;i++){
            System.out.print(" "+num[i]);
        }
    }
}
