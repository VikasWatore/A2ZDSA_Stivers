package main.java.BinarySearch;
//Example 1:
//Input Format: arr = [7, 8, 1, 2, 3, 3, 3, 4, 5, 6], k = 3
//Result: True
//Explanation: The element 3 is present in the array. So, the answer is True.
public class SearchElementInRotatedSortedArrayII {
    public static void main(String[] args) {
        int[] nums={7, 8, 1, 2, 3, 3, 3, 4, 5, 6};
        int target=5;

        System.out.println(searchWithBinarySearch(nums,target));
    }

    private static boolean searchWithBinarySearch(int[] nums, int target) {
        int n=nums.length;
        int low=0;
        int high=n-1;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                return true;
            }
            if(nums[low]==nums[mid] && nums[mid]==nums[high]){
                low=low+1;
                high=high-1;
                continue;
            }

            if(nums[low]<=nums[mid]){
                if(nums[low]<=target && target<=nums[mid]){
                    high=mid-1;
                }else {
                     low=mid+1;
                }
            }else {
                if(nums[mid]<=target && target<=nums[high]){
                    low=mid+1;
                }else {
                    high=mid-1;
                }
            }
        }
        return false;
    }
}
