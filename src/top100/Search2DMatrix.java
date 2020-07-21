package top100;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 *
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 */
public class Search2DMatrix {

    public static void main(String[] args) {
        int[][] arr = {
            {1,   4,  7, 11, 15},
            {2,   5,  8, 12, 19},
            {3,   6,  9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };

        int target = 20;
        System.out.println("Is Found = " + isFound(arr, target));
    }

    private static boolean isFound(int[][] nums, int target) {
        int rowIndex = 0;
        int colIndex = nums[0].length - 1;
        while(rowIndex < nums.length && colIndex < nums[0].length) {
            if(nums[rowIndex][colIndex] == target)
                return true;
            else if(nums[rowIndex][colIndex] < target)
                rowIndex++;
            else
                colIndex--;
        }
        return false;
    }
}
