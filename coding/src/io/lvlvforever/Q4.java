package io.lvlvforever;

public class Q4 {
    public String replaceSpace(StringBuffer str) {
        if (str == null || str.length() < 1) {
            return "";
        }
        int spaceCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                spaceCount++;
            }
        }
        int length = str.length();
        int finalLength = length + spaceCount * 2;
        int ptr = finalLength - 1;
        str.setLength(finalLength);
        for (int i = length - 1; i >= 0; i--) {

            char ch = str.charAt(i);
            if (ch == ' ') {
                str.setCharAt(ptr--, '0');
                str.setCharAt(ptr--, '2');
                str.setCharAt(ptr--, '%');
            } else {
                str.setCharAt(ptr--, ch);
            }
        }

        return str.toString();
    }
}
