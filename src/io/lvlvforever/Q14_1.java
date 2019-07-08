package io.lvlvforever;

import java.util.Arrays;

/**
 * Created by lvlvforever on 2018/7/18.
 */
public class Q14_1 {
    public static void main(String[] args) {
        Q14_1 obj = new Q14_1();
        int[] a = {2};
        obj.reOrderArray(a);
    }

    public void reOrderArray(int[] array) {
        if (array == null || array.length < 1) {
            return;
        }
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            while (!isEven(array[i]) && i <= array.length - 1) {
                i++;
            }
            while (isEven(array[j]) && j >= 0) {
                j--;
            }
            if (i < j) {
                swap(array, i, j);
            } else {
                break;
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
