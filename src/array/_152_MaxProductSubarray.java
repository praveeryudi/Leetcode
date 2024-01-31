package array;

import java.util.Arrays;
import java.util.List;

public class _152_MaxProductSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> ll = Arrays.asList(2,3,-2,4);
		System.out.println("Max Product = " + maxProduct(ll));
	}

	private static int maxProduct(final List<Integer> A) {

		int[] min = new int[A.size()];
		int[] max = new int[A.size()];

		min[0] = max[0] = A.get(0);
		int res = 0;
		
		for(int index = 1; index < A.size(); index++) {
			int current = A.get(index);
			if(A.get(index) > 0) {
				max[index] = Math.max(current, max[index-1] * current);
				min[index] = Math.min(current, min[index-1] * current);
			}
			else {
				max[index] = Math.max(current, min[index-1] * current);
				min[index] = Math.min(current, max[index-1] * current);
			}
			res = Math.max(res, max[index]);
		}
		return res;
	}

}
