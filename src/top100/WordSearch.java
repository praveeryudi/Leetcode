package top100;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 */
public class WordSearch {

    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word = "ABCCED";
        boolean isExist = exist(board, word);
        System.out.println("Is word exists = " + isExist);
    }

    private static boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(board[i][j] == word.charAt(0) && dfs(board, i, j, 0, word))
                    return true;
            }
        }
        return false;
    }

    private static boolean dfs(char[][] grid, int i, int j, int count, String word) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] != word.charAt(count))
            return false;
        if(count == word.length() - 1)
            return true;
        char temp = grid[i][j];
        grid[i][j] = '\0';
        boolean isFound = dfs(grid, i, j-1, count + 1, word) ||
                dfs(grid, i-1, j, count + 1, word) ||
                dfs(grid, i, j+1, count + 1, word) ||
                dfs(grid, i+1, j, count + 1, word);
        if(!isFound)
            grid[i][j] = temp;
        return isFound;
    }
}
