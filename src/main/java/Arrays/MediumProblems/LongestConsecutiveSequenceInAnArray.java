package main.java.Arrays.MediumProblems;
//Problem Statement: Given an array nums of n integers.
//Return the length of the longest sequence of consecutive integers.
// The integers in this sequence can appear in any order.
//Input:
//nums = [100, 4, 200, 1, 3, 2]    //Output: 4
//The longest sequence of consecutive elements in the array is [1, 2, 3, 4],
// which has a length of 4. This sequence can be formed regardless of the
// initial order of the elements in the array.


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequenceInAnArray {

    public static void main(String[] args) {
        int[] num = {100, 4, 200, 1, 3, 2};
        int ans = longestConsSeq(num);
        System.out.println(ans);

        int ans2=longestConsSequence(num);
        System.out.println(ans2);

        int ans3=longConSeq(num);
        System.out.println(ans3);
    }

    public static int longestConsSeq(int[] num) {
        int n = num.length;
        int longest = 1;
        for (int i = 0; i < n; i++) {
            int number = num[i];
            int count = 1;
            while (linearSearch(num, number + 1)) {
                number = number + 1;
                count = count + 1;
            }
            longest=Math.max(longest,count);
        }
        return longest;
    }

    private static boolean linearSearch(int[] num, int i) {
        for (int n : num) {
            if (n == i)
                return true;
        }
        return false;
    }

    //better Option
    public static int longestConsSequence(int [] num){
        Arrays.sort(num);
        int longest=1;
        int lastSmallest=Integer.MAX_VALUE;
        int count=0;
        for (int i = 0; i < num.length; i++) {
            if(num[i]-1==lastSmallest){
                lastSmallest=num[i];
                count+=1;
            } else if (lastSmallest!=num[i]) {
                lastSmallest=num[i];
                count=1;
            }
            longest=Math.max(longest,count);
        }
       return longest;
    }

    //optimized Solution
    public static int longConSeq(int[] nums){
        int n= nums.length;
        if (n==0) return 0;
        int longest=1;

        Set<Integer> set=new HashSet<>();
        for (int no:nums){
            set.add(no);
        }

        for (int num:set){
            if(!set.contains(num-1)){
                int count=1;
                int x=num;

                while (set.contains(x+1)){
                    x=x+1;
                    count++;
                }
                longest=Math.max(longest,count);
            }
        }
        return longest;
    }
}
