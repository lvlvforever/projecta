package io.lvlvforever;

public class Q11_3 {
    public static void main(String[] args) {
        Q11_3 obj = new Q11_3();
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
        double result = base;

        boolean isOdd = ((absExp & 1) == 1);
        if (isOdd) {
            absExp = absExp - 1;
        }
        absExp = absExp >> 1;
        while (absExp != 0) {
            result *= result;
            absExp = absExp >> 1;
        }
        if (isOdd) {
            result *= base;
        }
        if (exponent < 0) {
            result = 1 / result;
        }
        Math.pow(base, 10.0);
        return result;

    }


    private boolean isZero(double base) {
        if (Math.abs(base - 0) < 0.0000000001) {
            return true;
        }
        return false;
    }


}
