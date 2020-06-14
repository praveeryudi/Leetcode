package array;

import java.util.ArrayList;
import java.util.List;

public class _986_Interval_List_Intersections {

    public static void main(String[] args) {
        int[][] A = new int[][] {{0,2},{5,10},{13,23},{24,25}};
        int[][] B = new int[][] {{1,5},{8,12},{15,24},{25,26}};

        int len1 = A.length;
        int len2 = B.length;

        List<int[]> result = new ArrayList<>();
        int i = 0, j = 0;
        while(i < len1 && j < len2) {

            int[] a = A[i];
            int[] b = B[j];
            int lowerBound = Math.max(a[0], b[0]);
            int upperBound = Math.min(a[1], b[1]);
            if(lowerBound <= upperBound) {
                result.add(new int[] {lowerBound, upperBound});
            }
            if(a[1] < b[1])
                i++;
            else
                j++;
        }

        int[][] output = new int[result.size()][2];
        int k = 0;
        for(int[] arr : result) {
            output[k++] = arr;
        }

        for(int r = 0; r < output.length; r++) {
            for(int c = 0; c < output[0].length; c++) {
                System.out.print(output[r][c] + " ");
            }
            System.out.println("");
        }
    }
}
