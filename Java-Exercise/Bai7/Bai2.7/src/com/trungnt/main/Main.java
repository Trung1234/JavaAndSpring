package com.trungnt.main;

import com.trungnt.solve.Solve;

/**
 * Created by My PC on 18/10/2017.
 */
public class Main {
    public static void main(String[] args) {
        int a= 25, b = 10;
        Solve solve= new Solve();
        solve.nhap(a,b);
        int ucln = solve.timUSCLN(a,b);
        int bcnn = solve.timBSCNN(a,b);
        System.out.println("USCLN giua 2 so a va b la  "+ucln);
        System.out.println("BSCNN giua 2 so a va b la  "+bcnn);
    }
}
