package io.lvlvforever;

import java.util.Arrays;

/**
 * Created by lvlvforever on 2018/7/18.
 */
public class Q14_2 {
    public static void main(String[] args) {
        Q14_2 obj = new Q14_2();
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        obj.reOrderArray(a);
    }

    public void reOrderArray(int[] array) {
        if (array == null || array.length < 1) {
            return;
        }


        for (int i = 1; i < array.length; i++) {

            for (int j = i; j > 0; j--) {
                if (!isEven(array[j]) && isEven(array[j - 1])) {
                    swap(array, j, j - 1);
                }
            }

        }


        System.err.println(Arrays.toString(array));
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 判断是否是偶数
     *
     * @param num
     * @return
     */
    private boolean isEven(int num) {
        return (num & 1) == 0;
    }
}
