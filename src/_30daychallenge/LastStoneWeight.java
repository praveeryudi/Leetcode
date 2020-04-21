package _30daychallenge;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * We have a collection of stones, each stone has a positive integer weight.
 * Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:
 * If x == y, both stones are totally destroyed;
 * If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
 * At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)
 */
public class LastStoneWeight {

    public static void main(String[] args) {
        int[] stones = new int[]{2,7,4,1,8,1};
        int lastWeight = getLastStoneWeight(stones);
        System.out.println("Last Weight = " + lastWeight);
    }

    private static int getLastStoneWeight(int[] arr) {
        if(null == arr || arr.length == 0) return 0;
        if(arr.length == 1) return arr[0];
        Arrays.sort(arr);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : arr) {
            pq.offer(i);
        }
        while(!pq.isEmpty()) {
            if(pq.size() == 1)
                return pq.peek();
            Integer a = pq.poll();
            Integer b = pq.poll();
            if(!a.equals(b)){
                pq.offer(a - b);
            }
        }
        return pq.isEmpty() ? 0 : pq.peek();
    }
}