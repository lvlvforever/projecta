package io.lvlvforever;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.Instant;
import java.util.stream.LongStream;

public class Utils {
    //前序遍历二叉树
    public static void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        System.err.println(node.val);
        traverse(node.left);
        traverse(node.right);
    }

    public static void main(String[] args) {
        Instant begin1 = Instant.now();

        long sum = LongStream.rangeClosed(0l, 100).reduce(0, Long::sum);
        Instant end1 = Instant.now();
        System.err.println(end1.toEpochMilli() - begin1.toEpochMilli());
        Instant begin2 = Instant.now();
        long sum2 = LongStream.rangeClosed(0l, 100).parallel().reduce(0, Long::sum);

        Instant end2 = Instant.now();
        System.err.println(end2.toEpochMilli() - begin2.toEpochMilli());

        StringBuilder sb = new StringBuilder();
        try {
            System.err.println(URLEncoder.encode("=", "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}
