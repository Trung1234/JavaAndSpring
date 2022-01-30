package com.basic;

import java.util.Arrays;

public class RotateArray {

	public static int[] rotate(int[] nums, int k) {
		int[] result = new int[nums.length];
		for(int i =0;i<nums.length;i++) {
			if(i+k > nums.length-1) {
				result[i+k-nums.length] = nums[i];
			}else {
				result[i+k] = nums[i];
			}
		}
		return result;
    }
	
	public static void main(String[] args) {
		int[] nums = new int[] { 1,2,3,4,5,6,7 };
		int k = 3;
		System.out.println(Arrays.toString(rotate(nums, k)));
		nums = new int[] { -1,-100,3,99};
		k = 2;
		System.out.println(Arrays.toString(rotate(nums, k)));
	}
}
