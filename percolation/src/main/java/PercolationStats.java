public class PercolationStats {

	private int N;
	private int T;
	private double[] results;

	// perform T independent computational experiments on an N-by-N grid
	public PercolationStats(int N, int T) {
		if (N < 1 || T < 1)
			throw new IllegalArgumentException();
		this.N = N;
		this.T = T;
		results = new double[T];
		for (int i = 0; i < T; i++) {
			results[i] = runExperiment();
		}
	}

	private double runExperiment() {
		Percolation p = new Percolation(N);
		int openSiteCount = 0;
		int row;
		int col;
		do {
			row = StdRandom.uniform(N) + 1;
			col = StdRandom.uniform(N) + 1;
			if (!p.isOpen(row, col)) {
				p.open(row, col);
				openSiteCount++;
			}
		} while (!p.percolates());

		double threshold = ((double) openSiteCount) / (N * N);
		return threshold;
	}

	// sample mean of percolation threshold
	public double mean() {
		return StdStats.mean(results);
	}

	// sample standard deviation of percolation threshold
	public double stddev() {
		return StdStats.stddev(results);
	}

	// returns lower bound of the 95% confidence interval
	public double confidenceLo() {
		return mean() - (1.96 * stddev()) / Math.sqrt(T);
	}

	// returns upper bound of the 95% confidence interval
	public double confidenceHi() {
		return mean() + (1.96 * stddev()) / Math.sqrt(T);
	}

	public static void main(String[] args) {
		PercolationStats ps = new PercolationStats(Integer.parseInt(args[0]),
				Integer.parseInt(args[1]));
		System.out.println("mean                    = " + ps.mean());
		System.out.println("stddev                  = " + ps.stddev());
		System.out.println("95% confidence interval = " + ps.confidenceLo()
				+ ", " + ps.confidenceHi());
	}

}
