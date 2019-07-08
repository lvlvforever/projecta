package io.algorithm.firstweek;

/**
 * Created by lvlvforever on 2019/1/19.
 */
public class FindSocial {

    private int[] id; // user ids
    private int[] sz; // for weighted union find,store the site size for each root site
    private int count;// connected components count

    public FindSocial(int n) {

        id = new int[n];
        sz = new int[n];
        count = n;

        for (int i = 0; i < n; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }


    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    /**
     * @param p
     * @param q
     * @param timestamp
     * @return
     */
    public long union(int p, int q, long timestamp) {

        int i = find(p);
        int j = find(q);
        if (i == j) {
            return -1;
        }

        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
        count--;
        if (count == 1) {
            return timestamp;
        }
        return -1;
    }
}
