package main.java.Arrays.MediumProblems;
//Problem Statement: Given an integer array nums, find the subarray with the
// largest sum and return the sum of the elements present in that subarray.
//A subarray is a contiguous non-empty sequence of elements within an array
//Input: nums = [2, 3, 5, -2, 7, -4]
//Output: 15
//Explanation: The subarray from index 0 to index 4 has the largest sum = 15, which is the maximum sum of any contiguous subarray.

//Input: nums = [-2, -3, -7, -2, -10, -4]
//Output: -2
//Explanation: The largest sum is -2, which comes from taking the element at index 0 or index 3 as the subarray. Since all numbers are negative, the subarray with the least negative number gives the largest sum.
public class MaximumSubarraySumInAnArray {
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int maxSum = maxSubArray(arr);
        int maxiSum = maxSubArrayWithKandnesAlgo(arr);
        // Print the max subarray sum
        System.out.println("The maximum subarray sum is: " + maxSum);

        System.out.println("The maximum subarray sum is: " + maxiSum);

        int maxs=maxSubArrayWithKandnesAlgoSub(arr);
        System.out.println(maxs);
    }


    //    Time Complexity: O(N^2), where N is the size of the array. This is because we have three nested loops:
    //    one for the starting index, one for the ending index, and one for calculating the sum of the subarray.
    //    Space Complexity: O(1), as we are using a constant amount of space for variables, regardless of the input size.
    private static int maxSubArray(int[] arr) {
        int n = arr.length;
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                maxi = Math.max(maxi, sum);
            }
        }
        return maxi;
    }

    //optimized with Kadane's Algorithm
//    Time Complexity: O(n), where n is the number of elements in the array. We traverse the array only once.
//    Space Complexity: O(1). We use a constant amount of space for variables.
    private static int maxSubArrayWithKandnesAlgo(int[] arr) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            max = Math.max(max, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
    //to give the subarray
    private static int maxSubArrayWithKandnesAlgoSub(int[] arr) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int start=0;
        int ansStart=-1,ansEnd=-1;
        for (int i = 0; i < arr.length; i++) {
            if(sum==0){
                start=i;
            }

            sum += arr[i];
            if(sum>max){
                max=sum;
                ansStart=start;
                ansEnd=i;
            }
            if (sum < 0) {
                sum = 0;
            }
        }

        // Printing the subarray
        System.out.print("The subarray is: [");
        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
        return max;
    }

}
