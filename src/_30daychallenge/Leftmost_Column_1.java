package _30daychallenge;

/**
 * A binary matrix means that all elements are 0 or 1. For each individual row of the matrix, this row is sorted in non-decreasing order.
 * Given a row-sorted binary matrix binaryMatrix, return leftmost column index(0-indexed) with at least a 1 in it. If such index doesn't exist, return -1.
 */
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
