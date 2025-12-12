package main.java.Arrays.MediumProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeadersInAnArray {

    public static void main(String[] args) {
        int[] nums = {10, 22, 12, 3, 0, 6};


        List<Integer> ans =leader(nums);

        System.out.print("Leaders in the array are: ");
        for (int leader : ans) {
            System.out.print(leader + " ");
        }
        System.out.println();

        List<Integer> ans2=leaderBacktrack(nums);

        System.out.print("Leaders in the array are: ");
        for (int leader : ans2) {
            System.out.print(leader + " ");
        }
        System.out.println();

    }

//    Time Complexity: O(N2), where N is the size of the input array. This is
//    because we have a nested loop where the outer loop runs N times and the
//    inner loop runs up to N times in the worst case.

//    Space Complexity: O(1), as we are using only a constant amount of extra
//    space for the answer array, which does not depend on the input size.
    public static List<Integer> leader(int[] arr) {
        int n = arr.length;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            boolean leader = true;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    leader = false;
                    break;
                }
            }
            if (leader) {
                ans.add(arr[i]);
            }

        }
        return ans;
    }

//    Time Complexity: O(N), where N is the size of the input array. This is because we traverse the array only once.
//
//    Space Complexity: O(1), as we are using only a constant amount of extra space.
    public static List<Integer> leaderBacktrack(int[] arr){
        List<Integer> leaders=new ArrayList<>();

        if(arr.length==0) return leaders;

        int max=arr[arr.length-1];
        leaders.add(max);
        for (int i = arr.length-1; i >=0 ; i--) {
            if(arr[i]>max){
                leaders.add(arr[i]);
            }
            max=Math.max(max,arr[i]);
        }
        Collections.sort(leaders);

        return leaders;
    }


}
