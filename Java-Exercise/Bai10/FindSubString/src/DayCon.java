

public class DayCon {
	private final String CHUOI = "1 2 3 5 4 6 7 8 9 8 7 6 5 11 12 13 15 14 16 18 2 4 3 5 7 9 11 11 11 12 13 14 3 4 32 1 2";
	private int viTriDuyet = 0;
	
	public void lietKeDayConTangDan() {
		viTriDuyet = 0;
		while (viTriDuyet < CHUOI.length()) {
			String dayCon = timKiemDayCon();
			if(dayCon!=null){
				System.out.println(dayCon);
			}
		}
	}
	
	private String timKiemDayCon() {
		int khoangCach = -1;
		int soLienTruoc = -1;
		String dayCon = null;
		while (viTriDuyet < CHUOI.length()) {
			// Tim được số nguyên trên đường đi
			int soTiepTheo = timSoNguyen();
			boolean kiemTraPhanTuHopLe = false;
			
			if (soLienTruoc == -1) {
				soLienTruoc = soTiepTheo;
				kiemTraPhanTuHopLe = true;
			} else if (soTiepTheo - soLienTruoc > 0) {
				if (khoangCach == -1) {
					khoangCach = soTiepTheo - soLienTruoc;
					dayCon = soLienTruoc + " "+soTiepTheo;
//					System.out.print("\n" + soLienTruoc + " " + soTiepTheo);
					soLienTruoc = soTiepTheo;
					kiemTraPhanTuHopLe = true;
				} else if (khoangCach == soTiepTheo - soLienTruoc) {
					soLienTruoc = soTiepTheo;
					kiemTraPhanTuHopLe = true;
//					System.out.print(soTiepTheo + " ");
					dayCon +=" "+soTiepTheo;
				}
			}
			
			if (!kiemTraPhanTuHopLe) {
				// Lùi lại 2 số trước để duyệt
				// VD: 1 2 3 5 thì phải lùi về trước số 3
				if (soTiepTheo - soLienTruoc > 0) {
					viTriDuyet = viTriDuyet - (soTiepTheo + "").length();
					viTriDuyet = viTriDuyet - (soLienTruoc + "").length() - 2;
				} else {
					// Lùi lại 1 số trước để duyệt
					// VD: 3 5 4 thì phải lùi về trước số 4
					viTriDuyet = viTriDuyet - (soTiepTheo + " ").length() - 1;
				}
				return dayCon;
			}
		}
		return null;
	}
	
	private int timSoNguyen() {
		String soNguyen = "";
		while (viTriDuyet < CHUOI.length()) {
			boolean kiemTra = false;
			char kyTu = CHUOI.charAt(viTriDuyet);
			if (kyTu >= '0' && kyTu <= '9') {
				soNguyen += kyTu;
				if (viTriDuyet != CHUOI.length() - 1) {
					kiemTra = true;
				}
			}
			
			viTriDuyet++;
			if (!kiemTra && !soNguyen.isEmpty()) {
				return Integer.parseInt(soNguyen);
			}
		}
		return -1;
	}
}
