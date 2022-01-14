package com.trungnt.solve;

/**
 * Created by My PC on 18/10/2017.
 */
public class Solve {
    private float a,b;
    public void nhap(float giatriA,float giatriB){
        a = giatriA;
        b = giatriB;
    }
    public int timBSCNN(int A,int B){
        a = A;
        b = B;
        int result = timUSCLN(A, B);
        return A * B / result;
    }
    public int timUSCLN(int A,int B){
        a = A;
        b = B;
        int temp;
        // giải thuật Euclid
        while (B != 0)
        {
            temp = A % B;
            A = B;
            B = temp;
        }
        return A;


    }

}
