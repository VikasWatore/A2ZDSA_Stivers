package main.java.Arrays;
// Given an array, and an element num the task is to find if num is present in the given array or not.
// If present print the index of the element or print -1.
public class LinearSearch {
    public static void main(String[] args) {
        int[] arr={10,2,0,30,40,45};
        int target=40;
        int index= linSearch(arr,target);
        System.out.println(index);
    }

    private static int linSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==target){
                return i;
            }
        }
        return -1;
    }
}
