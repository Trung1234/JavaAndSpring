package com.trungnt.volam.main;

import com.trungnt.volam.kynang.KyNang;
import com.trungnt.volam.kynang.NoiCong;
import com.trungnt.volam.monphai.MonPhai;
import com.trungnt.volam.monphai.ThieuLam;
import com.trungnt.volam.monphai.VoDang;

/**
 * Created by My PC on 20/10/2017.
 */
public class Main {
    public static void main(String[] args) {
        KyNang noiCongThieuLam = new NoiCong("Đại lực kim cang chưởng",
                                                150,
                                                "Hỏa",
                                                "Công lực tườn khí"
                                                );
        MonPhai thieuLam = new ThieuLam("Thiếu lâm ", "Dat ma sư tổ",
                                          "Chùa","Võ công thiếu lâm", "Tứ đại giai không",
                                           noiCongThieuLam
                                        );
        KyNang ngoaiCongVoDang = new NoiCong("Nhân kiếm hợp nhất",
                120,
                "Kim",
                "Công lực tôć độ"
        );
        MonPhai voDang= new VoDang("Võ Đang ", "Tôn Ngộ Không",
                "Núi Võ Đang","Võ công Võ Đang", "Tứ đại giai không",
                ngoaiCongVoDang
        );
        System.out.println("\n-----so tai-----");
        thieuLam.soTai(voDang);
    }
}
