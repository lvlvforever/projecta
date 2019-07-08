package io.lvlvforever;

/**
 * Created by lvlvforever on 2018/7/16.
 */
public class Q10_3 {
    public static void main(String[] args) {
        Q10_3 obj = new Q10_3();
        System.err.println(obj.NumberOf1(10));
    }


    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }

}
