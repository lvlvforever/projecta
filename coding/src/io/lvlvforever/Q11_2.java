package io.lvlvforever;

public class Q11_2 {
    public static void main(String[] args) {
        Q11_2 obj = new Q11_2();
        System.err.println(obj.Power(-2.0, 3));


    }

    public double Power(double base, int exponent) {
        if (isZero(base)) {
            return 0.0;
        }
        if (exponent == 1) {
            return base;
        } else if (exponent == 0) {
            return 1.0;
        }
        int absExp = Math.abs(exponent);
        double result = 0.0;
        result = compute(base, absExp);
        if (exponent < 0) {
            result = 1 / result;
        }
        return result;

    }

    private double compute(double base, int exp) {
        if (exp == 1) {
            return base;
        } else if (exp == 0) {
            return 1.0;
        }
        double result = compute(base, exp >> 1);
        result *= result;
        if ((exp & 0x1) == 1) {
            result *= base;
        }
        return result;

    }

    private boolean isZero(double base) {
        if (Math.abs(base - 0) < 0.0000000001) {
            return true;
        }
        return false;
    }

}
