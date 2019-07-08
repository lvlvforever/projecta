package io.lvlvforever;

public class Q11_1 {
    public static void main(String[] args) {
        Q11_1 obj = new Q11_1();
        System.err.println(obj.Power(2.0, 0));


    }

    public double Power(double base, int exponent) {
        int absExp = Math.abs(exponent);
        double result = 1.0;
        for (int i = 0; i < absExp; i++) {
            result *= base;
        }
        if (exponent < 0) {
            result = 1 / result;
        }
        return result;
    }
}
