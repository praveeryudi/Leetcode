package _30daychallenge;

public class Leftmost_Column_1 {

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {0,0,0,1},
                {0,0,1,1},
                {0,1,1,1}
        };
        int res = getLeftmostColumn(matrix);
        System.out.println("Leftmost Column = " + res);
    }

    private static int getLeftmostColumn(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int row = 0, col = cols - 1;
        while(row < rows && col >= 0) {
            if(matrix[row][col] == 1)
                col--;
            else
                row++;
        }
        if(col == cols - 1)
            return -1;
        else
            return col + 1;
    }
}
