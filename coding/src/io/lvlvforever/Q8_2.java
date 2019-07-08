package io.lvlvforever;

/**
 * Created by lvlvforever on 2018/7/14.
 */
public class Q8_2 {
    public static void main(String[] args) {
        Q8_2 obj = new Q8_2();
        int[] array = {4, 5, 1, 2, 3};
        System.err.println(obj.minNumberInRotateArray(array));

    }

    public int minNumberInRotateArray(int[] array) {
        if (array == null) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }
        int left = 0;
        int right = array.length - 1;
        int mid = left;
        while (array[left] >= array[right]) {
            if (left == right - 1) {
                mid = right;
                break;
            }
            mid = (right - left) / 2 + left;
            if (array[left] == array[right] && array[right] == array[mid]) {
                return findMinInOrder(array, left, right);
            }
            if (array[mid] >= array[left]) {
                left = mid;
            } else {
                right = mid;
            }

        }
        return array[mid];
    }

    private int findMinInOrder(int[] arr, int left, int right) {
        int min = arr[left];
        for (int i = left + 1; i <= right; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }
}
