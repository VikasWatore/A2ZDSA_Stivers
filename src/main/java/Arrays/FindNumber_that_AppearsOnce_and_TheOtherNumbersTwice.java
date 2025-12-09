package main.java.Arrays;

public class FindNumber_that_AppearsOnce_and_TheOtherNumbersTwice {
    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 1, 2};
        int ans = getSingleElement(arr);
        System.out.println("The single element is: " + ans);

        int ans2=getSingleElementWithHash(arr);
        System.out.println("The single element is with Hash: " + ans2);

        int ans3=getSingleElementWithXor(arr);
        System.out.println("The single element is with XOR: " + ans3);

    }
    //brute force
    // Time Complexity: O(N*N), since nested for loops are used
    //Space Complexity: O(1). No extra space used
    private static int getSingleElement(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int num=arr[i];
            int count=0;
            for (int j = 0; j < arr.length; j++) {
                if(arr[j]==num){
                    count++;
                }
            }
            if(count==1) return num;
        }
        return -1;
    }

    //better approach with hashArray
//    Time Complexity: O(N)+O(N)+O(N), where N = size of the array. One O(N) is for finding the maximum,
//    the second one is to hash the elements and the third one is to search the single element in the array.
//    Space Complexity: O(maxElement+1) where maxElement = the maximum element of the array.
    private static int  getSingleElementWithHash(int[] arr){
        int max=0;
        for (int i:arr){
            max=Math.max(i,max);
        }
        int[] hash=new int[max+1];

        for (int i = 0; i < arr.length; i++) {
            hash[arr[i]]++;
        }

        for (int i = 0; i < arr.length; i++) {
            if (hash[arr[i]]==1){
                return arr[i];
            }
        }
        return -1;
    }


    //optimize Approach with XOR
    public static int getSingleElementWithXor(int[] num){
        int xor=0;
        for (int i:num){
            xor^=i;
        }
        return xor;
    }
}
