package main.java.Arrays.MediumProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Input: nums = [3,1,-2,-5,2,-4]
//Output: [3,-2,1,-5,2,-4]
//Explanation:
//The positive integers in nums are [3,1,2]. The negative integers are [-2,-5,-4].
//The only possible way to rearrange them such that they satisfy all conditions is [3,-2,1,-5,2,-4].
//Other ways such as [1,-2,2,-5,3,-4], [3,1,2,-2,-5,-4], [-2,3,-5,1,-4,2] are incorrect because they do not satisfy one or more conditions.

public class RearrangeArrayElementBySign {
    public static void main(String[] args) {
        int[] num = {3, 1, -2, -5, 2, -4};
        int[] rearrangeArray = rearrangeArray(num);
        System.out.println(Arrays.toString(rearrangeArray));
        int[] solution = rearrangeArraySolution(num);
        System.out.println(Arrays.toString(solution));
    }

    public static int[] rearrangeArray(int[] nums) {

        int[] arr = new int[nums.length];
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();
        for (int num : nums) {
            if (num > 0) {
                positive.add(num);
            } else {
                negative.add(num);
            }
        }
        for (int i = 0; i < nums.length / 2; i++) {
            arr[2 * i] = positive.get(i);
            arr[2 * i + 1] = negative.get(i);
        }
        return arr;
    }

    public static int[] rearrangeArraySolution(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        int positiveIndex=0,negativeIndex=1;
        for (int i = 0; i < n; i++) {
            if(nums[i]<0){
                arr[negativeIndex]=nums[i];
                negativeIndex+=2;
            }else {
                arr[positiveIndex]=nums[i];
                positiveIndex+=2;
            }
        }
    return arr;
    }
}
