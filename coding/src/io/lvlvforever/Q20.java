package io.lvlvforever;

import java.util.ArrayList;

/**
 * Created by lvlvforever on 2018/8/1.
 */
public class Q20 {

    public static void main(String[] args) {
        Q20 obj = new Q20();
        int[][] matrix = {{1}, {2}, {3}, {4}, {5}};
        obj.printMatrix(matrix);
    }


    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length < 1) {
            return list;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (rows == 1) {

            for (int i = 0; i < cols; i++) {
                list.add(matrix[0][i]);
            }
            return list;
        }

        if (cols == 1) {

            for (int i = 0; i < rows; i++) {
                list.add(matrix[i][0]);
            }
            return list;
        }
        int start = 0;
        while (start * 2 < rows && start * 2 < cols) {
            for (int i = start; i <= cols - start - 1; i++) {
                list.add(matrix[start][i]);
            }
            int curCol = cols - start - 1;
            if (curCol > start) {
                for (int i = start + 1; i <= rows - start - 1; i++) {
                    list.add(matrix[i][curCol]);
                }
            }
            int curRow = rows - start - 1;

            if (curRow > start) {
                for (int i = cols - start - 2; i >= start; i--) {
                    list.add(matrix[rows - start - 1][i]);
                }
            }
            if (start != curCol) {
                for (int i = rows - start - 2; i >= start + 1; i--) {
                    list.add(matrix[i][start]);
                }
            }
            start++;
        }
        return list;
    }
}
