package io.lvlvforever;

import java.util.Arrays;

/**
 * Created by lvlvforever on 2018/7/18.
 */
public class Q14_3 {
    private int[] aux;

    public static void main(String[] args) {
        Q14_3 obj = new Q14_3();
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        obj.reOrderArray(a);
    }

    public void reOrderArray(int[] array) {
        if (array == null || array.length < 1) {
            return;
        }
        aux = Arrays.copyOf(array, array.length);
        merge(array, 0, array.length - 1);

        System.err.println(Arrays.toString(array));
    }

    private void merge(int[] array, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = (hi - lo) / 2 + lo;
        merge(array, lo, mid);
        merge(array, mid + 1, hi);
        merge(array, lo, mid, hi);
    }

    private void merge(int[] array, int lo, int mid, int hi) {
        if (lo >= hi) {
            return;
        }
        for (int k = lo; k <= hi; k++) {
            aux[k] = array[k];
        }

        int i = lo;
        for (int k = lo; k <= hi; k++) {
            if (!isEven(aux[k])) {
                array[i++] = aux[k];
            }
        }
        for (int k = lo; k <= hi; k++) {
            if (isEven(aux[k])) {
                array[i++] = aux[k];
            }
        }
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
