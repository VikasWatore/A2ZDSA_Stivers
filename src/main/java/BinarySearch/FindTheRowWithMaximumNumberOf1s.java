package main.java.BinarySearch;

public class FindTheRowWithMaximumNumberOf1s {
    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 0}, {0, 0, 1}, {0, 0, 0}, {1, 1, 0}};
        int countOne = countOne(matrix);
        System.out.println(countOne);
    }

    public static int countOne(int[][] arr) {

        int m = arr.length;
        int n = arr[0].length;
        int maxCount = -1;
        int index = -1;
        for (int i = 0; i < m; i++) {
            int countOne = 0;
            for (int j = 0; j < n; j++) {
                countOne+=arr[i][j];
            }
            if (maxCount < countOne) {
                maxCount = countOne;
                index = i;
            }
        }

        return index;
    }

}
