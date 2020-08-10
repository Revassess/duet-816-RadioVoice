package com.revature.tier1;

public class NumberSumLength {

	public static boolean checkNumberPowerLength(long num) {
		String s = Long.toString(num);
        int startLength = s.length();
        char[] digits = s.toCharArray();
        int[] finalDigits = new int[startLength];
        for (int i = 0; i < startLength; i++){
            char c = digits[i];
            finalDigits[i] = (int) Math.pow(c, startLength);
        }

        return(num == SumOverArray.IterateAndSum(finalDigits));
	}
}
