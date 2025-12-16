package main.java.Arrays.MediumProblems;

//t: Given an N * N 2D integer matrix, rotate the matrix by 90 degrees clockwise.
//The rotation must be done in place, meaning the input 2D matrix must be modified directly.
//Input :matrix = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
//matrix = [[7, 4, 1], [8, 5, 2], [9, 6, 3]]

public class RotateMatrixBy90Degrees {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        int[][] rotated = rotate(matrix);
        for (int[] n1:rotated){
            for (int n:n1){
                System.out.print(n +" " );
            }
        }

        rotateMatrix(matrix);
        for (int[] m : matrix) {
            for (int num : m) {
                System.out.print(num + " ");
            }
        }
    }

    //brute force
//    Time Complexity: O(N²),Each element of the matrix is visited exactly once and placed into
//    a new matrix, so the time taken is proportional to the total number of elements.
//    Space Complexity: O(N²),We use an additional matrix of the same size to store
//    the rotated result, leading to O(N²) extra space.
    public static int[][] rotate(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[j][n - 1 - i] = arr[i][j];
            }
        }
        return ans;
    }


    //optimizes approach
//    Time Complexity: O(N²),We traverse every element once during
//    transposition and again during reversal of each row, resulting in a total of O(N²) time.
//    Space Complexity: O(1),All operations are done in-place using only temporary variables.
//    No extra matrix is used.
    public static void rotateMatrix(int[][] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;

            while (left < right) {
                int temp = arr[i][left];
                arr[i][left] = arr[i][right];
                arr[i][right] = temp;
                left++;
                right--;
            }
        }
    }


}
