package Arrays;

public class Largest_Element_Array {

    public static void main(String[] args) {
        int[] arr={1,2,5,4,8,7};
        int ans=largest(arr);
        System.out.println(ans);

    }


    public static int largest(int[] arr){
    int max=arr[0];
    //Traverse array elements from second and
    // compare every element with current max
    for (int i = 1; i <arr.length ; i++) {
        if(arr[i]>max){
            max=arr[i];
        }
    }
    return max;
}
}
