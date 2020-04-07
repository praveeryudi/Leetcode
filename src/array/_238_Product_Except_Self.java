package array;

import java.util.Arrays;

public class _238_Product_Except_Self {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] input = new int[] {1,2,3,4};
		int num = 1;
		
		int[] prod = new int[input.length];
		
		for(int index = 0; index < input.length; index++) {
			prod[index] = num;
			num = num * input[index];
		}
		
		num = 1;
		
		for(int index = input.length - 1; index >= 0; index--) {
			prod[index] = num * prod[index];
			num = num * input[index];
		}
		
		System.out.println(Arrays.toString(prod));
	}

}
