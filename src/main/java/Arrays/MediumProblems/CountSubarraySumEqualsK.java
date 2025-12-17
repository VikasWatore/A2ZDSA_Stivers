package main.java.Arrays.MediumProblems;

import java.util.HashMap;
import java.util.Map;

public class CountSubarraySumEqualsK {

    public static void main(String[] args) {
        // Input array
        int[] arr = {3, 1, 2, 4};

        // Target sum
        int k = 6;

        // Call function and store result
        int result = subarraySum(arr, k);

        // Print the count of subarrays
        System.out.println("The number of subarrays is: " + result);

        int res=subArraySum(arr,k);
        System.out.println("The number of subarrays is: " + res);
    }

    private static int subarraySum(int[] arr, int target) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {

                    sum += arr[j];

                if (sum == target) {
                    count++;
                }
            }
        }
        return count;
    }
    public static int subArraySum(int[] arr,int target){
        int n=arr.length;
        Map<Integer,Integer> prefixSumMap=new HashMap<>();

        int preSum=0;
        int count=0;
        prefixSumMap.put(0,1);
        for (int i = 0; i < n; i++) {
            preSum+=arr[i];
            int remove=preSum-target;

            if(prefixSumMap.containsKey(remove)){
                count+=prefixSumMap.get(remove);
            }

            prefixSumMap.put(preSum,prefixSumMap.getOrDefault(preSum,0)+1 );
        }
        return count;


    }



}
