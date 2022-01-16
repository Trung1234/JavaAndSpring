package com.basic;

public class MaxFraction {
	/**
	 * Given a list of fractions, find the index of the largest one (0-based).
	 * https://codelearn.io/learning/basic-algorithms/3619
	 * @param numerators
	 * @param denominators
	 * @return
	 */
	static int maxFraction(int[] numerators, int[] denominators) {
	    int result =0;
	    double temp= (double) numerators[0]/denominators[0];
	    for(int i=1;i<numerators.length;i++){
	        if(temp < (double) numerators[i]/denominators[i]){
	            temp = numerators[i]/denominators[i];
	            result = i;
	        }
	    }
	    return result;
	}
	public static void main(String[] args) {
		int[] numerators = new int[]{ 1, 2}; 
		int[] denominators = new int[]{ 4, 3}; 
		System.out.print(maxFraction(numerators,denominators));
	}
}
