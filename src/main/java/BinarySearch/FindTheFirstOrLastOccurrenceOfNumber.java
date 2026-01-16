package main.java.BinarySearch;

import java.util.Arrays;

public class FindTheFirstOrLastOccurrenceOfNumber {

    public static void main(String[] args) {
        int[] arr={2,4,6,8,8,8,11,13};
        int[] ans=firstAndLast(arr,8);

        System.out.println(Arrays.toString(ans));

        int[] ans2=findFirstAndLast(arr,8);
        System.out.println(Arrays.toString(ans2));
    }

    //brute Force
    public static int[] firstAndLast(int[] arr, int target) {
        int first = -1;
        int last = -1;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==target){
                if(first==-1)
                { first=i ;}
                last=i;
            }
        }
        return new int[]{first,last};
    }
    
    //optimized Solutions
   
   public static int firstOcc(int[] arr,int target){
       int first=-1;
        int low=0;
        int high=arr.length-1;
        
        while (low<=high){
            int  mid=low+(high-low)/2;
            
            if(arr[mid]==target){
                first=mid;
                high=mid-1;
            } else if (arr[mid]<target) {
                low=mid+1;
            }else {
                high=mid-1;
            }
        }
        return first;
   }

   public static int lastOcc(int[] arr,int target){
        int low=0;
        int high=arr.length-1;
        int last=-1;
        while (low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==target){
                last=mid;
                low=mid+1;
            } else if (arr[mid]<target) {
                low=mid+1;
            }else {
                high=mid-1;
            }
        }
        return last;
   }

   
    public static int[] findFirstAndLast(int[] arr,int target){
        int first=firstOcc(arr,target);
        if(first==-1) return new int[]{-1,-1};
        int last=lastOcc(arr,target);
        return new int[]{first,last};
    }
    
}
