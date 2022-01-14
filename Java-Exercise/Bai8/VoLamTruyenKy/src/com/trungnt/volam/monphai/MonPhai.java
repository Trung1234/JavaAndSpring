package com.trungnt.volam.monphai;

import com.trungnt.volam.bohanhvi.BoHanhViMonPhai;
import com.trungnt.volam.kynang.KyNang;

/**
 * Created by My PC on 20/10/2017.
 */
public abstract class MonPhai implements BoHanhViMonPhai {
    private String tenMonPhai, truongMon, noiO, monQuy, moTa;
    private KyNang kyNang;

    public MonPhai(String tenMonPhai, String truongMon,
                   String noiO, String monQuy, String moTa, KyNang kyNang) {
        this.tenMonPhai = tenMonPhai;
        this.truongMon = truongMon;
        this.noiO = noiO;
        this.monQuy = monQuy;
        this.moTa = moTa;
        this.kyNang = kyNang;
    }

    public void inTT(){
        System.out.println("\n Mon phai :" +tenMonPhai);
        System.out.println("Truong mon :" +truongMon);
        System.out.println("Noi o:" +noiO);
        System.out.println("Mon quy :" +monQuy);
        System.out.println("Mo ta :" +moTa);
        kyNang.inTT();
    }

    public void soTai(MonPhai monPhai2){
        if(kyNang.getSatThuong() > monPhai2.kyNang.getSatThuong()){
            System.out.println("Môn phái " + tenMonPhai
                    + " thắng môn phái "
                    + monPhai2.tenMonPhai);
        }
        else {
            System.out.println("Môn phái " + monPhai2.tenMonPhai
                    + " thắng môn phái "
                    + tenMonPhai);
        }
    }

    @Override
    public void anUong(String doAn, String thoiGian, String diaDiem) {
        // Nội dung hành vi ăn uống
        System.out.println("Đồ ăn: " 		+ doAn);
        System.out.println("Thời gian: " 	+ thoiGian);
        System.out.println("Địa điểm: " 	+ diaDiem);

    }
}

