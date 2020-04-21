package _30daychallenge;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 */
public class NumberOfIslands {

    public static void main(String[] args) {
        int[][] grid = new int[][] {
                {1,1,0,0,0},
                {1,1,0,0,0},
                {0,0,1,0,0},
                {0,0,0,1,1}
        };
        int islands = 0;
        for(int x = 0; x < grid.length; x++) {
            for(int y = 0; y < grid[0].length; y++) {
                if(grid[x][y] == 1) {
                    islands++;
                    dfs(grid, x, y);
                }
            }
        }
        System.out.println("# of islands = " + islands);
    }

    private static void dfs(int[][] matrix, int i, int j) {
        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] == 0)
            return;

        matrix[i][j] = 0;
        dfs(matrix, i-1, j);
        dfs(matrix, i + 1, j);
        dfs(matrix, i, j - 1);
        dfs(matrix, i, j + 1);
    }
}
