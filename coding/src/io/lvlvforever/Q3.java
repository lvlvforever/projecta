package io.lvlvforever;

public class Q3 {
    public boolean Find(int target, int[][] array) {
        if (array == null || array.length < 1) {
            return false;
        }
        int rows = array.length - 1;
        int cols = array[0].length - 1;
        int i = 0, j = cols;
        while (i <= rows && j >= 0) {
            int ele = array[i][j];
            if (ele == target) {
                return true;
            } else if (ele < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
