package top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a collection of distinct integers, return all possible permutations.
 *
 */
public class Permutations {

	private static List<List<Integer>> results = new ArrayList<>();
	
	public static void main(String[] args) {

		int[] input = {1,2,3};
		permute(input, 0, input.length - 1);
		System.out.println(results);
	}
	
	private static void permute(int[] nums, int start, int end) {
		if(start > end) return;
		if(start == end) {
			List<Integer> list = new ArrayList<>();
			list = Arrays.stream(nums).boxed().map(x->x).collect(Collectors.toList());
			results.add(list);
		}
		for(int i = start; i <= end; i++) {
			swap(nums, start, i);
			permute(nums, start + 1, end);
			swap(nums, start, i);
		}
	}
	
	private static void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}

}
