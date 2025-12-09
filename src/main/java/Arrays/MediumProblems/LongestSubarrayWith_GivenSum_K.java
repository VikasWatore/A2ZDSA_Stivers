package Arrays.MediumProblems;

import java.util.HashMap;
import java.util.Map;

//Problem Statement: Given an array nums of size n and an integer k, find the length of the longest sub-array that sums to k. If no such sub-array exists, return 0.
//Examples
//Input: nums = [10, 5, 2, 7, 1, 9], k = 15
//Output: 4
//Explanation: The longest sub-array with a sum equal to 15 is [5, 2, 7, 1], which has a length of 4. This sub-array starts at index 1 and ends at index 4, and the sum of its elements (5 + 2 + 7 + 1) equals 15. Therefore, the length of this sub-array is 4.
public class LongestSubarrayWith_GivenSum_K {
    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 7, 1, 9};
        int k = 14;
        int ans = longSubArray(nums, k);
        System.out.println(ans);
        int ans2 = longSubArrayWithHashmap(nums, k);
        System.out.println(ans2);
    }

    //brute Force
//    Time Complexity: O(n2), where n is the size of the array.
//    This is because we have three nested loops: one for the starting index, one for the ending index, and
//    one for calculating the sum of the subarray.
//    Space Complexity: O(1), as we are using a constant amount of space for variables and not using
//    any additional data structures that grow with input size.
    private static int longSubArray(int[] arr, int k) {
        int length = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];

                if (sum == k) {
                    length = Math.max(length, j - i + 1);
                }
            }
        }
        return length;
    }


    //better solution with hashmap and prefix sum
//    Time Complexity: O(N) or O(N*logN) depending on which map data structure
//    we are using, where N = size of the array.
//    Space Complexity: O(N) as we are using a map data structure.
    public static int longSubArrayWithHashmap(int[] arr, int k) {
        Map<Integer, Integer> seenSum = new HashMap<>();
        int res = 0;
        int prefixSum = 0;

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            if (seenSum.containsKey(prefixSum - k)) {
                res = Math.max(res, i - seenSum.get(prefixSum - k));
            }
            if (!seenSum.containsKey(prefixSum)) {
                seenSum.put(prefixSum, i);
            }
        }
        return res;
    }



}
