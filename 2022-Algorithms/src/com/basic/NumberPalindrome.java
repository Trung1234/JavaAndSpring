package com.basic;

public class NumberPalindrome {
	
	public static void main(String[] args) {
//        System.out.println(isPalindrome(25));
//        System.out.println(isPalindrome(1221));
//        System.out.println(isPalindrome(101));
        System.out.println(isPalindrome(-222));
    }
	
	static boolean isPalindrome(int input)
    {
		input = Math.abs(input);
        int reversed = 0;
        int temp = input;
        while(temp>0) {        	
        	reversed = reversed*10 + temp%10;
        	temp = temp/10;
        	if(reversed == input)
        		return true;
    	}
        return false;
    }
}
