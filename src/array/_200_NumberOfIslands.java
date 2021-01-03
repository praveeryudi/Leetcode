package array;

public class _200_NumberOfIslands {

    private static int numIslands(char[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int islands = 0;
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(grid[r][c] == '1') {
                    islands ++;
                    dfs(grid, r, c);
                }
            }
        }
        return islands;
    }

    private static void dfs(char[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0')
            return;

        grid[i][j] = '0';
        dfs(grid, i, j-1);
        dfs(grid, i-1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i+1, j);
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        int res = numIslands(matrix);
        System.out.println("# of islands = " + res);
    }

}
