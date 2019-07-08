package io.lvlvforever;

/**
 * Created by lvlvforever on 2018/7/16.
 */
public class Q10_1 {
    public static void main(String[] args) {
        Q10_1 obj = new Q10_1();
        System.err.println(obj.NumberOf1(10));
    }


    public int NumberOf1(int n) {

        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >>> 1;
        }
        return count;

    }

}
