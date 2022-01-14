package com.trungnt46.stringex1.main;

import com.trungnt46.stringex1.mystring.MyString;

import java.util.Arrays;

/**
 * Created by My PC on 25/10/2017.
 */
public class Main {
    public static void main(String[] args) {

        MyString string = new MyString();
        string.nhapChuoi("trung nguyen thanh");
        string.maASCIInhonhat();
        string.daoChuoi();
        string.tongCacSoTrongChuoi("abc123nd4gg56");
    }
}

