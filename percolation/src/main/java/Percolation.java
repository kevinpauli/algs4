public class Percolation {

	WeightedQuickUnionUF uf;
	int n;
	int virtualTop;
	int virtualBottom;
	boolean[] siteOpen;

	// create N-by-N grid, with all sites blocked
	public Percolation(int n) {
		this.n = n;
		int gridSize = n * n;
		siteOpen = new boolean[gridSize];
		virtualTop = gridSize;
		virtualBottom = gridSize + 1;
		uf = new WeightedQuickUnionUF(gridSize + 2);
	}

	// open site (row i, column j) if it is not already
	public void open(int i, int j) {
		checkIndices(i, j);
		
		if (isOpen(i, j))
			return;

		int thisIndex = getIndex(i, j);

		// if top row, union to virtual top
		if (i == 1)
			uf.union(virtualTop, thisIndex);
		// if site above is open, union them
		else if (isOpen(i - 1, j))
			uf.union(thisIndex, getIndex(i - 1, j));
		
		// if there is a column to the right
		if (j < n) {
			// if site to the right is open, union them
			if (isOpen(i, j+1))
				uf.union(thisIndex, getIndex(i, j+1));
		}

		// if there is a column to the left
		if (j > 1) {
			// if site to the left is open, union them
			if (isOpen(i, j-1))
				uf.union(thisIndex, getIndex(i, j-1));
		}

		// if bottom row, union to virtual bottom
		if (i == n)
			uf.union(virtualBottom, thisIndex);
		// if site below is open, union them
		else if (isOpen(i + 1, j))
			uf.union(thisIndex, getIndex(i + 1, j));

		siteOpen[getIndex(i, j)] = true;
	}

	// is site (row i, column j) open?
	public boolean isOpen(int i, int j) { 
		checkIndices(i, j);
		return siteOpen[getIndex(i, j)];
	}

	// is site (row i, column j) full?
	public boolean isFull(int i, int j) {
		checkIndices(i, j);
		return uf.connected(virtualTop, getIndex(i, j));
	}

	// does the system percolate?
	public boolean percolates() {
		return uf.connected(virtualTop, virtualBottom);
	}

	private int getIndex(int row, int column) {
		return (row - 1) * n + (column - 1);
	}
	
	private void checkIndices(int i, int j) {
		if (i < 1 || j < 1 || i > n || j > n)
			throw new IndexOutOfBoundsException();
	}
}
