package com.factorsum;

public class Entry {
	
	public static void main(String[] args){
		int n =24;
		n = solve(n);
		while(n != solve(n)) {
			n = solve(n);
		}
		System.out.print("Factor sum of 24 is "+n);
	}
	
	//https://codelearn.io/learning/basic-algorithms/3811
	public static int solve(int n) {
		int k =2,sum = 0;
		while(n>1) {
			while(n%k==0) {
				sum+=k;
				n/=k;
			}
			k++;
		}		
		return sum;
	}
}
