package main.java.Arrays;

public class FindSecondSmallest_And_SecondLargestElement {
    public static void main(String[] args) {
        int[] arr={1,2,5,4,8,7};
        int secondSmallest=secondSmallest(arr);
        int secondLargest=secondLargest(arr);

        System.out.println("SecondSmallest: "+secondSmallest+ " SecondLargest: "+secondLargest);

    }
    public static int secondLargest(int[] arr){
        int largest=arr[0],secondlargest=-1;

        for (int i = 1; i <arr.length ; i++) {
            if(arr[i]>largest){
                secondlargest=largest;
                largest=arr[i];
            }else if(arr[i]<largest && arr[i]>secondlargest){
                secondlargest=arr[i];
            }
        }
        return secondlargest;
    }

    public static int secondSmallest(int[] arr){

        int smallest=arr[0];
        int secSmallest=Integer.MAX_VALUE;
        for (int i = 1; i <arr.length ; i++) {
            if(arr[i]<smallest){
                secSmallest=smallest;
                smallest=arr[i];
            }else if(arr[i]>smallest && arr[i]<secSmallest){
                secSmallest=arr[i];
            }

        }
        return secSmallest;
    }

}
