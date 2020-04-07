package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _39_CombinationSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = new int[] { 2, 7, 5, 3 };
		int target = 7;
		List<List<Integer>> results = new ArrayList();
		if (null == arr || arr.length == 0)
			return;

		Arrays.sort(arr);
		toFindCombinationSum(arr, target, 0, new ArrayList(), results);
		System.out.println(results.toString());
	}

	private static void toFindCombinationSum(int[] candidates, int remTarget, int startIndex, List<Integer> current,
			List<List<Integer>> results) {
		
		if(remTarget == 0) {
			results.add(new ArrayList(current));
			return;
		}
		
		for(int i = startIndex; i < candidates.length; i++) {
			if(candidates[i] > remTarget)
				break;
			current.add(candidates[i]);
			toFindCombinationSum(candidates, remTarget - candidates[i], i, current, results);
			current.remove(current.size() - 1);
		}

	}

}
