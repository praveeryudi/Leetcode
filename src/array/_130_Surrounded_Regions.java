package array;

/**
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 */
public class _130_Surrounded_Regions {

    private static void solve(char[][] board) {

        if(null == board || board.length == 0) return;
        int rows = board.length;
        int cols = board[0].length;

        boolean[][] visited = new boolean[rows][cols];
        // Process 1st column and last column
        for(int r = 0; r < rows; r++) {
            if(board[r][0] == 'O') {
                dfs(board, r, 0, visited, false);
            }
            if(board[r][cols-1] == 'O') {
                dfs(board, r, cols-1, visited, false);
            }
        }

        // Process 1st row and last row
        for(int c = 0; c < cols; c++) {
            if(board[0][c] == 'O') {
                dfs(board, 0, c, visited, false);
            }
            if(board[rows-1][c] == 'O') {
                dfs(board, rows-1, c, visited, false);
            }
        }

        // Process inner cells (sub matrix)
        for(int i = 1; i < rows - 1; i++) {
            for(int j = 1; j < cols - 1; j++) {
                if(board[i][j] == 'O' && !visited[i][j]) {
                    dfs(board, i, j, visited, true);
                }
            }
        }

    }

    private static void dfs(char[][] board, int i, int j, boolean[][] visited, boolean flip) {
        if(i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || board[i][j] == 'X')
            return;
        if(visited[i][j])
            return;

        visited[i][j] = true;
        if(flip) {
            board[i][j] = 'X';
        }

        dfs(board, i, j-1, visited, flip);
        dfs(board, i-1, j, visited, flip);
        dfs(board, i, j+1, visited, flip);
        dfs(board, i+1, j, visited, flip);
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}
        };

        solve(grid);
        // Print the grid
        for (char[] chars : grid) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(chars[j] + " ");
            }
            System.out.println("");
        }
    }

}
