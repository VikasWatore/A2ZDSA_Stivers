package main.java.BinarySearch;

public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7};
        int x = 6;
        int ans = sIP(arr, x);
        System.out.println(ans);
    }

    public static int sIP(int[] arr,int target){
        int n=arr.length;
        int ans=n;
        int low=0;
        int high=n-1;
        while (low<=high){
            int mid=low+(high-low)/2;

            if(arr[mid]>=target){
                ans=mid;
                high=mid-1;
            }else {
                low=mid+1;
            }
        }
        return ans;
    }
}
