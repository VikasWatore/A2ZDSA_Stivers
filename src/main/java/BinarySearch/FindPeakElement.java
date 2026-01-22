package main.java.BinarySearch;

public class FindPeakElement {
    public static void main(String[] args) {
        int[] nums = {1, 3, 20, 4, 1, 0};
        int index = findPeak(nums);
        System.out.println("Peak at index: " + index + " with value: " + nums[index]);

        int ind=findPeakWithBS(nums);
        System.out.println("Peak at index: " + ind + " with value: " + nums[index]);
    }

    public static int findPeak(int[] arr){

        for (int i = 0; i < arr.length; i++) {

            if((i==0 || arr[i-1]<arr[i]) && (i==arr.length-1 || arr[i]>arr[i+1])){
                return i;
            }
        }
        return -1;
    }

    public static int findPeakWithBS(int[] arr){
        int n=arr.length;

        if (n==1){
            return arr[0];
        }

        if(arr[0]>arr[1]){
            return arr[0];
        }
        if (arr[n-1]>arr[n-2]){
            return arr[n-1];
        }


        int low=1;
        int high=n-2;

        while (low<=high){
            int mid=low+(high-low)/2;

            if(arr[mid]>arr[mid+1] && arr[mid]>arr[mid-1]){
                return mid;
            }
            else if(arr[mid]>arr[mid-1]){
                low=mid+1;
            }else {
                high=mid-1;
            }
        }
        return 1;
    }

}
