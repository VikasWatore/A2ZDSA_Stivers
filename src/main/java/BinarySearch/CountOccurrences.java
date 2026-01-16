package main.java.BinarySearch;

public class CountOccurrences {
   public static void main(String[] args) {
        int[] arr={1,2,3,3,3,4,5};
        int target=3;
       System.out.println(findOccurrence(arr,target));
    }
    public static int findOccurrence(int[] arr,int target){

        int first=findFirstOcc(arr,target);
        int last=findLastOcc(arr,target);
        return last-first+1;
    }

    private static int findLastOcc(int[] arr, int target) {
        int low=0;
        int high=arr.length-1;
        int last=-1;

        while (low<=high){
            int mid=low+(high-low)/2;

            if(arr[mid]==target){
                last=mid;
                low=mid+1;
            }else if (arr[mid]<target){
                low=mid+1;
            }else {
                high=mid-1;
            }
        }
        return last;
    }


    private static int findFirstOcc(int[] arr, int target) {
        int low=0;
        int high=arr.length-1;
        int first=-1;

        while (low<=high){
            int mid=low+(high-low)/2;

            if(arr[mid]==target){
                first=mid;
                high=mid-1;
            }else if (arr[mid]<target){
                low=mid+1;
            }else {
                high=mid-1;
            }
        }
        return first;
    }

}
