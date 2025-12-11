package main.java.Arrays.MediumProblems;

import java.util.HashMap;
import java.util.Map;

//Problem Statement: Given an integer array nums of size n, return the majority element of the array.
//The majority element of an array is an element that appears more than n/2 times in the array. The array is guaranteed to have a majority element.
//Example 1:
//Input: nums = [7, 0, 0, 1, 7, 7, 2, 7, 7]
//Output: 7
//Explanation: The number 7 appears 5 times in the 9-sized array, making it the most frequent element.
//Example 2:
//Input: nums = [1, 1, 1, 2, 1, 2]
//Output: 1
//Explanation: The number 1 appears 4 times in the 6-sized array, making it the most frequent element.
public class FindMajorityElementOccursMoreThan_N_2times {

    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        int ans = majorityElement(arr);
        int ans2 = majorityElementWithHash(arr);
        int ans3 = majorityElementWithVotingAlgorithm(arr);
        // Print the majority element found
        System.out.println("The majority element is: " + ans);

        System.out.println("The majority element is: " + ans2);

        System.out.println("The majority element is: " + ans3);
    }

    //    Complexity Analysis
    //    Time Complexity: O(N^2), where N is the size of the input array.
    //    This is because we are using a nested loop to count the occurrences of each element.
    //    Space Complexity: O(1), as we are using a constant amount of space for the counters
    //    and indices.
    private static int majorityElement(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == arr[i]) {
                    count++;
                }
            }
            if (count > (arr.length / 2)) return arr[i];
        }
        return -1;
    }

    //better optimization with hashing
//    Time Complexity: O(N), where N is the size of the input array. This is because
//    we are iterating through the array once to count occurrences and then iterating through the hashmap to find the majority element.
//    Space Complexity: O(N), as we are using a hashmap to store the counts of each element, which can take up to N space in the worst case.
    private static int majorityElementWithHash(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> num : map.entrySet()) {
            if (num.getValue() > n / 2) {
                return num.getKey();
            }
        }
        return -1;
    }

    //optimized solution using Moore's Voting algorithm
//    Time Complexity: O(N), where N is the size of the input array.This is because
//    we are iterating through the array once to find the potential majority element
//    and then again to verify it.
//    Space Complexity: O(1), as we are using only a constant amount of extra space.
    private static int majorityElementWithVotingAlgorithm(int[] arr) {

        int element = 0;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (count == 0) {
                count++;
                element = arr[i];
            } else if (arr[i] == element) {
                count++;
            } else {
                count--;
            }
        }

        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                counter++;
            }
        }

        if (counter > arr.length / 2) return element;

        return -1;
    }


}
