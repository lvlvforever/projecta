package io.lvlvforever;

/**
 * Created by lvlvforever on 2018/7/16.
 */
public class Q9_b_1 {
    public int JumpFloor(int target) {
        if (target == 1 || target == 2) {
            return target;
        }
        int first = 1;
        int second = 2;
        int third = 0;
        for (int i = 3; i <= target; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return third;

    }
}
