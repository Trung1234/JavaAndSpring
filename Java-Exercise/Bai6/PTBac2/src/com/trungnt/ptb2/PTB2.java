package com.trungnt.ptb2;

/**
 * Created by My PC on 12/10/2017.
 */
public class PTB2 {
    private float a,b,c,x1,x2;
    private String cauTraLoi;
    public void nhap(float giatriA,float giatriB, float giatriC){
        a = giatriA;
        b = giatriB;
        c = giatriC;
    }

    public  void bienLuanNghiem() {
        // kiểm tra các hệ số
        if (a == 0) {
            if (b == 0) {
                cauTraLoi = "Phương trình vô nghiệm!";

            } else {
                cauTraLoi = "Phương trình có một nghiệm: "
                        + "x = " + (-c / b);
            }
            return;
        }
        // tính delta
        float delta = b*b - 4*a*c;
        
        // tính nghiệm
        if (delta > 0) {
            x1 = (float) ((-b + Math.sqrt(delta)) / (2*a));
            x2 = (float) ((-b - Math.sqrt(delta)) / (2*a));
            cauTraLoi = ("Phương trình có 2 nghiệm là: "
                    + "x1 = " + x1 + " và x2 = " + x2);
        } else if (delta == 0) {
            x1 = (-b / (2 * a));
            cauTraLoi = ("Phương trình có nghiệm kép: "
                    + "x1 = x2 = " + x1);
        } else {
            cauTraLoi = ("Phương trình vô nghiệm!");
        }
    }
    public void inKetQua(){
        System.out.println(cauTraLoi);
    }

}
