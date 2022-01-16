package com.basic;

class Result2 {

    /*
     * GCPD (Greatest Common Prime Divisor) is defined as the
     * largest prime number that divides both given positive integers.
     * Your task is to find GCPD of the given integers a and b.
     */

    public static int greatestCommonPrimeDivisor(int a, int b) {
	    // Write your code here
    	int result = -1;
    	for (int i = 2;i<=a && i<=b;i++) {
    		if(a%i==0  && b%i==0 && isPrime(i)) {
    			result = i;
    		}
        }
    	return result;
    }
    static boolean isPrime(int n)
    {
        // Corner case
        if (n <= 1)
            return false;
  
        // Check from 2 to n-1
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;
  
        return true;
    }
}
/*
 * https://codelearn.io/learning/basic-algorithms/3617
 */
public class GreatestCommonPrimeDivisor {

	public static void main(String[] args) {
		int a = 12,b=18;
        System.out.print("GCPD of "+a+"and "+b+ " is "+Result2.greatestCommonPrimeDivisor(a,b));
    }
}
