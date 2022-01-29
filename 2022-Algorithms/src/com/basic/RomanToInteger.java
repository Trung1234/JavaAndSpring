package com.basic;

import java.util.HashMap;

public class RomanToInteger {

	/**
	 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
	 */
	static HashMap<Character, Integer> romanNumerals = new HashMap<Character, Integer>(){{
		put('I',1);
		put('V',5);
		put('X',10);
		put('L',50);
		put('C',100);
		put('D',500);
		put('M',1000);
		}			
	};
	
	/**
	 * https://leetcode.com/problems/roman-to-integer/submissions/
	 * @param s
	 * @return
	 */
	static public int romanToInt(String s) {	        
	    int result = 0;
	    char prev= '\0';
	    for(int i=s.length()-1;i>=0;i--) {
	    	char c = s.charAt(i);
	    	int add = romanNumerals.get(c);
	    	if(prev != '\0' && romanNumerals.get(prev) > romanNumerals.get(c))
	    		add = -add;
    		result+=add;
    		prev = c;
	    }
	    return result;
	}
	public static void main(String[] args) {
		System.out.println(romanToInt("LVIII"));//58
		//Explanation: L = 50, V= 5, III = 3
		System.out.println(romanToInt("MCMXCIV"));//1994 
		//Explanation: M = 1000, CM = 900, XC = 90 and IV = 
	}
}
