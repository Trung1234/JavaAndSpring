package com.trungnt.lietkesothuannghich;

import com.trung.nt.condition.Check;

/**
 * Created by My PC on 30/09/2017.
 */
public class Main {

    public static void main(String[] args) {
        int n, count = 0;
        Check check = new Check();

        for (n = 100000; n <= 999999; n++) {
            check.nhapSoN(n);
            if (check.laSoDaoNguoc() == true) {
                check.inSoN();
                count++;
            }
        }
        System.out.println("Có " + count + " số thuận nghịch có 6 chữ số.");
    }
}
