package com.trungnt.sum;

/**
 * Created by My PC on 03/11/2017.
 */
public class Tong2So {
	private String chuoi1, chuuoi2;
	
	public Tong2So(String chuoi1, String chuuoi2) {
		this.chuoi1 = chuoi1;
		this.chuuoi2 = chuuoi2;
	}
	private void swap(){
		String tmp = chuoi1;
		chuoi1 = chuuoi2;
		chuuoi2 = tmp;
	}
	public void tinhTong2Chuoi(){
		if(chuoi1.length()<chuuoi2.length()){
			swap();
		}
		String tong = "";
		int flag = 0;
		int length = chuoi1.length();
		int khoangcach = chuoi1.length() - chuuoi2.length();
		for(int i = length-1;i>=0;i--){
			int kyTu1 = (int)(chuoi1.charAt(i)-'0');
			int kiTu2 = 0;
			int viTriKiTu2 = i - khoangcach;
			
			if(viTriKiTu2 >= 0){
				kiTu2 = chuuoi2.charAt(viTriKiTu2)-'0';
				
			}
			int kq1 = kyTu1 + kiTu2 +flag;
			if(kq1 > 9){
				flag = 1;
				kq1 = kq1 -10;
			}
			else {
				flag = 0;
			}
			tong = kq1 + tong;
			
		}
		System.out.println("Tong: "+tong);
		if(flag==1){
			tong = flag + tong;
			System.out.println("Tong: "+tong);
		}
	}
}
