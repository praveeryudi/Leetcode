package array;

import java.util.ArrayList;

public class FillZeroes {

    public static void main(String[] args) {

    }

    public static ArrayList<ArrayList<Integer>> zeroMatrix(ArrayList<ArrayList<Integer>> matrix, Integer n, Integer m) {
        // Write your code here.

        int rows = n;
        int cols = m;

        int[][] grid = new int[rows][cols];
        for(int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                grid[r][c] = matrix.get(r).get(c);
            }
        }

        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(grid[r][c] == 0) {
                    replace(grid, r, c);
                }
            }
        }

        for(int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if(grid[r][c] == -99) {
                    grid[r][c] = 0;
                }
            }
        }

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(int[] row : grid) {
            ArrayList<Integer> l = new ArrayList<>();
            for(int num : row) {
                l.add(num);
            }
            res.add(l);
        }
        return res;

    }

    private static void replace(int[][] grid, int row, int col) {
        for(int r = 0; r < grid.length; r++) {
            if(grid[r][col] != 0)
                grid[r][col] = -99;
        }
        for(int c = 0; c < grid[0].length; c++) {
            if(grid[row][c] != 0)
                grid[row][c] = -99;
        }
    }
}
