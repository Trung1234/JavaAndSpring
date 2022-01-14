package com.trungnt.thuasonguyento.condition;

/**
 * Created by My PC on 18/10/2017.
 */
public class Check {
    private float a;
    public void nhap(float giatriA){
        a = giatriA;
    }
    public boolean isPrime(int A){
        a =A;
        boolean result = true;
        if(a<2){
            result = false;
        }else {
            int i = 2;
            while (i<=a/2){
                if(a%i==0){
                    result = false;
                    break;
                }
                i++;
            }
        }
        return result;

    }
}
