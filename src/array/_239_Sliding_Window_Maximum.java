package array;

import java.util.Arrays;
import java.util.PriorityQueue;

public class _239_Sliding_Window_Maximum {

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,-1,-3,5,3,6,7};
        maxSlidingWindow(arr, 3);
    }

    private static int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int[] res = new int[n - k + 1];
        int i = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> b - a);

        int windowStart = 0;
        int windowEnd = windowStart;
        while(windowEnd < n) {
            pq.offer(nums[windowEnd]);
            if(pq.size() == k) {
                res[i++] = pq.poll();
                pq.clear();
                windowStart++;
                windowEnd = windowStart;
            }
            else {
                windowEnd++;
            }
        }
        System.out.println(Arrays.toString(res));
        return res;
    }
}
