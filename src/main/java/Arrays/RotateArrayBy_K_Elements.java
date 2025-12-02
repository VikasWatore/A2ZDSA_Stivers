package Arrays;

import java.util.Arrays;

public class RotateArrayBy_K_Elements {

    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6,7};
        int k=2;

         leftRotateArray(nums,k);
        System.out.println("LeftRotatedArray :");
         for(int n: nums){
             System.out.print(n+" ");
         }
         int[] num2={1,2,3,4,5,6,7};
        System.out.println();

        System.out.println("RightRotatedArray :");
        int k2=2;
         rightRotateArray(num2,k2);
         for (int n:num2){
             System.out.print(n+" ");
         }

        System.out.println("\nRightRotatedArray :");
         int[] num3={10,20,30,40,50,60,70};
         int k3=5;
         rotateArray(num3,k3,"right");
         for (int n:num3){
             System.out.print(n+" ");
         }

        System.out.println("\nLeftRotatedArray :");
         int[] num4={10,20,30,40,50,60,70};
         int k4=5;
         rotateArray(num4,k4,"left");
        for (int n:num4){
            System.out.print(n+" ");
        }
    }


    private static void leftRotateArray(int[] arr, int k) {
    int n=arr.length;

    if(n==0) return;
    //simplifying for rotations
    k=k%n;

    // temp array for copying the k element

        int[] temp= Arrays.copyOfRange(arr,0,k);

     // shift the remaining elements to right
        for (int i = k; i <n ;i++) {
            arr[i-k]=arr[i];
        }

      // copying stored element of temp to array
        for (int i = 0; i <temp.length ; i++) {
            arr[n-k+i]=temp[i];
        }

    }

    public static void rightRotateArray(int[] arr,int k){
        int n=arr.length;
        if(n==0) return;

        k=k%n;

        // creating temp array
        int[] temp=Arrays.copyOfRange(arr,n-k,n);

        // shift elements
        for (int i = n-k-1; i >=0 ; i--) {
            arr[i+k]=arr[i];
        }

        //copy stored temp to array
        for (int i = 0; i <temp.length ; i++) {
            arr[i]=temp[i];
        }
    }

    // optimized solution for space(O(1)).

    public static void rotateArray(int[] num,int k,String direction){

        int n=num.length;

        if(n==0) return;

        k=k%n;

        if(direction.equals("right")){
            // Step 1: reverse entire array
            reverse(num,0,n-1);
            // Step 2: reverse first k elements
            reverse(num,0,k-1);
            // Step 3: reverse remaining n-k elements
            reverse(num,k,n-1);
        } else if (direction.equals("left")) {
            // Step 1: reverse first k elements
            reverse(num,0,k-1);
            // Step 2: reverse remaining n-k elements
            reverse(num,k,n-1);
            // Step 3: reverse entire array
            reverse(num,0,n-1);
        }

    }

    // reverse array
    public static int[] reverse(int[] arr,int start,int end){
        while (start<=end){

            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
        return arr;
    }
}
