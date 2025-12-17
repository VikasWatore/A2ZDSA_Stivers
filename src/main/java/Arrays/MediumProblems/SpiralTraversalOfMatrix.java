package main.java.Arrays.MediumProblems;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraversalOfMatrix {

    public static void main(String[] args) {
        // Input matrix
        int[][] matrix = {
                { 1,  2,  3,  4 },
                { 5,  6,  7,  8 },
                { 9, 10, 11, 12 },
                { 13,14, 15, 16 }
        };

        // Call spiralOrder function
        List<Integer> ans=spiralOrder(matrix);

        // Print result
        System.out.println(ans);
    }

//    Time Complexity: O(m × n),Because we visit each element of the matrix exactly once,
//    where `m` is the number of rows and `n` is the number of columns.
//    Space Complexity: O(1)We use only a few integer variables to keep track of boundaries
//    (top, bottom, left, right). The `result` vector is part of the output, so it's not counted as extra space.
    private static List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> result=new ArrayList<>();
            int m=matrix.length;
            int n=matrix[0].length;

            int left=0;// starting col
            int right=n-1;//end col
            int top=0;// start row
            int bottom=m-1;//end row

        while (left<=right && top<=bottom){

            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <=bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            if(top<=bottom){
            for (int i = right; i >=left ; i--) {
                result.add(matrix[bottom][i]);
            }
            bottom--;}

            if (left<=right){
                for (int i = bottom; i>=top ; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }
}
