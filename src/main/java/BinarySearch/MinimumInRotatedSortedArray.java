package main.java.BinarySearch;

public class MinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int [] arr={7,8,9,1,2,3,4,5};
        int n=arr.length;
        System.out.println(findMin(arr,n));
    }
    public static int findMin(int[] arr,int n){
        int low=0;
        int high=n-1;
        int ans=Integer.MAX_VALUE;

        while (low<=high){
            int mid=low+(high-low)/2;
            if(arr[low]<=arr[mid]){
            ans=Math.min(ans,arr[low]);
            low=mid+1;
            }else {
                ans=Math.min(ans,arr[mid]);
                high=mid-1;
            }
        }
        return ans;
    }

}
