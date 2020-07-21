package top100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 */
public class WordSearch {

    private static List<String> path = new ArrayList<>();

    public static void main(String[] args) {
        char[][] board = {
                {'A','B','H','I'},
                {'S','F','C','S'},
                {'A','K','E','H'}
        };
        String word = "ABHISHEK";
        boolean isExist = exist(board, word);
        System.out.println("Is word exists = " + isExist);
        Collections.reverse(path);
        System.out.println(path);
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
        {
            path.add(i + "," + j);
            return true;
        }
        char temp = grid[i][j];
        grid[i][j] = '\0';
        boolean isFound = dfs(grid, i, j-1, count + 1, word) ||
                dfs(grid, i-1, j, count + 1, word) ||
                dfs(grid, i, j+1, count + 1, word) ||
                dfs(grid, i+1, j, count + 1, word);
        if(isFound)
            path.add(i + "," + j);
        else
            grid[i][j] = temp;
        return isFound;
    }
}
