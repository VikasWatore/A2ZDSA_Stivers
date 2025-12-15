package main.java.Arrays.MediumProblems;

//Input: matrix=[[1,1,1],[1,0,1],[1,1,1]]
//Output: [[1,0,1],[0,0,0],[1,0,1]]
//Explanation: Since matrix[2][2]=0.Therfore the 2nd column and 2nd row wil be set to 0.
public class SetMatrixZero {
    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
//        toZero(matrix);
//
//        for (int[] row:matrix){
//            for (int val:row){
//                System.out.print(val+" ");
//            }
//        }


        zeroMatrix(matrix);
        for (int[] row:matrix){
            for (int val:row){
                System.out.print(val+" ");
            }
        }
    }
//    Time Complexity: O(m * n * (m + n)), We iterate through every cell (m * n), and for each zero,
//    we potentially mark its entire row (O(n)) and column (O(m)), leading to O(m * n * (m + n)) overall.
//
//    Space Complexity: O(1), We are not using any extra data structures,
//    only modifying the matrix in place (apart from a few variable
    public static void toZero(int[][] nums){
        int m= nums.length;
        int n=nums[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(nums[i][j]==0){
                    for (int col=0;col<n;col++){
                        if (nums[i][col]!=0){
                            nums[i][col]=-1;
                        }
                    }
                    for (int row = 0; row <m ; row++) {
                         if(nums[row][j]!=0){
                             nums[row][j]=-1;
                         }
                    }
                }
            }           
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (nums[i][j]==-1){
                    nums[i][j]=0;
                }
            }
        }
    }

//    Time Complexity: O(m × n),We make two passes over the matrix.
//    First pass to identify rows and columns to be zeroed (O(m × n)).
//    Second pass to update the matrix using the markers (O(m × n)).
//    Total time is proportional to the number of cells in the matrix, so O(m × n).

//    Space Complexity: O(m + n),We store two extra arrays one for m rows and one for n columns.
//    No other extra space is used besides these arrays.
    public static void zeroMatrix(int[][] matrix){
        int m=matrix.length;
        int n=matrix[0].length;
        int[] col=new int[m];
        int[] row=new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j]==0){
                    row[i]=1;
                    col[j]=1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if( row[i] ==1||col[j]==1){
                      matrix[i][j]=0;
                }
            }
        }
    }
}
