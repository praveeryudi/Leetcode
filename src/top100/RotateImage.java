package top100;

/**
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * Note:
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 * DO NOT allocate another 2D matrix and do the rotation.
 */
public class RotateImage {
    public static void main(String[] args) {
        int[][] image = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        rotateImage(image);
        printImage(image);
    }

    // Print the image
    private static void printImage(int[][] image) {
        for (int[] row : image) {
            for (int c = 0; c < image[0].length; c++) {
                System.out.print(row[c] + " ");
            }
            System.out.println("");
        }
    }

    private static void rotateImage(int[][] image) {
        int rows = image.length;
        int cols = image[0].length;

        // Find transpose
        for(int i = 0; i < rows; i++) {
            for(int j = i; j < cols; j++) {
                int temp = image[i][j];
                image[i][j] = image[j][i];
                image[j][i] = temp;
            }
        }

        //printImage(image);

        for(int[] row : image) {
            int start = 0, end = row.length - 1;
            while(start <= end) {
                int temp = row[start];
                row[start] = row[end];
                row[end] = temp;
                start++;
                end--;
            }
        }
    }
}
