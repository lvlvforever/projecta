import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/**
 * Created by lvlvforever on 2019/1/27.
 */
public class PercolationStats {
    private double[] result;

    public PercolationStats(int n, int trials) {
        result = new double[trials];
        for (int i = 0; i < trials; i++) {
            result[i] = runOnce(n);
        }


    }

    public static void main(String[] args) {
        PercolationStats stats = new PercolationStats(200, 100);
        System.err.println("mean                     =  " + stats.mean());
        System.err.println("stddev                   =  " + stats.stddev());
        System.err.println("95% confidence interval  =  " + stats.confidenceLo() + ", " + stats.confidenceHi());

    }

    private double runOnce(int size) {
        Percolation percolation = new Percolation(size);
        int openSites = 0;
        do {
            int row = StdRandom.uniform(1, size + 1);
            int col = StdRandom.uniform(1, size + 1);
            if (!percolation.isOpen(row, col)) {
                percolation.open(row, col);
                openSites++;
            }
        } while (!percolation.percolates());
        return openSites / ((double) size * size);

    }

    public double mean() {
        return StdStats.mean(result);
    }

    public double stddev() {
        return StdStats.stddev(result);
    }

    public double confidenceLo() {
        return mean() - confidence();
    }

    private double confidence() {
        return (1.96 * stddev() / Math.sqrt(result.length));
    }

    public double confidenceHi() {
        return mean() + confidence();
    }
}
