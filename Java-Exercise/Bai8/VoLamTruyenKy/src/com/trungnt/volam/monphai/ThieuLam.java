package com.trungnt.volam.monphai;

import com.trungnt.volam.kynang.KyNang;

/**
 * Created by My PC on 22/10/2017.
 */
public class ThieuLam extends MonPhai {
    public ThieuLam(String tenMonPhai, String truongMon, String noiO, String monQuy, String moTa, KyNang kyNang) {
        super(tenMonPhai, truongMon, noiO, monQuy, moTa, kyNang);
    }

    public void tungKinh() {
        //Nội dung hành vi
    }

    @Override
    public void luyenCong(String vuKhi) {
        System.out.println("Thiếu lâm sử dụng " + vuKhi);
    }
}
