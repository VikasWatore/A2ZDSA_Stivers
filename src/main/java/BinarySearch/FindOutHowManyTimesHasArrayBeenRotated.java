package main.java.BinarySearch;

public class FindOutHowManyTimesHasArrayBeenRotated {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2,3};

        int rotations = findRotations(arr);

        System.out.println(rotations);
    }

    private static int findRotations(int[] arr) {
      int low=0;
      int high=arr.length-1;
      int ans=Integer.MAX_VALUE;
      int index=-1;
      while (low<=high){
          int mid=low+(high-low)/2;

          if(arr[low]<=arr[high]){
            if(arr[low]<ans){
              index=low;
            ans=arr[low];
            }
            break;
          }

          if(arr[low]<=arr[mid]){
                if (arr[low]<ans){
                    index=low;
                    ans=arr[low];
                }
                low=mid+1;
          }else{
            high=mid-1;
            if (arr[mid]<ans){
                index=mid;
                ans=arr[mid];
            }
          }

      }
        return index;

    }
}
