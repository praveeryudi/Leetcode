package solutions;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {12,1,20,4,3,27,19,-5};
        mergeSort(arr, 8);
    }

    public static void mergeSort(int[] arr, int n) {
        // Write your code here.
        arr = doSort(arr, 0, n-1);
        System.out.println(Arrays.toString(arr));
    }

    private static int[] doSort(int[] nums, int low, int high) {
        if(low == high) {
            return new int[] {nums[low]};
        }
        int mid = low + (high - low) / 2;
        int[] left = doSort(nums, low, mid);
        int[] right = doSort(nums, mid + 1, high);
        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        int[] sorted = new int[left.length + right.length];
        while(i < left.length && j < right.length) {
            if(left[i] <= right[j]) {
                sorted[k] = left[i];
                i++;
            } else {
                sorted[k] = right[j];
                j++;
            }
            k++;
        }

        while(i < left.length) {
            sorted[k] = left[i];
            i++;
            k++;
        }
        while(j < right.length) {
            sorted[k] = right[j];
            j++;
            k++;
        }
        return sorted;
    }
}
