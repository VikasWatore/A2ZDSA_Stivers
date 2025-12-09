package main.java.Arrays;
//Problem Statement:
// Given an integer N and an array of size N-1 containing N-1 numbers between 1 to N.
// Find the number(between 1 to N), that is not present in the given array.
//Example 1:
//Input Format: N = 5, array[] = {1,2,4,5}
//Result: 3
//Explanation: In the given array, number 3 is missing. So, 3 is the answer.

public class FindMissingNumberInAnArray {

    public static void main(String[] args) {
        int[] a = {1, 2, 4, 5};
        int N = 5;
        int ans = missingNumber(a, N);
        System.out.println("The missing number is: " + ans);
        int ans2 = missingNumberWithSum(a, N);
        System.out.println("The missing number is with Sum: " + ans2);

        int ans3 = missingNumberWithXor(a, N);
        System.out.println("The missing number is with Sum: " + ans3);
    }

    //brute Force
    // Time Complexity: O(N*N), since nested for loops are used
    //Space Complexity: O(1). No extra space used
    private static int missingNumber(int[] a, int n) {
        for (int i = 1; i < n; i++) {
            boolean found = false;
            for (int j = 0; j < n - 1; j++) {
                if (a[j] == i) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return i;
            }
        }
        return -1;
    }


    //Better Approach with Sum
//    Time Complexity: O(N). Single loop is used
//    Space Complexity: O(3N) where 3 is for the stack, left small array and a right small array
    private static int missingNumberWithSum(int[] arr, int n) {

        int sum = (n * (n + 1) / 2);
        int actualSum = 0;

        for (int i = 0; i < n - 1; i++) {
            actualSum += arr[i];
        }
        return sum - actualSum;
    }


//    Time Complexity: O(N). For loop is used
//    Space Complexity: O(1). No extra space used
    private static int missingNumberWithXor(int[] arr, int n) {
        int xor1 = 0, xor2 = 0;
        for (int i = 0; i < n - 1; i++) {
            xor2 ^= arr[i];

            xor1 ^= (i + 1);

        }
        xor1 ^= n;
        return xor1 ^ xor2;
    }

}

