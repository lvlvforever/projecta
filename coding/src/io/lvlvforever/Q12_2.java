package io.lvlvforever;

public class Q12_2 {
    public static void main(String[] args) {
        Q12_2 obj = new Q12_2();
        obj.Print1ToMaxOfNDigits(10);
    }

    public void Print1ToMaxOfNDigits(int n) {
        if (n < 1) {
            return;
        }
        char[] number = new char[n];
        for (int i = 0; i < number.length; i++) {
            number[i] = '0';
        }
        for (int i = 0; i < 10; i++) {
            number[0] = Character.forDigit(i, 10);
            recur(number, 0);
        }
    }

    private void recur(char[] num, int index) {
        if (index == num.length - 1) {
            printNumber(num);
            return;
        }
        for (int i = 0; i < 10; i++) {
            num[index + 1] = Character.forDigit(i, 10);
            recur(num, index + 1);
        }

    }

    private void printNumber(char[] num) {
        System.err.println(num);
    }

}
