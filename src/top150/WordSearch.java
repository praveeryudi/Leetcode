package top150;

public class WordSearch {

    private static boolean dfs(char[][] arr, String word, int r, int c, int count) {
        // check if whole word matched
        if(count == word.length())
            return true;
        // check for bounds
        if(r < 0 || r >= arr.length || c < 0 || c >= arr[0].length)
            return false;
        // check for equality
        if(arr[r][c] != word.charAt(count))
            return false;
        char temp = arr[r][c];
        arr[r][c] = '\0';
        boolean res = dfs(arr, word, r, c-1, count + 1) ||
                dfs(arr, word, r-1, c, count + 1) ||
                dfs(arr, word, r, c + 1, count + 1) ||
                dfs(arr, word, r + 1, c, count + 1);
        arr[r][c] = temp;
        return res;
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCB";
        int rows = grid.length;
        int cols = grid[0].length;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == word.charAt(0) && dfs(grid, word, i, j, 0)) {
                    System.out.println("Word found");
                    break;
                }
            }
        }
    }

}
