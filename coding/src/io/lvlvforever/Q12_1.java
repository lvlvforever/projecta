package io.lvlvforever;

public class Q12_1 {

    public static void main(String[] args) {
        Q12_1 obj = new Q12_1();
        obj.Print1ToMaxOfNDigits(5);
    }

    public void Print1ToMaxOfNDigits(int n) {
        if (n < 1) {
            return;
        }
        char[] number = new char[n];
        for (int i = 0; i < number.length; i++) {
            number[i] = '0';
        }
        int count = 0;
        while (incrementNumber(number, n)) {
            printNumber(number);
            count++;
        }
        System.err.println("count = " + count);
    }

    private void printNumber(char[] num) {
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < num.length; i++) {
            if (flag == true) {
                sb.append(num[i]);
            } else if (num[i] != '0') {
                sb.append(num[i]);
                flag = true;
            }
        }
        System.err.println(sb);
    }

    private boolean incrementNumber(char[] number, int n) {
        int cur = n - 1;
        while (cur >= 0) {
            char num = number[cur];
            if (num < '9') {
                number[cur] = (char) (num + 1);
                return true;
            } else if (num == '9') {
                number[cur] = '0';
                cur--;
            }
        }
        return false;
    }


}
