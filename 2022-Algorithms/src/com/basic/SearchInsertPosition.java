package com.basic;

public class SearchInsertPosition {

	/**
	 * Given a sorted array of distinct integers and a target value, 
	 * return the index if the target is found. 
	 * If not, return the index where it would be if it were inserted in order.
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        for(int i=0;i<n;i++) {
        	if(target <= nums[i]) {
        		return i;
        	}
        }
        return n;
    }
	
	/**
	 * https://leetcode.com/problems/search-insert-position/
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = new int[] {1,3,5,6};
		int target = 5;
		System.out.println(searchInsert(nums, target));//2
		target = 2;
		System.out.println(searchInsert(nums, target));//1
		target = 7;
		System.out.println(searchInsert(nums, target));//4
	}
}
