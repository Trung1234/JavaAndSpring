package com.basic;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

	/**
	 * Given an array of integers nums and an integer target, 
	 * return indices of the two numbers such that they add up to target
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] twoSum(int[] numbers, int target) {
		HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        for(int i = 0; i < numbers.length; i++){

            Integer diff = (Integer)(target - numbers[i]);
            if(hash.containsKey(diff)){
                int toReturn[] = {hash.get(diff), i};
                return toReturn;
            }

            hash.put(numbers[i], i);

        }
        
        return null;
    }
	
	//https://leetcode.com/problems/two-sum/
	public static void main(String[] args) {
		int[] nums = new int[]{2,7,11,15};		
		int target = 9;
		System.out.println(Arrays.toString(twoSum(nums,target)));//[0,1]
		nums = new int[]{-1,-2,-3,-4,-5};	
		target = -8;
		System.out.println(Arrays.toString(twoSum(nums,target))); 
    }
}
