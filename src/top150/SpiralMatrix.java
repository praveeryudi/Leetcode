package top150;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    private static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;

        int rowBegin = 0, rowEnd = rows - 1;
        int colBegin = 0, colEnd = cols - 1;

        while(rowBegin <= rowEnd && colBegin <= colEnd) {
            // 1. Left to right
            for(int c = colBegin; c <= colEnd; c++) {
                res.add(matrix[rowBegin][c]);
            }
            rowBegin++;

            // 2. Top to down
            for(int r = rowBegin; r <= rowEnd; r++) {
                res.add(matrix[r][colEnd]);
            }
            colEnd--;

            if(rowBegin <= rowEnd) {
                // 3. Right to left
                for(int c = colEnd; c >= colBegin; c--) {
                    res.add(matrix[rowEnd][c]);
                }
                rowEnd--;
            }

            if(colBegin <= colEnd) {
                // 4. Down to up
                for(int r = rowEnd; r >= rowBegin; r--) {
                    res.add(matrix[r][colBegin]);
                }
                colBegin++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {2,5,8},
                {4,0,-1}
        };
        System.out.println(spiralOrder(matrix));
    }

}
