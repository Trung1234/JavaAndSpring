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
		int indexMax = 0;
	    for(int i=1;i<numerators.length;i++){
	        if((numerators[indexMax]*denominators[i]-numerators[i]*denominators[indexMax])<0){
	            indexMax = i;
	        }
	            
	    }
	    return indexMax;
	}
	public static void main(String[] args) {
		int[] numerators = new int[]{ 1, 2}; 
		int[] denominators = new int[]{ 4, 3}; 
		System.out.println(maxFraction(numerators,denominators));
		numerators = new int[]{ 1, 2, 3, 10 }; 
		denominators = new int[]{ 1, 3, 4, 11}; 
		System.out.println(maxFraction(numerators,denominators));
	}
}
