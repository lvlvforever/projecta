import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * Created by lvlvforever on 2019/1/27.
 */
public class Percolation {
    private WeightedQuickUnionUF uf;
    private boolean[] open;
    private int numberOfOpenSites = 0;
    private boolean[] connectTop;
    private boolean[] connectBottom;
    private int N;
    private int size;
    private boolean percolates = false;

    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException(" n should bigger than 0");
        }
        size = n;
        N = n * n + 1;
        uf = new WeightedQuickUnionUF(N);
        connectTop = new boolean[N];
        connectBottom = new boolean[N];
        open = new boolean[N];
    }

    public void open(int row, int col) {
        validate(row, col);
        int index = convertIndex(row, col);
        if (isOpen(row, col)) {
            return;
        }
        numberOfOpenSites++;
        open[index] = true;
        boolean top = false;
        boolean bottom = false;
        if (row > 1 && open[index - size]) {
            int root = uf.find(index - size);
            if (connectTop[root]) {
                top = true;
            }
            if (connectBottom[root]) {
                bottom = true;
            }
            uf.union(index, index - size);
        }
        if (row < size && open[index + size]) {
            int root = uf.find(index + size);
            if (connectTop[root]) {
                top = true;
            }
            if (connectBottom[root]) {
                bottom = true;
            }
            uf.union(index, index + size);

        }
        if (col > 1 && open[index - 1]) {
            int root = uf.find(index - 1);
            if (connectTop[root]) {
                top = true;
            }
            if (connectBottom[root]) {
                bottom = true;
            }
            uf.union(index, index - 1);

        }
        if (col < size && open[index + 1]) {
            int root = uf.find(index + 1);
            if (connectTop[root]) {
                top = true;
            }
            if (connectBottom[root]) {
                bottom = true;
            }
            uf.union(index, index + 1);

        }
        if (row == 1) {
            top = true;
        }
        if (row == size) {

            bottom = true;
        }
        int root = uf.find(index);
        connectBottom[root] = bottom;
        connectTop[root] = top;
        if (bottom == true && top == true) {
            percolates = true;
        }
    }


    public boolean isOpen(int row, int col) {
        validate(row, col);
        int index = convertIndex(row, col);
        return open[index];
    }

    private void validate(int row, int col) {
        if (row < 1 || row > size || col < 1 || col > size) {
            throw new IllegalArgumentException("row or col exceed");
        }
    }

    public boolean isFull(int row, int col) {
        int root = uf.find(convertIndex(row, col));
        return connectTop[root];
    }

    public int numberOfOpenSites() {
        return numberOfOpenSites;
    }

    public boolean percolates() {
        return percolates;
    }

    private Integer convertIndex(int row, int col) {
        return (row - 1) * size + col;
    }

}
