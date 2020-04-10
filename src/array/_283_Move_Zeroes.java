package array;

import java.util.Arrays;

public class _283_Move_Zeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] input = new int[] {0,1,0,3,12};
		int start = 0;
		
		for(int index = 0; index < input.length; index++) {
			if(input[index] != 0) {
				input[start] = input[index];
				start++;
			}
		}
		
		// Set remaining indices to zero.
		for(int index = start; index < input.length; index++) {
			input[index] = 0;
		}

		System.out.println(Arrays.toString(input));
	}

}
