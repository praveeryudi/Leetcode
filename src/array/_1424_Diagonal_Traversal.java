package array;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class _1424_Diagonal_Traversal {

    private static void findDiagonalOrder(int[][] nums) {

        int rows = nums.length;
        int cols = nums[0].length;

        Map<Integer, List<Integer>> map = new TreeMap<>();
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                int index = i + j;
                if(map.containsKey(index)) {
                    List<Integer> value = map.get(index);
                    value.add(0, nums[i][j]);
                }
                else {
                    List<Integer> value = new ArrayList<>();
                    value.add(nums[i][j]);
                    map.put(index, value);
                }
            }
        }
        System.out.println(map);
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        findDiagonalOrder(nums);
    }
}
