package solutions;

public class ShortestPath {

    public static void main(String[] args) {
        int[][] mat = {
                {1,0,1,0,0},
                {1,0,1,1,1},
                {1,1,1,0,1},
                {0,0,0,0,1},
                {1,1,1,1,1}
        };
        findShortestPath(mat, 3,4, 5,5);
        System.out.println(res);
    }

    public static int findShortestPath(int[][] mat,
            int destX, int destY,
            int n, int m) {

        boolean[][] visited = new boolean[n][m];
        dfs(mat, 0,0, destX, destY, visited, 0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private static int res = Integer.MAX_VALUE;

    private static void dfs(int[][] grid, int r, int c, int destX, int destY, boolean[][] visited, int cost) {
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0 || visited[r][c]) {
            return;
        }
        if(r == destX && c == destY) {
            if(cost < res) {
                res = cost;
            }
            return;
        }
        visited[r][c] = true;
        dfs(grid, r, c-1, destX, destY, visited, cost);
        dfs(grid, r, c+1, destX, destY, visited, cost);
        dfs(grid, r-1, c, destX, destY, visited, cost+1);
        dfs(grid, r+1, c, destX, destY, visited, cost+1);
    }
}
