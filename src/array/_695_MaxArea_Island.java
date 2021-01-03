package array;

public class _695_MaxArea_Island {

    public static void main(String[] args) {
        int[][] matrix = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };

        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxArea = Integer.MIN_VALUE;
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(matrix[r][c] == 1) {
                    int area = getArea(matrix, r, c);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        System.out.println("Max Area = " + maxArea);
    }

    private static int getArea(int[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0)
            return 0;

        grid[i][j] = 0;
        int area = 1;
        area += getArea(grid, i, j-1);
        area += getArea(grid, i-1, j);
        area += getArea(grid, i, j+1);
        area += getArea(grid, i+1, j);

        return area;
    }

}
