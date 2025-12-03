package Arrays;

import java.util.ArrayList;
import java.util.List;

//Given an integer array nums, move all the 0's to the end of the array. The relative order of the other elements must remain the same.
//This must be done in place, without making a copy of the array.
public class MoveZerosToEnd {
    public static void main(String[] args) {
        int[] nums={0,1,2,0,4,0,5,0,6,0,10,0};
        mover(nums);
        moveZeros(nums);
        for (int i:nums){
            System.out.print(i+" ");
        }
    }
    //brute force TC:O(2N) SC:O(n)
    private static void mover(int[] nums) {

        List<Integer> list=new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0){
                list.add(nums[i]);
            }
        }

        for (int i = 0; i <list.size() ; i++) {
            nums[i]=list.get(i);
        }

        for (int i = list.size(); i < nums.length ; i++) {
            nums[i]=0;
        }
    }


    //optimize solution with two pointer TC:O(n) sc:O(1)
    private static void moveZeros(int[] arr){
        int j=-1;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==0){
                j=i;
                break;
            }
        }

        if(j==-1) return;

        for (int i = j+1; i < arr.length ; i++) {
            if(arr[i]!=0){
            //swaping
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            j++;
            }
        }


    }


}
