package geeks;

public class CountInversions {

    public static void main(String[] args) {
        long[] arr =
                { 174, 165, 142, 212, 254, 369, 48, 145, 163, 258, 38, 360, 224,
                        242, 30, 279, 317, 36, 191, 343, 289, 107, 41, 443, 265, 149,
                        447, 306, 391, 230, 371, 351, 7, 102 };
        long res = inversionCount(arr, 34);
        System.out.println(res);
    }

    static long count = 0;

    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long inversionCount(long[] arr, long N) {
        // Your Code Here
        mergeSort(arr, 0, arr.length - 1);
        return count;
    }

    static long[] mergeSort(long[] nums, int lo, int hi) {
        if (lo == hi) {
            long[] base = new long[1];
            base[0] = nums[lo];
            return base;
        }

        int mid = lo + (hi - lo) / 2;
        long[] left = mergeSort(nums, lo, mid);
        long[] right = mergeSort(nums, mid + 1, hi);
        return mergeSortedArrays(left, right);
    }

    static long[] mergeSortedArrays(long[] left, long[] right) {
        long[] merged = new long[left.length + right.length];
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                merged[k] = left[i];
                i++;
                k++;
            } else {
                count += (left.length - i);
                merged[k] = right[j];
                j++;
                k++;
            }
        }

        while (i < left.length) {
            merged[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            merged[k] = right[j];
            j++;
            k++;
        }
        return merged;
    }
}
