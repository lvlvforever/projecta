package io.lvlvforever;

import java.util.Calendar;

/**
 * Created by lvlvforever on 2018/7/16.
 */
public class Q9_1 {
    public static void main(String[] args) {
        long startTime = Calendar.getInstance().getTimeInMillis();
        Q9_1 obj = new Q9_1();
        System.err.println(obj.Fibonacci(100));


        long endTime = Calendar.getInstance().getTimeInMillis();
        System.err.println(endTime - startTime);


    }

    public int Fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }
}
