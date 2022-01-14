package com.trungny.ch8;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Challenge {
    public static void main(String[] args) {
        Map hashMap=new HashMap();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            String name = in.next();
            int phone = in.nextInt();
            hashMap.put(name,phone);
        }
        while(in.hasNext()){
            String s = in.next();
            // Write code here
            if(hashMap.containsKey(s)){
                System.out.println(s+ "="+hashMap.get(s));
            }
            else {
                System.out.println("not found");
            }

        }
        in.close();
    }
}
