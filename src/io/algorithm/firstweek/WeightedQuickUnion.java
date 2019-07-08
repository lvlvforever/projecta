package io.algorithm.firstweek;

/**
 * Created by lvlvforever on 2019/1/19.
 */
public class WeightedQuickUnion implements UF {
    private int count;
    private int[] ids;
    private int[] sz; // for weighted union find,store the site size for each root site


    public WeightedQuickUnion(int n) {

        this.count = n;
        ids = new int[n];
        sz = new int[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
            sz[i] = 1;
        }
    }

    @Override
    public void union(int p, int q) {

        int i = find(p);
        int j = find(q);
        if (i == j) {
            return;
        }
        if (sz[i] < sz[j]) {
            ids[i] = j;
            sz[j] += sz[i];
        } else {
            ids[j] = i;
            sz[i] += sz[j];
        }
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
