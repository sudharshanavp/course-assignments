import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private static final double CONFIDENCE_FACTOR = 1.96; 
    private final double[] experimentData;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0)
            throw new IllegalArgumentException();
        experimentData = new double[trials];
        for (int i = 0; i < experimentData.length; i++) {
            experimentData[i] = experimentResult(n);
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(experimentData);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(experimentData);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return (mean() - (CONFIDENCE_FACTOR * stddev())/Math.sqrt(experimentData.length));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return (mean() + (CONFIDENCE_FACTOR * stddev())/Math.sqrt(experimentData.length));
    }

    private double experimentResult(int n) {
        Percolation percolatorMatrix = new Percolation(n);
        while (!percolatorMatrix.percolates()) {
            int row = StdRandom.uniform(1, n + 1);
            int col = StdRandom.uniform(1, n + 1);
            if (!percolatorMatrix.isOpen(row, col)) {
                percolatorMatrix.open(row, col);
            }
        }
        int openSites = percolatorMatrix.numberOfOpenSites();
        double percolationThreshold = (double) (openSites)/(n * n);
        return percolationThreshold;
    }

    // test client (see below)
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        PercolationStats percolator = new PercolationStats(n, trials);

        String confidence = "[" + percolator.confidenceLo() + ", " + percolator.confidenceHi() + "]";
        StdOut.println("mean                    = " + percolator.mean());
        StdOut.println("sttdev                  = " + percolator.stddev());
        StdOut.println("95% confidence interval = " + confidence);   
    }

}