package top100;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 *
 */
public class Subsets {

	public static void main(String[] args) {

		int[] arr = {1,2,3};
		List<List<Integer>> subsets = new ArrayList<>();
		generateSubsets(arr, 0, new ArrayList<>(), subsets);
		System.out.println(subsets);
	}
	
	private static void generateSubsets(int[] nums, int index, List<Integer> current, List<List<Integer>> subsets) {
		subsets.add(new ArrayList<>(current));
		for(int i = index; i <nums.length; i++) {
			current.add(nums[i]);
			generateSubsets(nums, i + 1, current, subsets);
			current.remove(current.size() - 1);
		}
	}

}
