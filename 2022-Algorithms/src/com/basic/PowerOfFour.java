package com.basic;

public class PowerOfFour {

	static boolean isPowerOfFour(long n) {
	    while(n%4==0){
	        n/=4;
	        if(n==1)
	            return true;
	    }
	    return false;
	}
	public static void main(String[] args)  {
        
		System.out.println(isPowerOfFour(1099511627776L));
		System.out.println(isPowerOfFour(50));
		System.out.println(isPowerOfFour(16));
    }
}
