package solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class _2225_WinLoss {
    private static List<List<Integer>> findWinners(int[][] matches) {

        Set<Integer> wonAll = new TreeSet<>();
        List<Integer> lostOne = new ArrayList<>();

        Map<Integer, Integer> map = new TreeMap<>();
        for(int[] arr : matches) {
            wonAll.add(arr[0]);
            map.put(arr[1], map.getOrDefault(arr[1], 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1) {
                lostOne.add(entry.getKey());
            }
            wonAll.remove(entry.getKey());
        }
        Collections.sort(lostOne);

        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>(wonAll));
        res.add(lostOne);
        return res;
    }

    public static void main(String[] args) {
        int[][] matches = {
                {1,3}, {2,3}, {3,6}, {5,6}, {5,7}, {4,5}, {4,8}, {4,9}, {10,4}, {10,9}
        };
        System.out.println(findWinners(matches));
    }
}
