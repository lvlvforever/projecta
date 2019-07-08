package io.algorithm.firstweek;

/**
 * Created by lvlvforever on 2019/1/19.
 */
public interface UF {
    void union(int p, int q);

    int find(int p);

    boolean connected(int p, int q);

    int count();

}
