package io.lvlvforever;

import java.util.Calendar;

/**
 * Created by lvlvforever on 2018/7/16.
 */
public class Q9_2 {

    public static void main(String[] args) {
        long startTime = Calendar.getInstance().getTimeInMillis();
        Q9_2 obj = new Q9_2();
        System.err.println(obj.Fibonacci(100));


        long endTime = Calendar.getInstance().getTimeInMillis();
        System.err.println(endTime - startTime);
    }

    public int Fibonacci(int n) {
        int first = 0;
        int second = 1;
        int result = 0;
        if (n == 0 || n == 1) {
            return n;
        }
        for (int i = 2; i <= n; i++) {
            result = first + second;
            first = second;
            second = result;
        }
        return result;
    }
}
