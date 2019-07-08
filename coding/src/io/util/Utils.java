package io.util;

/**
 * Created by lvlvforever on 2019/1/25.
 */
public class Utils {
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
