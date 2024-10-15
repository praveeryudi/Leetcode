package backtracking;

public class UniquePathsIII {

    private static int res = 0;
    private static int nonObstacles = 1;

    public static void main(String[] args) {
        int[][] arr = {
                {1,0,0},
                {0,0,0},
                {0,0,2}
        };
        robotPaths(3,3,arr);
        System.out.println(res);
    }

    public static int robotPaths(int n, int m, int arr[][]) {
        // Write your code here..

        int sx = 0, sy = 0;
        boolean[][] visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(arr[i][j] == 1) {
                    sx = i;
                    sy = j;
                } else if(arr[i][j] == 0) {
                    nonObstacles++;
                }
            }
        }
        backtrack(arr, sx, sy, 0, visited);
        return res;
    }

    private static void backtrack(int[][] grid, int sx, int sy, int count, boolean[][] visited) {
        if(sx < 0 || sy < 0 || sx >= grid.length || sy >= grid[0].length || grid[sx][sy] == -1)
            return;
        if(count == nonObstacles && grid[sx][sy] == 2) {
            res++;
            return;
        }
        if(visited[sx][sy])
            return;
        visited[sx][sy] = true;
        // Left
        backtrack(grid, sx, sy-1, count + 1, visited);
        // Up
        backtrack(grid, sx-1, sy, count + 1, visited);
        // Right
        backtrack(grid, sx, sy+1, count + 1, visited);
        // Down
        backtrack(grid, sx+1, sy, count + 1, visited);
        visited[sx][sy] = false;
    }

}
