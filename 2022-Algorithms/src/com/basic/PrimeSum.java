package com.basic;

public class PrimeSum {

	/**
	 * the result of sum of prime numbers which < n
	 * 
	 * @param n
	 * @return
	 */
	static int primeSum(int n) {
		int result = 0;
		for (int i = 2; i <= n; i++) {
			if (checkPrime(i))
				result += i;
		}
		return result;
	}

	static boolean checkPrime(int numberToCheck) {
		if (numberToCheck == 1) {
			return false;
		}
		for (int i = 2; i * i <= numberToCheck; i++) {
			if (numberToCheck % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {

		System.out.println(primeSum(2));
		System.out.println(primeSum(3));
		System.out.println(primeSum(5));
		System.out.println(primeSum(10000));
	}
}
