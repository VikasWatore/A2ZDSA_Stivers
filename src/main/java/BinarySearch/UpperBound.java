package main.java.BinarySearch;

public class UpperBound {
    public static void main(String[] args) {
        int[] arr = {3, 5, 8, 15, 19};
        int x = 9;
        System.out.println(upBound(arr,x));
    }

    public static int upBound(int[] arr, int target){
        int low=0;
        int high=arr.length-1;
        int ans=arr.length;

        while (low<=high){
            int mid=low+(high-low)/2;

            if(arr[mid]>target){
                ans=mid;
                high=mid-1;
            }else {
                low=mid+1;
            }
        }
        return ans;
    }
}
