package main.java.Arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Given two sorted arrays, arr1, and arr2 of size n and m. Find the union of two sorted arrays.
//The union of two arrays can be defined as the common and distinct elements in the two arrays.
//NOTE: Elements in the union should be in ascending order.
public class UnionOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arr2 = {2, 3, 4, 4, 5, 11, 12};
        ArrayList<Integer> result=findUnion(arr1,arr2);
        System.out.print("Union of arr1 and arr2 is: ");
        for (int val : result) {
            System.out.print(val + " ");
        }

        List<Integer> result2=findUnionWithTwoPointer(arr1,arr2,arr1.length,arr2.length);
        System.out.print("Union of arr1 and arr2 is: ");
        for (int val : result2) {
            System.out.print(val + " ");
        }

    }


    //brute Force Time Complexity : O( (m+n)log(m+n) )
    //    Space Complexity : O(m+n)
    private static ArrayList<Integer> findUnion(int[] arr1, int[] arr2) {
        Set<Integer> set=new HashSet<>();

        for (int num:arr1){
            set.add(num);
        }
        for(int num:arr2){
            set.add(num);
        }

        return new ArrayList<>(set);
    }




    // optimal Approach with two pointer
//    Time Complexity: O(m+n)
//    Space Complexity : O(m+n) {If Space of Union ArrayList is considered} O(1) {If Space of union ArrayList is not considered}
    public static List<Integer> findUnionWithTwoPointer(int[] arr1,int[] arr2,int m,int n){

        List<Integer> union=new ArrayList<>();

        int i=0,j=0;

        while (i<m && j<n){
            if(arr1[i]<arr2[j]){
                if(union.isEmpty() ||union.getLast()!=arr1[i]){
                    union.add(arr1[i]);
                }i++;
            } else if (arr2[j]<arr1[i]) {
                if(union.isEmpty() || union.getLast()!=arr2[j]){
                    union.add(arr2[j]);

                } j++;
            }else {
                if (union.isEmpty() ||union.getLast()!=arr1[i]){
                    union.add(arr1[i]);

                }   i++;
                j++;
            }
        }

        while(i<m){
            if(union.isEmpty()||union.getLast()!=arr1[i]){
                union.add(arr1[i]);
                i++;
            }
        }

        while (j<n){
            if (union.isEmpty()||union.getLast()!=arr2[j]){
                union.add(arr2[j]);
                j++;
            }
        }

        return  union;

    }
}
