package main.java.Arrays.MediumProblems;

import java.util.Arrays;

//Problem Statement: Given an array nums consisting of only 0, 1, or 2. Sort the array in non-decreasing order.
// The sorting must be done in-place, without making a copy of the original array.
public class SortArrayOf_0s_1s_and_2s {
    public static void main(String[] args) {
        int[] nums = {1, 0, 2, 1, 0};
        sortZeroOneTwoBruteForce(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }

        sortZeroOneTwo(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }

        sort_012(nums);
        System.out.println(Arrays.toString(nums));
    }

    //brute force with mergeSort
    //Time Complexity: (O(n log n)).
    private static void sortZeroOneTwo(int[] arr) {
        int[] sorted = mergeSort(arr);
        System.arraycopy(sorted, 0, arr, 0, arr.length);
    }
    private static int[] mergeSort(int[] arr) {
        if (arr.length <= 1) return arr;
        int mid = arr.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(left, right);
    }
    private static int[] merge(int[] first, int[] second) {
        int[] mix = new int[first.length + second.length];
        int i = 0, j = 0, k = 0;
        while (i < first.length && j < second.length) {
            if (first[i] < second[j]) {
                mix[k] = first[i];
                i++;
            } else {
                mix[k] = second[j];
                j++;
            }
            k++;
        }
        while (i < first.length) {
            mix[k] = first[i];
            i++;
            k++;
        }

        while (j < second.length) {
            mix[k] = second[j];
            j++;
            k++;
        }
        return mix;
    }


    //better optimization
//    Complexity Analysis
//    Time Complexity: O(n),We traverse the array twice: once to count, once to overwrite. Each operation is O(n).
//    Space Complexity: O(1), We use only a constant number of counters regardless of the input size. No extra array is used.
    private static void sortZeroOneTwoBruteForce(int[] arr) {
        int count0 = 0, count1 = 0, count2 = 0;

        for (int i : arr) {
            if (i == 0) {
                count0++;
            } else if (i == 1) {
                count1++;
            } else {
                count2++;
            }
        }
        for (int i = 0; i < count0; i++) {
            arr[i] = 0;
        }
        for (int i = count0; i < count0 + count1; i++) {
            arr[i] = 1;
        }
        for (int i = count0 + count1; i < arr.length; i++) {
            arr[i] = 2;
        }
    }

    //optimize solution
//    Complexity Analysis
//    Time Complexity: O(n) The array is traversed only once using the `mid` pointer.
//    Each element is checked at most once, and swaps are done in constant time.
//    Space Complexity: O(1) Only a few integer pointers (`low`, `mid`, `high`) are used.
//    Sorting is done in-place, requiring no additional space.
    public static void sort_012(int[] arr) {
        int n = arr.length;
        int low = 0, mid = 0, high = n - 1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                swap(arr, mid, high);
                high--;
            }
        }
    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

}
