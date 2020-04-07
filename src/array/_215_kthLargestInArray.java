package array;

import java.util.PriorityQueue;

public class _215_kthLargestInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] { 12, 54, 23, 42, 90, 151 };
		int k = 3;
		System.out.println(getKthLargest(arr, k));
	}

	/**
	 * Keep adding to the Priority Queue and if the size exceeds k, remove the head
	 * element.
	 * @param nums
	 * @param k
	 * @return integer
	 */
	private static int getKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (Integer i : nums) {
			pq.offer(i);
			if (pq.size() > k)
				pq.remove();
		}
		return pq.peek();
	}

}
