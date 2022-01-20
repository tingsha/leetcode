package dynamic;

import java.util.Arrays;

public class Task1277 {
    public static void main(String[] args) {
        System.out.println(new Task1277().countSquares(new int[][]{
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
        }));
        System.out.println(new Task1277().countSquares(new int[][]{
                {1, 0, 1},
                {1, 1, 0},
                {1, 1, 0}
        }));
    }


    public int countSquares(int[][] matrix) {
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i > 0 && j > 0 && matrix[i][j] > 0) {
                    matrix[i][j] = 1 + Math.min(matrix[i - 1][j - 1], Math.min(matrix[i - 1][j], matrix[i][j - 1]));
                }
                res += matrix[i][j];
            }
        }
        return res;
    }
}
