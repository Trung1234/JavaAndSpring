package com.trungnt.volam.kynang;

/**
 * Created by My PC on 20/10/2017.
 */
public abstract class KyNang {
    private String tenKyNang, thuocTinh,moTa;
    private  int satThuong;
    public  KyNang(String tenKyNang, int satThuong, String thuocTinh, String moTa){
        this.tenKyNang = tenKyNang;
        this.satThuong = satThuong;
        this.thuocTinh = thuocTinh;
        this.moTa = moTa;
    }

    public void inTT(){
        System.out.println("Ky nang :" +tenKyNang);
        System.out.println("Thuoc tinh :" +thuocTinh);
        System.out.println("Sat thuong:" +satThuong);
        System.out.println("Mo Ta :" +moTa);
    }

    public int getSatThuong() {
        return satThuong;
    }
}
