package io.lvlvforever;

import java.util.Stack;

/**
 * Created by lvlvforever on 2018/8/2.
 */
public class Q21 {
    Stack<Integer> mainStack = new Stack();
    Stack<Integer> auxStack = new Stack();


    public void push(int node) {
        mainStack.push(node);
        if (auxStack.isEmpty()) {
            auxStack.push(node);
        } else {
            int curMin = auxStack.peek();
            int min = curMin > node ? node : curMin;
            auxStack.push(min);
        }
    }

    public void pop() {
        if (!mainStack.isEmpty()) {
            auxStack.pop();
            mainStack.pop();
        }
    }

    public int top() {
        if (!mainStack.isEmpty()) {
            return mainStack.peek();
        }
        return -1;
    }

    public int min() {
        if (!auxStack.isEmpty()) {
            return auxStack.peek();
        }
        return -1;
    }
}
