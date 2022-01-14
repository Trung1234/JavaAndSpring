package com.trungnt46.stringex1.mystring;

/**
 * Created by My PC on 25/10/2017.
 */
public class MyString {
    private String text;


    public void nhapChuoi(String text) {
        this.text = text;
        System.out.println(text);
    }
    public void tongCacSoTrongChuoi(String str){
        str=str.replaceAll("[\\D]+"," ");
        String[] numbers=str.split(" ");
        int sum = 0;
        for(int i=0;i<numbers.length;i++){
            try{
                sum+=Integer.parseInt(numbers[i]);
            }
            catch( Exception e ) {

            }
        }
        System.out.println("tong cac so trong chuoi abc123nd4gg56  :"+sum);
    }
    public void maASCIInhonhat() {

        int min = text.charAt(0);
        for (int i = 0; i < text.length(); i++) {
            char kytu = text.charAt(i);
            int number = (int) kytu;
            if (number < min) {
                min = number;
            }


        }
        System.out.println("min is:" + min);
    }
    public void daoChuoi(){
        String reversed = "";
        for(int i = text.length() - 1; i >= 0; i--) {
            reversed += text.charAt(i);
        }
        System.out.println("reversed string :" + reversed);
    }
    public void vietHoaChuCaiDau(){
        String temp[] = text.split(" ");
        text = ""; // ? ^-^
        for (int i = 0; i < temp.length; i++) {
            text += String.valueOf(temp[i].charAt(0)).toUpperCase() + temp[i].substring(1);
            if (i < temp.length - 1) // ? ^-^
                text += " ";
        }
    }



}
