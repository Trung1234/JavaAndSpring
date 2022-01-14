package com.trungnt.thuasonguyento.main;

import com.trungnt.thuasonguyento.condition.Check;

/**
 * Created by My PC on 12/10/2017.
 */

public class Main {

    public static void main(String[] args) {
        int n= 20;
        Check check = new Check();
        check.nhap(n);

        for (int i = 2; i <= n; i++)
        {
            while( check.isPrime(i) && (n % i == 0) )
            {
                System.out.println("\n"+i);
                n = n / i;
            }
        }
    }
}
