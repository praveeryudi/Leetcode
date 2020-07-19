package top100;

import java.util.Arrays;

/**
 * Given an array nums of n integers where n > 1,  
 * return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 *
 */
public class ProductExceptSelf {

	public static void main(String[] args) {

		int[] arr = {1,2,3,4};
		int len = arr.length;
		int num = 1;
		
		int[] output = new int[len];
		for(int i = 0; i < len; i++) {
			output[i] = num;
			num = num * arr[i];
		}
		num = 1;
		for(int i = len - 1; i >= 0; i--) {
			output[i] = num * output[i];
			num = num * arr[i];
		}
		
		System.out.println(Arrays.toString(output));
	}
}
