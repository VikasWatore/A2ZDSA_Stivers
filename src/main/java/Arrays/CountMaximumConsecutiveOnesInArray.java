package main.java.Arrays;
//Given an array that contains only 1 and 0 return the count of maximum consecutive ones in the array.
//Input: prices = {1, 1, 0, 1, 1, 1}
//Output: 3
//Explanation: There are two consecutive 1’s and three consecutive 1’s in the array out of which maximum is 3.

public class CountMaximumConsecutiveOnesInArray {
    public static void main(String[] args) {

        int[] nums = {1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1};
        int ans = findMaxConsecutiveOnes(nums);
        System.out.println("The maximum consecutive 1's are " + ans);
    }

    private static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                count = 0;
            }
            max = Math.max(max, count);
        }
        return max;
    }

}
