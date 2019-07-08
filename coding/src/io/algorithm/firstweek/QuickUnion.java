package io.algorithm.firstweek;

/**
 * Created by lvlvforever on 2019/1/19.
 */
public class QuickUnion implements UF {
    private int count;
    private int[] ids;

    public QuickUnion(int n) {

        this.count = n;
        ids = new int[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {

        int i = find(p);
        int j = find(q);
        if (i == j) {
            return;
        }
        ids[j] = i;
        count--;
    }

    @Override
    public int find(int p) {
        while (p != ids[p]) {
            p = ids[p];
        }
        return p;
    }

    @Override
    public boolean connected(int p, int q) {

        return find(p) == find(q);
    }

    @Override
    public int count() {
        return this.count;
    }
}
