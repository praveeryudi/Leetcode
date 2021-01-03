package array;

public class _286_Walls_Gates {

    public static void main(String[] args) {
        int inf = Integer.MAX_VALUE;
        int[][] grid = {
                {inf, -1, 0, inf},
                {inf, inf, inf, -1},
                {inf, -1, inf, -1},
                {0, -1, inf, inf}
        };

        findMinDistance(grid);

        // Print the grid
        for (int[] ints : grid) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println("");
        }
    }

    private static void findMinDistance(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 0)
                {
                    dfs(grid, i, j, 0);
                }
            }
        }
    }

    private static void dfs(int[][] grid, int i, int j, int dist) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] < dist)
            return;

        grid[i][j] = dist;

        dfs(grid, i, j-1,dist + 1);
        dfs(grid, i-1, j, dist + 1);
        dfs(grid, i, j+1, dist + 1);
        dfs(grid, i+1, j, dist + 1);
    }
}
