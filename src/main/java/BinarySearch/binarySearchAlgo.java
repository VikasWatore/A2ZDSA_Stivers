package main.java.BinarySearch;

public class binarySearchAlgo {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9};
        int ans=binSearch(arr,5);
        System.out.println(ans);
    }
    public static int binSearch(int[] nums,int target){
        int low=0;
        int high=nums.length-1;
        while (low<=high){
            int mid=low+(high-low)/2;
            if (nums[mid]==target){
                return mid;
            }else if (target>nums[mid]){
                low=mid+1;
            }else {
                high=mid-1;
            }
        }
        return -1;
    }
}
