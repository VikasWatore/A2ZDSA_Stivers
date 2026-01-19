package main.java.BinarySearch;

//Input:nums = [4, 5, 6, 7, 0, 1, 2], k = 0
//Output :4
//Explanation : Here, the target is 0. We can see that 0 is present in the given rotated sorted array, nums.
//Thus, we get output as 4, which is the index at which 0 is present in the array.

public class SearchElementInARotatedSortedArray {
    public static void main(String[] args) {
        int[] nums={4, 5, 6, 7, 0, 1, 2};
        int target=0;
        System.out.println(search(nums,target));
        System.out.println(sBS(nums,target));
    }

    //brute force
    private static int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==target){
                return i;
            }
        }
        return -1;
    }

    //With Binary Search
    public static int sBS(int[] arr,int target){
        int n=arr.length;
        int low=0;
        int high=n-1;

        while (low<=high){
            int mid=low+(high-low)/2;

            if(arr[mid]==target){
                return mid;
            }

            if (arr[low]<=arr[mid]){

                if(arr[low]<=target && target<=arr[mid]){
                    high=mid-1;
                }else {
                    low=mid+1;
                }

            }else{
            if(arr[mid]<=target && target<=arr[high]){
                low=mid+1;
            }else {
                high=mid-1;
            }
            }
        }
        return -1;
    }

}
