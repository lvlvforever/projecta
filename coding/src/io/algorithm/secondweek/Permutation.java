package io.algorithm.secondweek;

import edu.princeton.cs.algs4.StdIn;

import java.util.Iterator;

/**
 * @author lvlvforever
 * @createTime 2019-02-03 01:37
 * @description
 */
public class Permutation {
    public static void main(String[] args) {
        if (args == null || args.length < 1) {
            return;
        }
        int n = Integer.parseInt(args[0]);

        RandomizedQueue<String> queue = new RandomizedQueue<>();
        for (int i = 0; i < n; i++) {
            queue.enqueue(StdIn.readString());
        }
        Iterator<String> it = queue.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());

        }


    }
}
