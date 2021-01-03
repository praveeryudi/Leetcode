package array;

import java.util.HashMap;
import java.util.Map;

public class _1640_CanFormArray {

    private static boolean canFormArray(int[] arr, int[][] pieces) {

        Map<Integer, int[]> mapping = new HashMap<>();
        for(int[] piece : pieces) {
            mapping.put(piece[0], piece);
        }
        System.out.println(mapping);

        int n = arr.length;
        int index = 0;
        while(index < n) {
            if(!mapping.containsKey(arr[index]))
                return false;

            int[] values = mapping.get(arr[index]);
            int i = index, j = 0;
            while(i < n && j < values.length && arr[i] == values[j]) {
                i++;
                j++;
            }

            if(j < values.length)
                return false;
            index = i;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] pieces = {
                {78},
                {4,64},
                {91}
        };
        int[] arr = {91,4,64,78};
        System.out.println(canFormArray(arr, pieces));
    }

}
