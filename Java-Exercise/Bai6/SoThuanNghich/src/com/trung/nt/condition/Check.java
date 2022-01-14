package com.trung.nt.condition;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by My PC on 12/10/2017.
 */
public class Check {
    private int n;

    public void nhapSoN(int soN) {
        this.n = soN;
    }
    public  void inSoN(){
        System.out.print(n+"\n");
    }
    public  boolean laSoDaoNguoc() { // Ví dụ n = 123 => return 321
        int res = daonguocso(n);

        if(res == n)
            return true;
        else
            return false;
    }
    public int daonguocso(int x) {
        int re = 0;
        while(x != 0){
            re = re*10 + x%10;
            x = x/10;
        }

        return re;
    }
//
}
