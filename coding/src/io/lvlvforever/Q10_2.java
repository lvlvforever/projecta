package io.lvlvforever;

/**
 * Created by lvlvforever on 2018/7/16.
 */
public class Q10_2 {
    public static void main(String[] args) {
        Q10_2 obj = new Q10_2();
        System.err.println(obj.NumberOf1(10));
    }


    public int NumberOf1(int n) {
        int flag = 1;
        int count = 0;
        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

}
