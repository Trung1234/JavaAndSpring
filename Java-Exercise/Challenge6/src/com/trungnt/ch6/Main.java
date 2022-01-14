package com.trungnt.ch6;

import java.util.Scanner;


//https://www.hackerrank.com/challenges/30-review-loop/editorial
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

            char[] inputString = scan.next().toCharArray();

            // Print even chars
            for(int j = 0; j < inputString.length; j += 2){
                System.out.print(inputString[j]);
            }
            System.out.print(" ");

            // Print odd chars
            for(int j = 1; j < inputString.length; j += 2){
                System.out.print(inputString[j]);
            }
//            System.out.println();

        scan.close();

    }
}
