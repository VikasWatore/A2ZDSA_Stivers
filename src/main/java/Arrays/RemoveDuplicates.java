package Arrays;


import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] arr={1, 2, 2, 3, 1};

        removeDuplicates(arr);
      removeDuplicatesInSortedArray(arr);

        for (int i = 0; i <arr.length ; i++) {

            System.out.print(arr[i]+" ");
        }

    }

    public static int removeDup(int[] arr){

        int p=0;
        for (int i = 1; i <arr.length ; i++) {
            if(arr[i]!=arr[p]) {
                p++;
                arr[p] = arr[i];
            }
        }
        return p+1;
    }
    //brute force with set
    public static void removeDuplicates(int[] arr ){
        Set<Integer> set=new LinkedHashSet<>();

        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        int index=0;
        for (int s:set){
            arr[index]=s;
            index++;
        }
    }

    //with two pointer
    public static void removeDuplicatesInSortedArray(int[]arr){
        int p=0;
        for (int i = 1; i <arr.length ; i++) {
            if(arr[i]!=arr[p]){
                p++;
                arr[p]=arr[i];

            }
        }
    }
}
