package Arrays;

public class LeftRotateByOne {
    public static void main(String[] args) {
        int[] num={1,2,3,4,5,6};
        rotate(num);
        for (int i:num){
            System.out.print( i +" ");
        }
    }

    public static void rotate(int[] nums){
        int first=nums[0];
        for (int i = 0; i <nums.length-1 ; i++) {
            nums[i]=nums[i+1];
        }
        nums[nums.length-1]=first;
    }


}