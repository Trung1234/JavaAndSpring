package com.basic;

public class PalindromicNumber {

	static boolean isPalindrome(int n) {
		if(n < 0 || (n%10==0 && n!=0))
			return false;
		int reverse = 0;
	    while(n > reverse){
	    	reverse = reverse*10+n%10;
	        n=n/10;
	    }
	    return n == reverse || reverse/10 == n;
	}
	
	public static void main(String[] args)  {
        
		System.out.println(isPalindrome(12321));
		System.out.println(isPalindrome(1221));
		System.out.println(isPalindrome(12021));
    }
}
