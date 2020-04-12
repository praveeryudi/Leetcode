package _30daychallenge;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

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
            int a = pq.poll();
            int b = pq.poll();
            if(a != b){
                pq.offer(a - b);
            }
        }
        return pq.isEmpty() ? 0 : pq.peek();
    }
}