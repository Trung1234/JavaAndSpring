package com.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Result {

    /*
     * Complete the 'miniMaxSum' function below.
     * https://www.hackerrank.com/challenges/mini-max-sum/problem
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
	    // Write your code here
    	int sum = 0, min = arr.get(0), max= arr.get(0);
    	for (int element : arr) {
    		sum+=element;
            if(min > element)
            	min = element;
            if(max < element)
            	max = element;
        }
    	System.out.print((sum-max)+" "+(sum-min));
    }

}

public class MiniMaxSum {

	public static void main(String[] args) throws IOException {
        @SuppressWarnings("serial")
		List<Integer> arr =new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
            } 
		};
        Result.miniMaxSum(arr);
    }
}
