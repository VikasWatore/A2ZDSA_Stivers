package main.java.BinarySearch;

public class FloorAndCeilInSortedArray {
    public static void main(String[] args) {
        int[] arr = {3, 4, 4, 7, 8, 10};
        int x = 5;
        int[] ans = findFloorAndCeil(arr, x);
        System.out.println("floor is "+ans[0] +" And "+ "Ceil is " +ans[1]);
    }
    public static int[] findFloorAndCeil(int[] arr,int target){
        int floor=findFloor(arr,target);
        int ceil=findCeil(arr,target);
        return new int[]{floor,ceil};
    }

    public static int findFloor(int[] arr,int target){
        int n=arr.length;
        int low=0;
        int high=n-1;
        int ans=-1;

        while (low<=high){
            int mid=low+(high-low)/2;

            if (arr[mid]<=target){
                ans=arr[mid];
              low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }

    public static int findCeil(int[] arr,int target){
        int n=arr.length;
        int low=0;
        int high=n-1;
        int ans=-1;
        while (low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]>=target){
                ans=arr[mid];
                high=mid-1;
            }
            else
                low=mid+1;
        }
        return ans;
    }

}
