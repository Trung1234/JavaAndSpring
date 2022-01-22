package com.basic;

public class ReverseInteger {

	
	public static void main(String[] args){
		int n = 123;		
		System.out.println("Reverse sum of "+n+" is "+reverse(n));//321
		n = -123;
		System.out.println("Reverse sum of "+n+" is "+reverse(n));//-321
		n = 120;
		System.out.println("Reverse sum of "+n+" is "+reverse(n));//21
		n = 100;
		System.out.println("Reverse sum of "+n+" is "+reverse(n));//1
	}
	

	/**
	 * https://leetcode.com/problems/reverse-integer/
	 * @param n
	 * @return
	 */
	public static int reverse(int n) {
        int result = 0;
        while(n%10==0) {
        	n/=10;
        }       	
        while(n%10!=0) 
        {
        	result*=10;
        	result+=n%10;
        	
        	n/=10;   	
        }
        return result;
        
    }
}
