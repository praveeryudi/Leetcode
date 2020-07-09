package array;

public class _827_Making_Large_Island {

    public static void main(String[] args) {
        int[][] matrix = {
                {1,0},
                {0,1}
        };

        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxArea = Integer.MIN_VALUE;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][j] = 1;
                    int area = dfs(matrix, i, j, rows, cols);
                    maxArea = Math.max(maxArea, area);
                    matrix[i][j] = 0;
                }
            }
        }
        System.out.println("Max Area = " + maxArea);
    }

    private static int dfs(int[][] grid, int i, int j, int rows, int cols) {
        if(i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == 0)
            return 0;

        int area = 1;
        grid[i][j] = 0;
        area += dfs(grid, i, j-1, rows, cols);
        area += dfs(grid, i-1, j, rows, cols);
        area += dfs(grid, i, j+1, rows, cols);
        area += dfs(grid, i+1, j, rows, cols);

        return area;
    }

}
