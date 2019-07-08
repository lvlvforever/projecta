package io.algorithm.firstweek;

/**
 * Created by lvlvforever on 2019/1/19.
 */
public class SuccessorWithDelete {

    private int[] ids;
    private int count;
    private boolean[] isDeleted;

    public SuccessorWithDelete(int n) {
        this.count = n;
        ids = new int[n];
        isDeleted = new boolean[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
            isDeleted[i] = false;
        }
    }

    public static void main(String[] args) {
        SuccessorWithDelete obj = new SuccessorWithDelete(10);
        obj.remove(1);
        obj.remove(2);
        obj.remove(6);
        obj.remove(5);

        System.err.println(obj.getSuccessor(5));
        System.err.println(obj.getSuccessor(2));

    }

    public void union(int p, int q) {

        int i = find(p);
        int j = find(q);
        if (i == j) {
            return;
        }

        if (i > j) {
            ids[j] = i;
        } else {
            ids[i] = j;
        }

        count--;
    }

    public void remove(int p) {
        isDeleted[p] = true;
        int i = find(p);
        if (i > 0 && isDeleted[i - 1]) {
            union(i, i - 1);
        } else if (i < count - 1 && isDeleted[i + 1]) {
            union(i, i + 1);

        }

    }

    public int getSuccessor(int p) {
        if (p < 0 || p > ids.length) {
            return -1;
        } else if (isDeleted[p] && find(p) < ids.length - 1) {
            return find(p) + 1;
        } else {
            return p;
        }

    }

    public int find(int p) {
        while (p != ids[p]) {
            p = ids[p];
        }
        return p;
    }


}
