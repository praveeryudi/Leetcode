package _30daychallenge;

import java.util.Arrays;

public class MoveZeroes {

    public static void main(String[] args) {
        int[] arr = new int[]{0,2,0,-1,3,0,0,4};
        int idx = 0;
        for(int index = 0; index < arr.length; index++) {
            if(arr[index] != 0) {
                arr[idx++] = arr[index];
            }
        }

        // Fill Zeroes
        for(int index = idx; index < arr.length; index++) {
            arr[index] = 0;
        }

        System.out.println(Arrays.toString(arr));
    }

}
