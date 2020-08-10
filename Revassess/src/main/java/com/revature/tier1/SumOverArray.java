package com.revature.tier1;

public class SumOverArray {

	public static int IterateAndSum(int[] arr) {
		int sum = 0;
		if (arr==null){
		    sum = 0;
        } else {
            for (int i = 0; i < arr.length; i++) {
                int x = arr[i];
                sum += x;
            }
        }



        return sum;
	}
}
