package solutions;

public class _37_Sudoku_Solver {

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        solveSudoku(board);

        // Print the board
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
    }

    private static void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }

    private static boolean solve(char[][] board, int i, int j) {

        if(i == board.length)
            return true;

        int next_row = 0;
        int next_col = 0;
        if (j == board[0].length - 1) {
            next_row = i + 1;
            next_col = 0;
        } else {
            next_row = i;
            next_col = j + 1;
        }

        if (board[i][j] != '.') {
            return solve(board, next_row, next_col);
        }
        else {
            for (int option = 1; option <= 9; option++) {
                if (isValid(board, i, j, option)) {
                    board[i][j] = Character.forDigit(option, 10);
                    if(solve(board, next_row, next_col))
                        return true;
                }
                board[i][j] = '.';
            }
        }
        return false;
    }

    private static boolean isValid(char[][] board, int r, int c, int option) {
        // Check all columns
        for (int i = 0; i < board[0].length; i++) {
            if (Character.getNumericValue(board[r][i]) == option) {
                return false;
            }
        }

        // Check all rows
        for (int i = 0; i < board.length; i++) {
            if (Character.getNumericValue(board[i][c]) == option) {
                return false;
            }
        }

        // Check sub grid
        int sub_start_x = 3 * (r / 3);
        int sub_start_y = 3 * (c / 3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Character.getNumericValue(board[i + sub_start_x][j + sub_start_y]) == option)
                    return false;
            }
        }
        return true;
    }

}
