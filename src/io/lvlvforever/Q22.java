package io.lvlvforever;

import java.util.Stack;

public class Q22 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA == null || popA == null) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int j = 0;

        for(int i = 0; i < pushA.length; i++){
            if(pushA[i] == popA[j]){
                j++;
                continue;
            }
            stack.push(pushA[i]);

        }
        while (!stack.isEmpty()) {
            if (stack.pop() != popA[j++]) {
                return false;
            }
        }
        return true;
    }
}
