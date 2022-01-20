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
                if (matrix[i][j] == 1)
                    res++;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            matrix[i][0] += matrix[i-1][0];
        }

        for (int i = 1; i < matrix[0].length; i++) {
            matrix[0][i] += matrix[0][i-1];
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                matrix[i][j] += matrix[i-1][j] + matrix[i][j-1] - matrix[i-1][j-1];
            }
        }

        for (int side = 2; side <= Math.min(matrix.length, matrix[0].length); side++) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (i-side >= 0
                            && j-side >= 0
                            && matrix[i][j] - matrix[i-side][j] - matrix[i][j-side] + matrix[i-side][j-side] == side * side)
                        res++;
                    else if (i - side >= 0 && j-side < 0 && matrix[i][j] - matrix[i-side][j] == side * side){
                        res++;
                    } else if (j-side >= 0 && i-side < 0 && matrix[i][j] - matrix[i][j-side] == side * side){
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
