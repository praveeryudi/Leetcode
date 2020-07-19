package top100;

import java.util.Arrays;

/**
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color
 * are adjacent, with the colors in the order red, white and blue.
 */
public class SortColors {
    public static void main(String[] args) {
        int[] colors = {2,0,2,1,1,0};

        int low = 0, mid = 0, high = colors.length - 1;
        int temp = -1;
        while(mid <= high) {
            switch(colors[mid]) {
                case 0:
                    temp = colors[low];
                    colors[low] = colors[mid];
                    colors[mid] = temp;
                    low++;
                    mid++;
                    break;

                case 1:
                    mid++;
                    break;

                case 2:
                    temp = colors[high];
                    colors[high] = colors[mid];
                    colors[mid] = temp;
                    high--;
                    break;
            }
        }
        System.out.println(Arrays.toString(colors));
    }
}
