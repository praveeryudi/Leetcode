package geeks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKNumbers {

    private static class Data {
        int num;
        int freq;
        Data(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }
        @Override
        public String toString() {
            return num + ":" + freq;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        kTop(arr, 4, 3);
    }

    public static ArrayList<ArrayList<Integer>> kTop(int[] arr, int N, int K) {
        // code here
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        PriorityQueue<Data> pq = new PriorityQueue<>((d1, d2) -> {
            if(d1.freq == d2.freq) {
                return d2.num - d1.num;
            } else {
                return d1.freq - d2.freq;
            }
        });

        Map<Integer, Data> freqMap = new HashMap<>();

        for(int n : arr) {
            ArrayList<Integer> l = new ArrayList<>();
            if(freqMap.containsKey(n)) {
                freqMap.get(n).freq++;
            } else {
                Data d = new Data(n, 1);
                freqMap.put(n, d);
                pq.offer(d);
            }
            while(pq.size() > K) {
                pq.poll();
            }

            ArrayList<Integer> res = new ArrayList<>();
            while(!pq.isEmpty()) {
                res.add(0, pq.poll().num);
            }
            output.add(res);
            //pq.addAll(res);
            System.out.println(pq);
        }
        return null;
    }

}
