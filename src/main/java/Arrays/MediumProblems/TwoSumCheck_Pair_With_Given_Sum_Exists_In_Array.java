package main.java.Arrays.MediumProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumCheck_Pair_With_Given_Sum_Exists_In_Array {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int target = 10;

        String ans = twoSumExists(arr, target);
        System.out.println(ans);

        int[] ans2 = twoSumExistsWithIndex(arr, target);
        System.out.println(Arrays.toString(ans2));

        int[] ans3 = twoSum(arr, target);
        System.out.println(Arrays.toString(ans3));

        int[] ans4 = twoSumWithTwoPointer(arr, target);
        System.out.println(Arrays.toString(ans4));
    }


    // Time Complexity: O(N²) because we use two nested loops to check every possible
    // pair of elements in the array, where N is the size of the array.
    // Space Complexity: O(1) as we use a constant amount of extra space regardless of input size.
    // return yes/No
    public static String twoSumExists(int[] arr, int target) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) break;
                if (arr[i] + arr[j] == target) {
                    return "yes";
                }
            }
        }
        return "No";
    }

    // return index
    public static int[] twoSumExistsWithIndex(int[] arr, int target) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i] + arr[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }


    //optimize Solution with hash

    public static int[] twoSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int rem = target - arr[i];
            if (map.containsKey(rem)) {
                return new int[]{map.get(rem), i};
            }
            map.put(arr[i], i);
        }
        return new int[]{};
    }

    //with two pointer appraoch
    public static int[] twoSumWithTwoPointer(int[] arr, int target) {
        int n = arr.length;

        int[][] arrWithIndex = new int[n][2];

        for (int i = 0; i < n; i++) {
            arrWithIndex[i][0] = arr[i];
            arrWithIndex[i][1] = i;
        }

        Arrays.sort(arrWithIndex, (a, b) -> Integer.compare(a[0], b[0]));

        int left = 0, right = n - 1;

        while (left < right) {
            int sum = arrWithIndex[left][0] + arrWithIndex[right][0];
            if (sum == target) {
                return new int[]{arrWithIndex[left][1], arrWithIndex[right][1]};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }

}
