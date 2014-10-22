/**
 * Author: nitish
 * Date: 2/11/14 7:24 AM
 * Description:
 */
public class PercolationStats {
    private double[] pThreshold;
    private int threshold;

    // perform T independent computational experiments on an N-by-N grid
    public PercolationStats(int N, int T) {
        if (N <= 0 || T <= 0)
            throw new IllegalArgumentException();

        threshold = T;
        pThreshold = new double[T];
        double percolationCount = 0;

        for (int i = 0; i < T; i++) {
            Percolation grid = new Percolation(N);
            while (!grid.percolates()) {
                // Starts from 0 add one
                int x = StdRandom.uniform(N) + 1;
                int y = StdRandom.uniform(N) + 1;
                if (!grid.isOpen(x, y)) {
                    grid.open(x, y);
                    percolationCount++;
                }
            }
            // force floating point math
            pThreshold[i] = percolationCount / (N * N);
        }
    }

    // test client, described below
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);

        PercolationStats percolationStats = new PercolationStats(N, T);
        System.out.println("mean                    = " + percolationStats.mean());
        System.out.println("stddev                  = " + percolationStats.stddev());
        System.out.println("95% confidence interval = " + percolationStats.confidenceLo() + ", " + percolationStats.confidenceHi());
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(pThreshold);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(pThreshold);
    }

    // returns lower bound of the 95% confidence interval
    public double confidenceLo() {
        return mean() - (1.96 * stddev()) / Math.sqrt(threshold);
    }

    // returns upper bound of the 95% confidence interval
    public double confidenceHi() {
        return mean() + (1.96 * stddev()) / Math.sqrt(threshold);
    }
}