package io.lvlvforever;

public class Q8_1 {
    public static void main(String[] args) {

    }

    public int minNumberInRotateArray(int[] array) {
        if (array == null) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] > array[i + 1]) {
                return array[i + 1];
            }
        }
        return array[0];
    }
}
